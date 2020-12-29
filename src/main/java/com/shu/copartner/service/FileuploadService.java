package com.shu.copartner.service;

import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author cxy
 * @Date: 2020/12/16 16:49
 * @Description: 文件上传类
 */
public interface FileuploadService {

    /**
      * @Description 文件上传的方法
      * @return java.lang.String
      */
    String uploadFile(MultipartFile uploadfile);

    TableModel managerImageUploadFile(MultipartFile uploadfile);

    TableModel leassonVedioUpload(MultipartFile file, Long course_vedio_id, String fileUpload_type);

    /**
     * 上传计划书
     * @param uploadfile
     * @return
     */
    TableModel managerPlanUploadFile(MultipartFile uploadfile, String projectId) throws IOException;

    /**
     * 上传视频
     * @param uploadfile
     * @return
     */
    TableModel managerVideoUploadFile(MultipartFile uploadfile, String projectId) throws IOException;

}
