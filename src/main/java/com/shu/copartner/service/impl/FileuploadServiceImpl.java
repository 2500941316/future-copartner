package com.shu.copartner.service.impl;

import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.utils.fastdfs.FastDfsClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author cxy
 * @Date: 2020/12/16 16:52
 * @Description:
 */
@Service
public class FileuploadServiceImpl implements FileuploadService {
    @Override
    public String uploadFile(MultipartFile uploadfile) {
        try {
            return FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
