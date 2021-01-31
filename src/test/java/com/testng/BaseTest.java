package com.testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public class BaseTest extends AbstractTestNGSpringContextTests {
    public static WebDriver driver;
    public static Map<String, Object> vars;
    public static  JavascriptExecutor js;
    public static  WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite() throws InterruptedException {
        System.out.println("启动 ...");
        System.setProperty("webdriver.chrome.driver", TestStatic.FIREFOXDRIVERVALUE);
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 10, 1);
        Thread.sleep(1000);

        /**
         * 登录
         */
        driver.get("http://localhost:8080/");
        driver.manage().window().setSize(new Dimension(1492, 1334));
        driver.findElement(By.cssSelector(".current > .img-wrap")).click();
        Thread.sleep(1500);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.linkText("登录"));
            }
        }).click();
        driver.switchTo().frame(0);

        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("LAY-user-login-cellphone"));
            }
        }).click();
        driver.findElement(By.id("LAY-user-login-cellphone")).sendKeys("17750905812");
        Thread.sleep(1500);

        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("LAY-user-getsmscode"));
            }
        }).click();

        Thread.sleep(1500);

        driver.findElement(By.id("LAY-user-login-vercode")).click();
        driver.findElement(By.id("LAY-user-login-vercode")).sendKeys("111111");

        Thread.sleep(1500);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.cssSelector(".layui-form-item > .layui-btn"));
            }
        }).click();
        Thread.sleep(3000);
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}