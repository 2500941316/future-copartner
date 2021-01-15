package com.chrome;


import java.io.File;

import com.testng.TestStatic;
import junit.extensions.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 测试----- 通过窗口打开谷歌浏览器
 *
 * @author WangSong
 */
public class TestOpenBrowser extends AbstractTestNGSpringContextTests {

    @Test
    public void testChrome() {
        WebDriver webDriver = null;
        try {
            System.setProperty("webdriver.chrome.driver", TestStatic.FIREFOXDRIVERVALUE);
            System.out.println("启动 ...");
            String url = "https://www.jianshu.com/p/675ea919230e";
            ChromeOptions chromeOptions = new ChromeOptions();
            //设置 chrome 的无头模式
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--hide-scrollbars");
            chromeOptions.addArguments("blink-settings=imagesEnabled=false");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--headless");
            //启动一个 chrome 实例
            webDriver = new ChromeDriver(chromeOptions);
            //访问网址
            webDriver.get(url);
            System.out.println(webDriver.getPageSource());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (webDriver != null) {
                //退出 chrome
                webDriver.quit();
            }
        }
    }
}