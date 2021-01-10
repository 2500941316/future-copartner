package com.copartner.news;

import com.copartner.testng.TestStatic;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class NewsViewTest extends AbstractTestNGSpringContextTests {
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
     * 用户浏览新闻的测试
     *
     * @throws InterruptedException
     */
    @Test
    public void newsUserBrowseTest() throws InterruptedException {
        driver.get(TestStatic.INDEXURL);
        driver.findElement(By.cssSelector(".current > .img-wrap")).click();
        Thread.sleep(1500);
        /**
         * 点击继续阅读
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.linkText("继续阅读>>"));
            }
        }).click();
        Thread.sleep(1500);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.linkText("新闻"));
            }
        }).click();
        Thread.sleep(1500);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("keywords"));
            }
        }).click();
        Thread.sleep(1500);
        driver.findElement(By.id("keywords")).sendKeys("总书记");
        driver.findElement(By.cssSelector(".ssbtn")).click();
        Thread.sleep(4000);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.linkText("2020总书记十大用典｜脱贫攻坚篇"));
            }
        }).click();
        Thread.sleep(1500);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
