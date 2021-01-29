package com.shu.copartner.controller.publiccontroller;

import com.shu.copartner.service.UserNewsService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

/**
 * @author cxy
 */
@RestController
@RequestMapping("public/news")
@CrossOrigin
@Slf4j
public class PublicNewsController {

    @Autowired
    UserNewsService userNewsService;

    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 用户查询新闻主页的所有信息的方法
     */
    @GetMapping("getNewsIndexInfo")
    @ResponseBody
    public TableModel getNewsIndexInfo() {
        return userNewsService.getNewsIndexInfo();
    }


    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 用户查询新闻主页的所有信息的方法
     */
    @GetMapping("getNewsIndexCategoryInfo")
    @ResponseBody
    public TableModel getNewsIndexCategoryInfo() {
        return userNewsService.getNewsIndexCategoryInfo();
    }


    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 用户根据新闻id查询新闻的方法
     */
    @GetMapping("searchNewsById")
    @ResponseBody
    public TableModel searchNewsById(@Size(min = 1) String newsId) {
        return userNewsService.searchNewsById(newsId);
    }


    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 按照关键字查询新闻
     */
    @GetMapping("searchNewsByKeywords")
    @ResponseBody
    public TableModel searchNewsByKeywords(@Size(min = 1) @RequestParam int page, @Size(min = 1) @RequestParam String keyword) {
        return userNewsService.searchNewsByKeywords(page, keyword);
    }

}
