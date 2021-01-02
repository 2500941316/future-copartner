package com.shu.copartner.service.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProLeassonMapper;
import com.shu.copartner.mapper.ProLeassonVedioMapper;
import com.shu.copartner.pojo.ProLeasson;
import com.shu.copartner.pojo.ProLeassonExample;
import com.shu.copartner.pojo.ProLeassonVedio;
import com.shu.copartner.pojo.ProLeassonVedioExample;
import com.shu.copartner.pojo.request.LeassonApplyVO;
import com.shu.copartner.pojo.request.LeassonVedioUpdateVO;
import com.shu.copartner.pojo.response.LeassonVedioInfoSo;
import com.shu.copartner.service.ManagerLeassonService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.fastdfs.FastDfsClient;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ManagerLeassonServiceImpl implements ManagerLeassonService {

    @Autowired
    ProLeassonMapper proLeassonMapper;

    @Autowired
    ProLeassonVedioMapper proLeassonVedioMapper;

    @Override
    public TableModel applyLeasson(LeassonApplyVO leassonApplyVO) {
        try {
            ProLeasson proLeasson = new ProLeasson();
            BeanUtils.copyProperties(leassonApplyVO, proLeasson);
            proLeassonMapper.insert(proLeasson);
            //在vedio表中创建对应的子记录
            for (Integer i = 1; i <= proLeasson.getCourseTotalblocks(); i++) {
                ProLeassonVedio proLeassonVedio = new ProLeassonVedio();
                proLeassonVedio.setCourseId(proLeasson.getCourseId());
                proLeassonVedio.setCourseVedioNumber(i);
                proLeassonVedio.setCourseVedioStatus("1");
                proLeassonVedio.setCourseVedioIsdeleted("0");
                proLeassonVedioMapper.insert(proLeassonVedio);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }


    @Override
    public TableModel getLeassonInfo(int page) {
        PageHelper.startPage(page, Constants.PAGESIZE);
        try {
            int index = 0;
            ProLeassonExample newProLeassonExample = new ProLeassonExample();
            newProLeassonExample.createCriteria().andCourseIsdeletedEqualTo(Constants.NO_DELETED);
            List<ProLeasson> proLeassons = proLeassonMapper.selectByExample(newProLeassonExample);
            List<LeassonVedioInfoSo> leassonInfoSoList = new ArrayList<>();
            PageInfo pageInfo = new PageInfo(proLeassons);
            for (ProLeasson proLeasson : proLeassons) {
                LeassonVedioInfoSo leassonVedioInfoSo = new LeassonVedioInfoSo();
                BeanUtils.copyProperties(proLeasson, leassonVedioInfoSo);
                leassonVedioInfoSo.setId(++index);
                leassonVedioInfoSo.setPid(-1);
                leassonInfoSoList.add(leassonVedioInfoSo);

                //根据leasson列表去获取每个课程下面的信息
                ProLeassonVedioExample proLeassonExample = new ProLeassonVedioExample();
                //按照章节号排序
                proLeassonExample.setOrderByClause(Constants.LEASSON_ASCBYNUMBER);
                proLeassonExample.createCriteria().andCourseIdEqualTo(leassonVedioInfoSo.getCourseId());
                List<ProLeassonVedio> proLeassonVedios = proLeassonVedioMapper.selectByExample(proLeassonExample);

                for (ProLeassonVedio proLeassonVedio : proLeassonVedios) {
                    LeassonVedioInfoSo vedioInfoSo = new LeassonVedioInfoSo();
                    BeanUtils.copyProperties(leassonVedioInfoSo, vedioInfoSo);
                    BeanUtils.copyProperties(proLeassonVedio, vedioInfoSo);

                    //处理状态信息
                    if (vedioInfoSo.getCourseVedioPptUrl() != null && vedioInfoSo.getCourseVedioUrl() != null) {
                        vedioInfoSo.setStatus(Constants.LEASSON_FILESTATUS_FINE);
                    } else {
                        vedioInfoSo.setStatus(Constants.LEASSON_FILESTATUS_NOPPT);
                    }
                    vedioInfoSo.setPid(index);
                    vedioInfoSo.setId(null);
                    leassonInfoSoList.add(vedioInfoSo);
                }
            }
            return TableModel.tableSuccess(leassonInfoSoList, (int) pageInfo.getTotal());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }


    @Override
    public TableModel updateLeasson(LeassonVedioUpdateVO leassonVedioUpdateVO) {
        try {
            ProLeassonVedio proLeassonVedio = new ProLeassonVedio();
            BeanUtils.copyProperties(leassonVedioUpdateVO, proLeassonVedio);
            proLeassonVedioMapper.updateByPrimaryKeySelective(proLeassonVedio);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }


    @Override
    public TableModel deleteLeasson(String courseId) {
        //先删除视频表中的每个章节,将删除标志位置为1
        ProLeassonVedioExample proLeassonVedioExample = new ProLeassonVedioExample();
        proLeassonVedioExample.createCriteria().andCourseIdEqualTo(Long.parseLong(courseId));
        ProLeassonVedio proLeassonVedio = new ProLeassonVedio();
        proLeassonVedio.setCourseId(Long.parseLong(courseId));
        proLeassonVedio.setCourseVedioIsdeleted(Constants.BE_DELETED);
        try {
            proLeassonVedioMapper.updateByExampleSelective(proLeassonVedio, proLeassonVedioExample);

            //删除课程表的记录，删除标志位置为1
            ProLeasson proLeasson = new ProLeasson();
            proLeasson.setCourseId(Long.parseLong(courseId));
            proLeasson.setCourseIsdeleted(Constants.BE_DELETED);
            proLeassonMapper.updateByPrimaryKeySelective(proLeasson);


            //删除课程对应的视频
            List<ProLeassonVedio> proLeassonVedios = proLeassonVedioMapper.selectByExample(proLeassonVedioExample);
            for (ProLeassonVedio leassonVedio : proLeassonVedios) {
                if (StringUtils.isNotEmpty(leassonVedio.getCourseVedioUrl())) {
                    FastDfsClient.deleteFile(Constants.FASTDFSGROUPNAME, leassonVedio.getCourseVedioUrl().substring(Constants.FASTDFSSUBSTRLEN));
                }
                if (StringUtils.isNotEmpty(leassonVedio.getCourseVedioPptUrl())) {
                    FastDfsClient.deleteFile(Constants.FASTDFSGROUPNAME, leassonVedio.getCourseVedioPptUrl().substring(Constants.FASTDFSSUBSTRLEN));
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }
}