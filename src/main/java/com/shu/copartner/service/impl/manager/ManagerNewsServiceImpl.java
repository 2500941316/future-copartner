package com.shu.copartner.service.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProNewsMapper;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author cxy
 * @Date: 2020/12/21 15:19
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ManagerNewsServiceImpl implements ManagerNewsService {

    @Autowired
    ProNewsMapper proNewsMapper;

    @Autowired
    private ProUserMapper proUserMapper;


    @Override
    public TableModel searchNewsApplication(int page) {
        List<ProNews> arrayList = new ArrayList<>();
        int count;
        try {
            ProNewsExample proNewsExample = new ProNewsExample();
            PageHelper.startPage(page, Constants.PAGESIZE);
            proNewsExample.createCriteria().andIsdeletedEqualTo(Constants.NO_DELETED)
                    .andIsauditEqualTo(Constants.NO_DELETED);
            arrayList = proNewsMapper.selectByExample(proNewsExample);
            PageInfo pageInfo = new PageInfo(arrayList, 5);
            count = (int) pageInfo.getTotal();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.tableSuccess(arrayList, count);
    }


    @Override
    public TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO) {
        //更新新闻状态:如果status值为1，则表示同意否则就是驳回
        ProNewsWithBLOBs proNewsWithBLOBs = new ProNewsWithBLOBs();
        BeanUtils.copyProperties(newsManagerOperationVO, proNewsWithBLOBs);
        proNewsWithBLOBs.setNewsId(Long.parseLong(newsManagerOperationVO.getNewsId()));
        try {
            proNewsMapper.updateByPrimaryKeySelective(proNewsWithBLOBs);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.success();
    }

    /**
     * 管理员发布精彩上大新闻
     *
     * @param newsPublishVO
     * @return
     */
    @Override
    public TableModel publisSHUNews(NewsPublishVO newsPublishVO) {
        // 根据用户手机号查询出其姓名
        ProUserExample proUserExample = new ProUserExample();
        proUserExample.createCriteria().andPhoneEqualTo(newsPublishVO.getNewsAuthor());
        List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
        String authorName = proUsers.get(0).getName();

        //补全用户提交的信息和时间
        newsPublishVO.setNewsPublistime(new Date());
        newsPublishVO.setNewsAuthor(authorName);
        newsPublishVO.setIstopping("1"); // 代表是 精彩上大新闻 而不是帖子
        newsPublishVO.setIsaudit("1"); // 代表 已审核通过，直接发表
        newsPublishVO.setNewsCategory("精彩上大");// 新闻的标签固定为 ’精彩上大‘
        try {
            //将新闻插入新闻表中，状态isAuth置为0
            ProNewsWithBLOBs proNewsWithBLOBs = new ProNewsWithBLOBs();
            //生成主键插入：作者+时间戳
            BeanUtils.copyProperties(newsPublishVO, proNewsWithBLOBs);
            //插入新闻
            proNewsMapper.insert(proNewsWithBLOBs);
            return TableModel.success();

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 查询所有帖子新闻
     *
     * @param page
     * @return
     */
    @Override
    public TableModel searchAllNews(int page) {
        List<ProNews> arrayList = new ArrayList<>();
        int count;
        try {
            List<String> strings = new ArrayList<>();
            strings.add("1");
            strings.add("3");
            ProNewsExample proNewsExample = new ProNewsExample();
            PageHelper.startPage(page, Constants.PAGESIZE);
            proNewsExample.setOrderByClause("news_publisTime desc,isTopping desc");
            proNewsExample.createCriteria().andIsdeletedEqualTo(Constants.NO_DELETED)
                    .andIsauditIn(strings); // 1代表已审核通过发表的，3代表已撤回的
            arrayList = proNewsMapper.selectByExample(proNewsExample);
            PageInfo pageInfo = new PageInfo(arrayList, 5);
            count = (int) pageInfo.getTotal();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
        return TableModel.tableSuccess(arrayList, count);
    }

    /**
     * 发布/撤回 新闻或帖子
     *
     * @param newsId
     * @param isaudit
     * @return
     */
    @Override
    public TableModel updateNewsAudit(String newsId, String isaudit) {
        try {
            ProNews proNews = proNewsMapper.selectByPrimaryKey(Long.parseLong(newsId));
            if ("1".equals(isaudit)) {
                // 发布
                proNews.setIsaudit(isaudit);
                proNews.setNewsPublistime(new Date());
            } else if ("3".equals(isaudit)) {
                // 撤回
                proNews.setIsaudit(isaudit);
            } else if ("9".equals(isaudit)) {
                // 删除
                proNews.setIsdeleted("1");
            }
            ProNewsWithBLOBs proNewsWithBLOBs = new ProNewsWithBLOBs();
            BeanUtils.copyProperties(proNews, proNewsWithBLOBs);
            proNewsMapper.updateByPrimaryKeySelective(proNewsWithBLOBs);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }
}
