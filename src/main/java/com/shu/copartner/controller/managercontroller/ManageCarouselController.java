package com.shu.copartner.controller.managercontroller;

import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.UserCarouselService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.security.Principal;

/**
 * @author
 * @date 2021/3/9 19:09
 * @description 广告图管理
 */
@Slf4j
@RestController
@RequestMapping("manager/carousel")
@CrossOrigin
public class ManageCarouselController {

    @Autowired
    private FileuploadService fileuploadService;

    @Autowired
    private UserCarouselService userCarouselService;

    /**
     * 广告图上传
     * @param file 广告图
     * @param principal 上传人手机号
     * @return
     */
    @PostMapping(value = "carouselImgUpload")
    public TableModel uploadCarouselImg(MultipartFile file, @Size(min = 1) @RequestParam String carouselType, Principal principal) throws IOException {
        //log.info("carouselType:"+ carouselType);
        return fileuploadService.uploadCarouselImage(file,carouselType,principal.getName());
    }

    /**
     * 查询所有广告图
     * @param page
     * @return
     */
    @GetMapping("searchAllCarousel")
    public TableModel searchAllCarousel(@Size(min = 1) @RequestParam int page){
        return userCarouselService.searchAllCarousel(page);
    }

    /**
     * 设置广告图发布状态
     * @param carouselId
     * @param isIssue
     * @return
     */
    @GetMapping("updateCarouselStatus")
    public TableModel updateCarouselStatus(@Size(min = 1) @RequestParam String carouselId,@Size(min = 1) @RequestParam String isIssue){
        return userCarouselService.updateCarouselStatus(carouselId,isIssue);
    }

    /**
     * 删除广告图
     * @param carouselId
     * @return
     */
    @GetMapping("deleteCarouselById")
    public TableModel deleteCarouselById(@Size(min = 1) @RequestParam String carouselId){
        return userCarouselService.deleteCarouselById(carouselId);
    }
}
