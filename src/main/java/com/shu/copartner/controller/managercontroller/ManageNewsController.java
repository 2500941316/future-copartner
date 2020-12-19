package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author
 * @date 2020/12/19 12:07
 * @description
 */
@RestController
@RequestMapping("manager/news")
@CrossOrigin
public class ManageNewsController {
    @Autowired
    FileuploadService uploadService;

    @PostMapping(value = "newImagesUpload")
    @ResponseBody
    public TableModel fileuploadpicture(MultipartFile file) {

        return uploadService.managerImageUploadFile(file);
    }


}
