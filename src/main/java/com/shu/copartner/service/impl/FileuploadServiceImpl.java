package com.shu.copartner.service.impl;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProCarouselMapper;
import com.shu.copartner.mapper.ProLeassonVedioMapper;
import com.shu.copartner.mapper.ProLiveMapper;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.pojo.*;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.ProProjectService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.fastdfs.FileDfsUtil;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    ProUserMapper proUserMapper;

    @Autowired
    private ProCarouselMapper proCarouselMapper;

    @Autowired
    private FileDfsUtil fileDfsUtil;

    @Autowired
    private ProLiveMapper proLiveMapper;

    @Override
    public String uploadFile(MultipartFile uploadfile) {
        try {
            //return FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            return fileDfsUtil.upload(uploadfile);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
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
            //String imageUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String imageUrl = fileDfsUtil.upload(uploadfile);
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

    @Override
    public TableModel leassonVedioUpload(MultipartFile file, Long courseVedioId, String fileUploadType) {
        try {
            //String fileUrl = Constants.FILEURL_FIRSTNAME + FastDfsClient.uploadFile(file.getInputStream(), file.getOriginalFilename());
            String fileUrl = Constants.FILEURL_FIRSTNAME + fileDfsUtil.upload(file);

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
            //log.info("文件名：" + uploadfile.getOriginalFilename());
            //log.info("projectId:" + projectId);
            // 上传计划书，返回其存放路径
            //String planUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String planUrl = fileDfsUtil.upload(uploadfile);
            //String planUrl = uploadfile.getOriginalFilename();
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
        //TableModel tableModel = new TableModel();
        if (StringUtils.isNotEmpty(projectId)) {
            //log.info("文件名：" + uploadfile.getOriginalFilename());
            //log.info("projectId:" + projectId);
            // 上传视频，返回其存放路径
            //String videoUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String videoUrl = fileDfsUtil.upload(uploadfile);
            //String planUrl = uploadfile.getOriginalFilename();
            // 文件存储路径加上服务器前缀
            String finalPlanUrl = Constants.FILEURL_FIRSTNAME + videoUrl;
            // 项目状态更新处理
            proProjectService.uploadProjectVideo(finalPlanUrl, projectId);

            Map<String, String> map = new HashMap<>();
            map.put("VideoUrl", Constants.FILEURL_FIRSTNAME + videoUrl);
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
            //String imageUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String imageUrl = fileDfsUtil.upload(uploadfile);
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
            //String imageUrl = FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String imageUrl = fileDfsUtil.upload(uploadfile);
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
     * 上传个人图像
     * @param uploadfile
     * @return
     */
    @Override
    public TableModel uploadPersonalImage(MultipartFile uploadfile,String phone) {
        try {
            //获取图片的存放路径
            //String fileUrl = Constants.FILEURL_FIRSTNAME + FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String fileUrl = Constants.FILEURL_FIRSTNAME + fileDfsUtil.upload(uploadfile);
            System.out.println(fileUrl);
            //将该路径写到数据库表中
            ProUserExample proUserExample = new ProUserExample();
            proUserExample.createCriteria().andPhoneEqualTo(phone);
            List<ProUser> proUsers = proUserMapper.selectByExample(proUserExample);
            proUsers.get(0).setImageUrl(fileUrl);
            proUserMapper.updateByPrimaryKeySelective(proUsers.get(0));
            return TableModel.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 上传广告图像
     * @param uploadfile
     * @param carouselType
     * @param phone 上传人手机号
     * @return
     */
    @Override
    public TableModel uploadCarouselImage(MultipartFile uploadfile, String carouselType,String phone) {
        try {
            TableModel tableModel = new TableModel();
            //获取图片的存放路径
            //String fileUrl = Constants.FILEURL_FIRSTNAME + FastDfsClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
            String fileUrl = Constants.FILEURL_FIRSTNAME + fileDfsUtil.upload(uploadfile);
            System.out.println(fileUrl);

            //将该路径写到数据库表中
            ProCarousel proCarousel = new ProCarousel();
            proCarousel.setCarouselType(Integer.valueOf(carouselType));
            proCarousel.setCarouselUrl(fileUrl);
            proCarousel.setUploadDate(new Date(System.currentTimeMillis()));
            proCarousel.setPhone(phone);
            proCarousel.setIsDeleted(0); // 0未删除
            proCarousel.setIsIssue(1); //  1默认已发布
            proCarouselMapper.insertSelective(proCarousel);

            // 将数据封装传到前端
            Map<String, String> map = new HashMap<>();
            map.put("src", Constants.FILEURL_FIRSTNAME + fileUrl);
            map.put("title", uploadfile.getOriginalFilename());
            tableModel.setCode(0);
            tableModel.setData(map);
            return tableModel;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

    /**
     * 上传直播视频
     * @param file
     * @param liveId
     * @return
     */
    @Override
    public TableModel liveVideoUpload(MultipartFile file, String liveId) {
        try {
            //String fileUrl = Constants.FILEURL_FIRSTNAME + FastDfsClient.uploadFile(file.getInputStream(), file.getOriginalFilename());
            String fileUrl = Constants.FILEURL_FIRSTNAME + fileDfsUtil.upload(file);

            //更新数据库
            ProLive proLive = new ProLive();
            proLive.setLiveId(Long.parseLong(liveId));
            proLive.setLiveVideoUrl(fileUrl);
            proLiveMapper.updateByPrimaryKeySelective(proLive);
            return TableModel.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(Exceptions.SERVER_DATASOURCE_ERROR.getEcode());
        }
    }

}
