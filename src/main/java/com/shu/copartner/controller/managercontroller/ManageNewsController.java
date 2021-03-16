package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@RestController
@RequestMapping("manager/news")
@CrossOrigin
@Slf4j
public class ManageNewsController {

    @Autowired
    ManagerNewsService managerNewsService;

    /**
     * @date 2020/12/21 15:21
     * @Description 管理端界面查询要审批的新闻的方法
     */
    @GetMapping(value = "searchNewsApplication")
    @ResponseBody
    public TableModel searchNewsApplication(@Size(min = 1) @RequestParam int page) {
        return managerNewsService.searchNewsApplication(page);
    }


    /**
     * @date 2020/12/21 15:21
     * @Description 管理端界面审批新闻的方法
     */
    @PostMapping(value = "operateNew")
    @ResponseBody
    public TableModel operateNew(@RequestBody @Valid NewsManagerOperationVO newsManagerOperationVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerNewsService.operateNew(newsManagerOperationVO);
    }

    /**
     * 管理员发布精彩上大新闻
     * @param newsPublishVO
     * @param result
     * @return
     */
    @PostMapping("publisSHUNews")
    @ResponseBody
    public TableModel publisNews(@RequestBody @Valid NewsPublishVO newsPublishVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerNewsService.publisSHUNews(newsPublishVO);
    }


    /**
     * 查询所有未删除的新闻与帖子
     * @param page
     * @return
     */
    @GetMapping(value = "searchAllNews")
    @ResponseBody
    public TableModel searchAllNews(@Size(min = 1) @RequestParam int page) {
        return managerNewsService.searchAllNews(page);
    }

    /**
     * 设置新闻发布状态
     * @param newsId
     * @param isaudit
     * @return
     */
    @GetMapping("updateNewsAudit")
    public TableModel updateNewsAudit(@Size(min = 1) @RequestParam String newsId,@Size(min = 1) @RequestParam String isaudit){
        return managerNewsService.updateNewsAudit(newsId,isaudit);
    }
}
