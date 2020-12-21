package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.service.ManagerNewsService;
import com.shu.copartner.utils.returnobj.TableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ManageNewsController {

    private static Logger logger = LoggerFactory.getLogger(ManageNewsController.class);

    @Autowired
    ManagerNewsService managerNewsService;

    /**
     * @date 2020/12/21 15:21
     * @Description 管理端界面查询要审批的新闻的方法
     */
    @GetMapping(value = "searchNewsApplication")
    @ResponseBody
    public TableModel searchNewsApplication(@Size(min = 1) @RequestParam int page) {
        if (page <= 0) {
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
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
            logger.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return managerNewsService.operateNew(newsManagerOperationVO);
    }
}
