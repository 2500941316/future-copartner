package com.shu.copartner.service.impl;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProLeassonVedioMapper;
import com.shu.copartner.pojo.ProLeassonVedio;
import com.shu.copartner.pojo.ProLeassonVedioExample;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.fastdfs.FastDfsClient;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
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
@Transactional
@Service
@Slf4j
public class FileuploadServiceImpl implements FileuploadService {

    @Autowired
    ProLeassonVedioMapper proLeassonVedioMapper;

    @Override
    public TableModel uploadFile(MultipartFile uploadfile) {
        try {
            String imageUrl = Constants.FILEURL_FIRSTNAME + FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            return TableModel.success(imageUrl, 1);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    @Override
    public TableModel leassonVedioUpload(MultipartFile file, Long course_vedio_id, String fileUpload_type) {
        try {
            String fileUrl = Constants.FILEURL_FIRSTNAME + FastDfsClient.uploadFile(file.getInputStream(), file.getOriginalFilename());

            //更新数据库
            ProLeassonVedio proLeassonVedio = new ProLeassonVedio();
            proLeassonVedio.setCourseVedioId(course_vedio_id);
            if (fileUpload_type.equals(Constants.LEASSON_FILETYPE_VEDIO)) {
                proLeassonVedio.setCourseVedioUrl(fileUrl);
            } else if (fileUpload_type.equals(Constants.LEASSON_FILETYPE_PPT)) {
                proLeassonVedio.setCourseVedioPptUrl(fileUrl);
            }
            proLeassonVedioMapper.updateByPrimaryKeySelective(proLeassonVedio);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }
}
