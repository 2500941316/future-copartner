package com.shu.copartner.utils.generator;

/**
 * @Date: 2020/12/5 19:19
 * @Description:
 */

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**************************************
 * 类说明:
 *     mybatis逆向工程main函数
 ***************************************
 * @author cxy
 */
public class Generator {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String genCfg = "D:\\post\\future-copartner\\src\\main\\resources\\generator\\mybatis-generator.xml";
        File configFile = ResourceUtils.getFile(genCfg);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
        } catch (IOException | XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
        } catch (SQLException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}