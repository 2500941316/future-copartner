package com.shu.copartner.service.impl;

import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.fastdfs.FastDfsClient;
import com.shu.copartner.utils.returnobj.TableModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
            e.printStackTrace();
            return null;
        }
    }
}
