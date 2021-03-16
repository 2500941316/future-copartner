package com.shu.copartner.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProCarouselMapper;
import com.shu.copartner.pojo.ProActivity;
import com.shu.copartner.pojo.ProCarousel;
import com.shu.copartner.pojo.ProCarouselExample;
import com.shu.copartner.service.UserCarouselService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author
 * @date 2021/3/9 20:23
 * @description
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class UserCarouselServiceImpl implements UserCarouselService {

    @Autowired
    private ProCarouselMapper proCarouselMapper;

    /**
     * 查询首页轮播图
     * @return
     */
    @Override
    public TableModel searchIndexCarouselImg() {
        try{

            // 每次只查询5张轮播图，并且按照上传时间倒序
            PageHelper.startPage(1,5);
            ProCarouselExample proCarouselExample = new ProCarouselExample();
            proCarouselExample.setOrderByClause("upload_date desc");// 按照上传时间倒序
            proCarouselExample.createCriteria().andIsIssueEqualTo(1).andIsDeletedEqualTo(0)
                    .andCarouselTypeEqualTo(0);
            List<ProCarousel> proCarouselList = proCarouselMapper.selectByExample(proCarouselExample);
            PageInfo pageInfo = new PageInfo(proCarouselList);
            return TableModel.success(proCarouselList,(int)pageInfo.getTotal());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询公共页轮播图
     * @return
     */
    @Override
    public TableModel searchPublicCarouselImg() {
        try{
            // 每次只查询5张轮播图，并且按照上传时间倒序
            PageHelper.startPage(1,5);
            ProCarouselExample proCarouselExample = new ProCarouselExample();
            proCarouselExample.setOrderByClause("upload_date desc");// 按照上传时间倒序
            proCarouselExample.createCriteria().andIsIssueEqualTo(1).andIsDeletedEqualTo(0)
                    .andCarouselTypeEqualTo(1);
            List<ProCarousel> proCarouselList = proCarouselMapper.selectByExample(proCarouselExample);
            PageInfo pageInfo = new PageInfo(proCarouselList);
            return TableModel.success(proCarouselList,(int)pageInfo.getTotal());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询所有广告图表格
     * @param page
     * @return
     */
    @Override
    public TableModel searchAllCarousel(int page) {
        try{
            // 表格一次最多查10条
            PageHelper.startPage(page,10);
            ProCarouselExample proCarouselExample = new ProCarouselExample();
            proCarouselExample.setOrderByClause("carousel_type desc,upload_date desc");// 按照上传类型，上传时间倒序
            proCarouselExample.createCriteria().andIsDeletedEqualTo(0);
            List<ProCarousel> proCarouselList = proCarouselMapper.selectByExample(proCarouselExample);
            PageInfo pageInfo = new PageInfo(proCarouselList);
            return TableModel.tableSuccess(proCarouselList,(int)pageInfo.getTotal());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }


    /**
     * 设置状态
     * @param carouselId
     * @param isIssue
     * @return
     */
    @Override
    public TableModel updateCarouselStatus(String carouselId, String isIssue) {
        try{
            // 更新 广告表状态
            ProCarousel proCarousel = proCarouselMapper.selectByPrimaryKey(Long.parseLong(carouselId));
            proCarousel.setIsIssue(Integer.parseInt(isIssue));
            proCarouselMapper.updateByPrimaryKeySelective(proCarousel);
            return TableModel.success();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 删除广告图
     * @param carouselId
     * @return
     */
    @Override
    public TableModel deleteCarouselById(String carouselId) {
        try{
            // 更新 广告表 删除状态
            ProCarousel proCarousel = proCarouselMapper.selectByPrimaryKey(Long.parseLong(carouselId));
            proCarousel.setIsDeleted(1);
            proCarousel.setDeleteDate(new Date());
            proCarouselMapper.updateByPrimaryKeySelective(proCarousel);
            return TableModel.success();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }
}
