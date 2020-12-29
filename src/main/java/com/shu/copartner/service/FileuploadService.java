package com.shu.copartner.service;

import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author cxy
 * @Date: 2020/12/16 16:49
 * @Description: 文件上传类
 */
public interface FileuploadService {

    /**
     * @return java.lang.String
     * @Description 文件上传的方法
     */
    TableModel uploadFile(MultipartFile uploadfile);

    TableModel managerImageUploadFile(MultipartFile uploadfile);

    TableModel leassonVedioUpload(MultipartFile file, Long course_vedio_id, String fileUpload_type);
}
