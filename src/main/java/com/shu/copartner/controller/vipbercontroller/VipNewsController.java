package com.shu.copartner.controller.vipbercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.UserNewsService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * @author
 * @date 2020/12/19 12:09
 * @description
 */
@RestController
@Slf4j
@RequestMapping("vip/news")
@CrossOrigin
public class VipNewsController {

    @Autowired
    FileuploadService uploadService;

    @Autowired
    UserNewsService userNewsService;

    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 上传新闻图片
     */
    @PostMapping(value = "newImagesUpload")
    @ResponseBody
    public TableModel fileuploadpicture(MultipartFile file) {

        return uploadService.managerImageUploadFile(file);
    }


    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 用户发布文件方法
     */
    @PostMapping("publisNews")
    @ResponseBody
    public TableModel publisNews(@RequestBody @Valid NewsPublishVO newsPublishVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return userNewsService.publisNews(newsPublishVO);
    }

}
