package com.shu.copartner.service;

import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @date 2021/3/9 20:22
 * @description
 */
public interface UserCarouselService {

    TableModel searchIndexCarouselImg();

    TableModel searchPublicCarouselImg();

    TableModel searchAllCarousel(int page);

    TableModel updateCarouselStatus(String carouselId,String isIssue);

    TableModel deleteCarouselById(String carouselId);

}
