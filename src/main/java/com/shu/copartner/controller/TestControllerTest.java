package com.shu.copartner.controller;

import com.shu.copartner.mapper.ActRuTaskMapper;
import com.shu.copartner.pojo.ActRuTask;
import com.shu.copartner.pojo.ActRuTaskExample;
import com.shu.copartner.service.ActivitiService;
import com.shu.copartner.utils.constance.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.ConstantCallSite;
import java.util.HashMap;
import java.util.List;

/**
 * @author cxy
 * @Date: 2020/12/6 15:19
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {

    @Autowired
    ActivitiService activitiService;

    @Autowired
    ActRuTaskMapper actRuTaskMapper;

    @Test
    public void propsTest() {
        List<ActRuTask> actRuTasks = actRuTaskMapper.selectByExample(new ActRuTaskExample());
        System.out.println(actRuTasks);
    }

}

