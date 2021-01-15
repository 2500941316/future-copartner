package com.news;

import com.testng.TestStatic;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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


public class NewsViewTest  extends AbstractTestNGSpringContextTests {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    WebDriverWait wait;


    /**
     * 测试前获取driver
     */
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", TestStatic.FIREFOXDRIVERVALUE);
        System.out.println("启动 ...");
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
        driver = new ChromeDriver(chromeOptions);
        js = (JavascriptExecutor) driver;
        //显式等待， 针对某个元素等待
        wait = new WebDriverWait(driver, 10, 1);
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
