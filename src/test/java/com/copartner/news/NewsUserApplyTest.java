package com.copartner.news;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;


public class NewsUserApplyTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        //显式等待， 针对某个元素等待
        wait = new WebDriverWait(driver, 5, 1);
    }

    @Test
    public void newapply() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.cssSelector(".current > .img-wrap")).click();
        driver.findElement(By.linkText("个人")).click();
        driver.findElement(By.linkText("发布新闻")).click();
        driver.switchTo().frame(0);
        /**
         * 设置标题
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("title"));
            }
        }).sendKeys("国家卫健委：倡导在工作地过年 尽可能减少人员流动 ");
        /**
         * 设置keywords
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("keywords"));
            }
        }).sendKeys("疫情 过年");

        /**
         * 设置种类
         */
        WebElement dropdown = driver.findElement(By.id("category"));
        dropdown.findElement(By.xpath("//option[. = '人文社科']")).click();

        /**
         * 点击发布按钮
         */
        driver.findElement(By.id("publish")).sendKeys(Keys.ENTER);

        //固定等待2秒
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
