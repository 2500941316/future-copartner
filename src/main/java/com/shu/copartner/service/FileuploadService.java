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
     * @return java.lang.String
     * @Description 文件上传的方法
     */
    String uploadFile(MultipartFile uploadfile);

    TableModel managerImageUploadFile(MultipartFile uploadfile);

    TableModel leassonVedioUpload(MultipartFile file, Long courseVedioId, String fileUploadType);

    /**
     * 上传计划书
     *
     * @param uploadfile
     * @return
     */
    TableModel managerPlanUploadFile(MultipartFile uploadfile, String projectId) throws IOException;

    /**
     * 上传视频
     *
     * @param uploadfile
     * @return
     */
    TableModel managerVideoUploadFile(MultipartFile uploadfile, String projectId) throws IOException;

    /**
     * 上传导师照片
     * @param uploadfile
     * @return
     */
    TableModel supervisorImageUpload(MultipartFile uploadfile);

    /**
     * 上传活动图片
     * @param uploadfile
     * @return
     */
    TableModel activityImageUpload(MultipartFile uploadfile);

    /**
     * 上传个人头像
     * @param uploadfile
     * @return
     */
    TableModel uploadPersonalImage(MultipartFile uploadfile,String phone);

}
