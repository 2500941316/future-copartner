package com.shu.copartner.controller.publiccontroller;

import com.shu.copartner.service.UserLeassonService;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

/**
 * @author cxy
 */
@Slf4j
@RestController
@RequestMapping("public/leasson")
@CrossOrigin
public class PublicLeassonController {

    @Autowired
    UserLeassonService userLeassonService;

    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 课程页面查询所有课程信息
     */
    @GetMapping(value = "getLeassonInfo")
    @ResponseBody
    public TableModel getLeassonInfo() {
        return userLeassonService.getLeassonInfo();
    }

    /**
     * @author cxy
     * @date 2020/12/20 13:42
     * @Description 课程页面查询某个课下面所有的信息
     */
    @GetMapping(value = "getcourseInfo_vedio")
    @ResponseBody
    public TableModel getcourseInfo_vedio(@Size Long courseId) {
        return userLeassonService.getcourseInfoVedio(courseId);
    }

}
