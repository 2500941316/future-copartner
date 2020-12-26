package com.shu.copartner.controller.usercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.UserNewsService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@RestController
@RequestMapping("user/news")
@CrossOrigin
@Slf4j
public class UserNewsController {


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


    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 用户根据新闻id查询新闻的方法
     */
    @GetMapping("searchNewsById")
    @ResponseBody
    public TableModel searchNewsById(@Size(min = 1) String newsId) {
        return userNewsService.searchNewsById(newsId);
    }


    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 用户查询新闻主页的所有信息的方法
     */
    @GetMapping("getNewsIndexInfo")
    @ResponseBody
    public TableModel getNewsIndexInfo() {
        return userNewsService.getNewsIndexInfo();
    }


    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 安装关键字查询新闻
     */
    @GetMapping("searchNewsByKeywords")
    @ResponseBody
    public TableModel searchNewsByKeywords(@Size(min = 1) @RequestParam int page, @Size(min = 1) @RequestParam String keyword) {
        return userNewsService.searchNewsByKeywords(page, keyword);
    }

}
