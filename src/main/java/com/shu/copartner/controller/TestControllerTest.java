package com.shu.copartner.controller;

import com.shu.copartner.mapper.ActHiVarinstMapper;
import com.shu.copartner.pojo.ActHiVarinst;
import com.shu.copartner.pojo.ActHiVarinstExample;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.impl.ActivitiServiceImpl;
import com.shu.copartner.utils.fastdfs.FastDfsClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    @Autowired
    FileuploadService fileuploadService;

    @Test
    public void propsTest() {
        List<ActHiVarinst> actRuTasks = actRuTaskMapper.selectByExample(new ActHiVarinstExample());
        System.out.println(actRuTasks);
    }
   //  MultipartFile

    @Test
    public void fileuploadTest() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\cxy\\Desktop\\test.jpg"));
        String s = FastDfsClient.uploadFile(inputStream, "test.jpg");
        // 保存地址，通过该地址访问，地址需要拼接服务器完整地址，然后写入数据库，
        System.out.println(s);
    }

}

