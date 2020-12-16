package com.shu.copartner.controller;

import com.shu.copartner.mapper.ActHiVarinstMapper;
import com.shu.copartner.pojo.ActHiVarinst;
import com.shu.copartner.pojo.ActHiVarinstExample;
import com.shu.copartner.service.impl.ActivitiServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    ActivitiServiceImpl activitiService;

    @Autowired
    ActHiVarinstMapper actRuTaskMapper;

    @Test
    public void propsTest() {
        List<ActHiVarinst> actRuTasks = actRuTaskMapper.selectByExample(new ActHiVarinstExample());
        System.out.println(actRuTasks);
    }

}

