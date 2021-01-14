package com.news;

import com.testng.TestStatic;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class NewsManagerTest  extends AbstractTestNGSpringContextTests {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    WebDriverWait wait;

    /**
     * 测试前获取driver
     */
    @BeforeClass
    public void setUp() {
        System.setProperty(TestStatic.FIREFOXDRIVERKEY, TestStatic.FIREFOXDRIVERVALUE);
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, TestStatic.BROWSER_LOGFILE);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(TestStatic.BROWSER_EXE);
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        //显式等待， 针对某个元素等待
        wait = new WebDriverWait(driver, 5, 1);
    }

    /**
     * 管理员审批新闻的测试
     */
    @Test
    public void newsManagerApprove() {
        driver.get(TestStatic.INDEXURL);
        driver.findElement(By.cssSelector(".current > .img-wrap")).click();
        driver.findElement(By.linkText("管理端")).click();

        /**
         * 设置keywords
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.cssSelector(".layui-this:nth-child(2)"));
            }
        }).click();

        /**
         * 点击通过按钮
         */
        try {
            Thread.sleep(1000);
            wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(WebDriver text) {
                    return text.findElement(By.linkText("通过"));
                }
            }).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("确定")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
