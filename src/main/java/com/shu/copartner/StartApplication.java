package com.shu.copartner;

import com.shu.copartner.utils.fastdfs.FastDfsClient;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

/**
 * @author cxy
 * @date 2020/12/6 13:17
 * @Description springboot启动类
 * @return
 */

@SpringBootApplication
@MapperScan("com.shu.copartner.mapper")
public class StartApplication {

    public static void main(String[] args) throws IOException, MyException {
        SpringApplication.run(StartApplication.class, args);
    }
}
