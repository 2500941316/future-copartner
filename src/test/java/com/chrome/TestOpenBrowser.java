package com.chrome;


import java.io.File;

import com.testng.TestStatic;
import junit.extensions.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        //设置启动google浏览器的驱动和位置
        System.setProperty("webdriver.chrome.driver", TestStatic.FIREFOXDRIVERVALUE);
        System.out.println("启动 ...");
        //获取谷歌浏览器驱动
        WebDriver driver = new ChromeDriver();
        //设置默认打开的页面
        driver.get("http://www.baidu.com/");
        //设置默认搜索的关键字
        driver.findElement(By.id("kw")).sendKeys("eclipse窗口集成浏览器");
        //搜索按钮点击
        driver.findElement(By.id("su")).click();

        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        //关闭浏览器
        //driver.close();
    }
}