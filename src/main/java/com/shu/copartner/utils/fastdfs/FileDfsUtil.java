package com.shu.copartner.utils.fastdfs;


import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author cxy
 */
@Component
public class FileDfsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileDfsUtil.class);
    @Resource
    private FastFileStorageClient storageClient;


    /**
     * 上传文件
     */
    public String upload(MultipartFile multipartFile) {
        InputStream fis = null;
        try{
            String originalFilename = multipartFile.getOriginalFilename().
                    substring(multipartFile.getOriginalFilename().
                            lastIndexOf(".") + 1);
            /*StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                    multipartFile.getInputStream(),
                    multipartFile.getSize(), originalFilename, null);*/
            fis = multipartFile.getInputStream();
            //System.out.println("enter1");
            StorePath storePath = this.storageClient.uploadFile(fis,
                    multipartFile.getSize(), originalFilename, null);
            System.out.println(storePath);
            //System.out.println("enter2");
            return "group1/"+storePath.getPath();
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            LOGGER.info("e="+ex);
            ex.printStackTrace();
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    /**
     * 删除文件
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            LOGGER.info("fileUrl == >>文件路径为空...");
            return;
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
