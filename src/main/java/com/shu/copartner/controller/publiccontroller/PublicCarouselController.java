package com.shu.copartner.controller.publiccontroller;

import com.shu.copartner.service.UserCarouselService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author
 * @date 2021/3/9 20:19
 * @description
 */
@Slf4j
@RestController
@RequestMapping("public/carousel")
@CrossOrigin
public class PublicCarouselController {

    @Autowired
    private UserCarouselService userCarouselService;

    /**
     * 查询首页轮播图
     * @return
     */
    @GetMapping("searchIndexCarousel")
    public TableModel searchIndexCarousel(Principal principal){
        return userCarouselService.searchIndexCarouselImg();
    }

    /**
     * 查询公共页轮播图
     * @return
     */
    @GetMapping("searchPublicCarousel")
    public TableModel searchPublicCarousel(Principal principal){
        return userCarouselService.searchPublicCarouselImg();
    }
}
