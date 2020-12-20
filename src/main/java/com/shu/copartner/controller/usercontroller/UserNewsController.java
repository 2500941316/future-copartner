package com.shu.copartner.controller.usercontroller;

import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.UserNewsService;
import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@RestController
@RequestMapping("user/news")
@CrossOrigin
public class UserNewsController {

    @Autowired
    FileuploadService uploadService;

    @Autowired
    UserNewsService userNewsService;

    /**
      * @author cxy
      * @date 2020/12/20 13:42
      * @Description 上传文件的
      * @return com.shu.copartner.utils.returnobj.TableModel
      */
    @PostMapping(value = "newImagesUpload")
    @ResponseBody
    public TableModel fileuploadpicture(MultipartFile file) {

        return uploadService.managerImageUploadFile(file);
    }

    @PostMapping(value = "publisNews")
    @ResponseBody
    public TableModel publisNews(@RequestBody NewsPublishVO newsPublishVO) {

        return userNewsService.publisNews(newsPublishVO);
    }


}
