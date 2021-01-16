package com.shu.copartner.service.impl;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProLeassonVedioMapper;
import com.shu.copartner.pojo.ProLeassonVedio;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.fastdfs.FastDfsClient;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cxy
 * @Date: 2020/12/16 16:52
 * @Description:
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class FileuploadServiceImpl implements FileuploadService {
    @Autowired
    private ProProjectService proProjectService;

    @Autowired
    ProLeassonVedioMapper proLeassonVedioMapper;

    @Override
    public String uploadFile(MultipartFile uploadfile) {
        try {
            return FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_FILEUPLOAD_ERROR.getEcode());
        }
    }

    /**
     * @author cxy
     * @date 2020/12/19 17:28
     * @Description 新闻发布页面富文本编辑器上传图片的方法
     */
    @Override
    public TableModel managerImageUploadFile(MultipartFile uploadfile) {
        try {
            TableModel tableModel = new TableModel();
            String imageUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            Map<String, String> map = new HashMap<>();
            map.put("src", Constants.FILEURL_FIRSTNAME + imageUrl);
            map.put("title", uploadfile.getOriginalFilename());
            tableModel.setCode(0);
            tableModel.setData(map);
            return tableModel;
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_FILEUPLOAD_ERROR.getEcode());
        }
    }

    @Override
    public TableModel leassonVedioUpload(MultipartFile file, Long courseVedioId, String fileUploadType) {
        try {
            String fileUrl = Constants.FILEURL_FIRSTNAME + FastDfsClient.uploadFile(file.getInputStream(), file.getOriginalFilename());

            //更新数据库
            ProLeassonVedio proLeassonVedio = new ProLeassonVedio();
            proLeassonVedio.setCourseVedioId(courseVedioId);
            if (fileUploadType.equals(Constants.LEASSON_FILETYPE_VEDIO)) {
                proLeassonVedio.setCourseVedioUrl(fileUrl);
            } else if (fileUploadType.equals(Constants.LEASSON_FILETYPE_PPT)) {
                proLeassonVedio.setCourseVedioPptUrl(fileUrl);
            }
            proLeassonVedioMapper.updateByPrimaryKeySelective(proLeassonVedio);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 上传项目计划书
     *
     * @param uploadfile
     * @return
     */
    @Override
    public TableModel managerPlanUploadFile(MultipartFile uploadfile, String projectId) throws IOException {
        if (StringUtils.isNotEmpty(projectId)) {
            log.info("文件名：" + uploadfile.getOriginalFilename());
            log.info("projectId:" + projectId);
            // 上传计划书，返回其存放路径
            //String planUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String planUrl = uploadfile.getOriginalFilename();
            // 文件存储路径加上服务器前缀
            String finalPlanUrl = Constants.FILEURL_FIRSTNAME + planUrl;
            // 项目状态更新处理
            proProjectService.uploadProjectPlan(finalPlanUrl, projectId);

            Map<String, String> map = new HashMap<>();
            map.put("planUrl", Constants.FILEURL_FIRSTNAME + planUrl);
            map.put("title", uploadfile.getOriginalFilename());
            return TableModel.success(map, map.size());
        } else {
            return TableModel.error("网络异常");
        }
    }

    /**
     * 上传项目视频
     *
     * @param uploadfile
     * @param projectId
     * @return
     * @throws IOException
     */
    @Override
    public TableModel managerVideoUploadFile(MultipartFile uploadfile, String projectId) throws IOException {
        TableModel tableModel = new TableModel();
        if (StringUtils.isNotEmpty(projectId)) {
            log.info("文件名：" + uploadfile.getOriginalFilename());
            log.info("projectId:" + projectId);
            // 上传视频，返回其存放路径
            //String planUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String planUrl = uploadfile.getOriginalFilename();
            // 文件存储路径加上服务器前缀
            String finalPlanUrl = Constants.FILEURL_FIRSTNAME + planUrl;
            // 项目状态更新处理
            proProjectService.uploadProjectVideo(finalPlanUrl, projectId);

            Map<String, String> map = new HashMap<>();
            map.put("VideoUrl", Constants.FILEURL_FIRSTNAME + planUrl);
            map.put("title", uploadfile.getOriginalFilename());
            return TableModel.success(map, map.size());
        } else {
            return TableModel.error("网络异常");
        }
    }


    /**
     * 上传导师照片
     * @param uploadfile
     * @return
     */
    @Override
    public TableModel supervisorImageUpload(MultipartFile uploadfile) {
        try {
            TableModel tableModel = new TableModel();
            String imageUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            //String imageUrl = "imageUrl";
            Map<String, String> map = new HashMap<>();
            map.put("src", Constants.FILEURL_FIRSTNAME + imageUrl);
            map.put("title", uploadfile.getOriginalFilename());
            tableModel.setCode(0);
            tableModel.setData(map);
            return tableModel;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_FILEUPLOAD_ERROR.getEcode());
        }
    }

    /**
     * 上传活动照片
     * @param uploadfile
     * @return
     */
    @Override
    public TableModel activityImageUpload(MultipartFile uploadfile) {
        try {
            TableModel tableModel = new TableModel();
            String imageUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            //String imageUrl = "imageUrl";
            Map<String, String> map = new HashMap<>();
            map.put("src", Constants.FILEURL_FIRSTNAME + imageUrl);
            map.put("title", uploadfile.getOriginalFilename());
            tableModel.setCode(0);
            tableModel.setData(map);
            return tableModel;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_FILEUPLOAD_ERROR.getEcode());
        }
    }
}
