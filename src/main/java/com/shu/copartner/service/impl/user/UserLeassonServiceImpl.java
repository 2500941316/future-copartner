package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProLeassonMapper;
import com.shu.copartner.mapper.ProLeassonTaskMapper;
import com.shu.copartner.mapper.ProLeassonVedioMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.response.LeassonCourse_Vedio_InfoSo;
import com.shu.copartner.service.UserLeassonService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserLeassonServiceImpl implements UserLeassonService {

    @Autowired
    private ProLeassonMapper proLeassonMapper;

    @Autowired
    private ProLeassonVedioMapper proLeassonVedioMapper;

    @Autowired
    private ProLeassonTaskMapper proLeassonTaskMapper;

    @Override
    public TableModel getLeassonInfo() {
        ProLeassonExample proLeassonExample = new ProLeassonExample();
        proLeassonExample.createCriteria().andCourseIsdeletedEqualTo(Constants.NO_DELETED);
        try {
            List<ProLeasson> proLeassons = proLeassonMapper.selectByExample(proLeassonExample);
            return TableModel.success(proLeassons, proLeassons.size());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    @Override
    public TableModel getcourseInfoVedio(Long courseId) {
        LeassonCourse_Vedio_InfoSo leassonCourseVedioInfoSo = new LeassonCourse_Vedio_InfoSo();
        try {
            //查询课程的全部信息
            ProLeasson proLeasson = proLeassonMapper.selectByPrimaryKey(courseId);

            //如果课程已经删除则直接返回
            if (proLeasson == null || proLeasson.getCourseIsdeleted().equals(Constants.BE_DELETED)) {
                return TableModel.error();
            }

            BeanUtils.copyProperties(proLeasson, leassonCourseVedioInfoSo);

            //查询所有子目录的信息
            ProLeassonVedioExample proLeassonVedioExample = new ProLeassonVedioExample();
            proLeassonVedioExample.setOrderByClause(Constants.LEASSON_ASCBYNUMBER);
            proLeassonVedioExample.createCriteria().andCourseIdEqualTo(courseId).andCourseVedioUrlIsNotNull();// .andCourseVedioPptUrlIsNotNull()
            List<ProLeassonVedio> proLeassonVedios = proLeassonVedioMapper.selectByExample(proLeassonVedioExample);
            leassonCourseVedioInfoSo.setVedioList(proLeassonVedios);

            //将课程的点击数+1
            proLeasson.setCourseClicktime(proLeasson.getCourseClicktime() + 1);
            proLeassonMapper.updateByPrimaryKeySelective(proLeasson);

            //查询点击数最多的课程名单
            ProLeassonExample proLeassonExample = new ProLeassonExample();
            proLeassonExample.setOrderByClause(Constants.LEASSON_DESCBYCLICKTIMES);
            proLeassonExample.createCriteria().andCourseIsdeletedEqualTo(Constants.NO_DELETED);
            PageHelper.startPage(1, Constants.LEASSON_CLICKNUMBER);
            List<ProLeasson> proLeassons = proLeassonMapper.selectByExample(proLeassonExample);
            leassonCourseVedioInfoSo.setClickCourseList(proLeassons);

            //查询作业信息
            ProLeassonTaskExample proLeassonTaskExample = new ProLeassonTaskExample();
            proLeassonTaskExample.setOrderByClause(Constants.LEASSON_ASCBYPUBLISHDATE);
            proLeassonTaskExample.createCriteria().andIsDeletedEqualTo(0).andCourseIdEqualTo(courseId);
            List<ProLeassonTask> proLeassonTasks = proLeassonTaskMapper.selectByExample(proLeassonTaskExample);
            leassonCourseVedioInfoSo.setTaskList(proLeassonTasks);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success(leassonCourseVedioInfoSo, 1);
    }
}
