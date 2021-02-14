package com.shu.copartner.utils.fastdfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author cxy
 */
@RestController
public class FileController {
    @Autowired
    private FileDfsUtil fileDfsUtil;

    @PostMapping(value = "uploadFile")
    public void uploadFile(MultipartFile file) throws Exception {

        String upload = fileDfsUtil.upload(file);
        System.out.println(upload);
    }

}
