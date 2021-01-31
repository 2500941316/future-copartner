package com.publics;

import com.testng.TestStatic;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class RegisterTest {
    private WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", TestStatic.FIREFOXDRIVERVALUE);
        System.out.println("启动 ...");
        ChromeOptions chromeOptions = new ChromeOptions();
//        //设置 chrome 的无头模式
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

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void register() throws InterruptedException {
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
        /**
         * 点击注册
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.linkText("注册"));
            }
        }).sendKeys(Keys.ENTER);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        Thread.sleep(2000);

        WebElement element1 = driver.findElement(By.cssSelector(".layui-form-item:nth-child(1) > .layui-input-block .layui-input"));
        element1.click();
        element1.click();
        element1.click();
        Thread.sleep(1000);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.cssSelector(".layui-form-selected dd:nth-child(2)"));
            }
        }).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btnNext")).click();
        {
            WebElement element = driver.findElement(By.id("btnNext"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("陈兴宇");
        driver.findElement(By.id("test1")).click();
        driver.findElement(By.cssSelector(".laydate-prev-y")).click();
        driver.findElement(By.cssSelector(".laydate-prev-y")).click();
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(3)")).click();
        driver.findElement(By.name("studentnumber")).click();
        driver.findElement(By.name("studentnumber")).sendKeys("19721631");
        driver.findElement(By.name("department")).click();
        driver.findElement(By.name("department")).sendKeys("计算机科学与工程");
        driver.findElement(By.name("major")).click();
        driver.findElement(By.name("major")).sendKeys("软件工程");

        //手机注册
        driver.findElement(By.id("btnNext")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("LAY-user-login-cellphone")).click();
        driver.findElement(By.id("LAY-user-login-cellphone")).sendKeys("17750905827");
        driver.findElement(By.id("LAY-user-getsmscode")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".layui-form-item > .layui-btn"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.id("LAY-user-login-vercode")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("LAY-user-login-vercode")).sendKeys("111111");
        driver.findElement(By.cssSelector(".layui-form-item > .layui-btn")).click();
        Thread.sleep(2000);
    }
}
