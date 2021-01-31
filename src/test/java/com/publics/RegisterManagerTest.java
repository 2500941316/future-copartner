package com.publics;

import com.testng.TestStatic;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterManagerTest {
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
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.addArguments("--hide-scrollbars");
//        chromeOptions.addArguments("blink-settings=imagesEnabled=false");
//        chromeOptions.addArguments("--window-size=1920,1080");
//        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--headless");
        //启动一个 chrome 实例
        driver = new ChromeDriver(chromeOptions);
        js = (JavascriptExecutor) driver;
        //显式等待， 针对某个元素等待
        wait = new WebDriverWait(driver, 10, 1);
    }
    /**
     * 管理员审批新闻的测试
     */
    @Test
    public void userRegisterManagerApprove() {
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
