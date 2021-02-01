package com.leassons;

import com.testng.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

public class LeassonVedioPptUpload extends BaseTest {
    @Test
    public void leassonVedioPptUpload() throws InterruptedException {
        driver.get("http://localhost:8080/");
        driver.manage().window().setSize(new Dimension(1245, 1050));
        driver.findElement(By.cssSelector(".current > .img-wrap")).click();
        Thread.sleep(2000);

        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("manager"));
            }
        }).click();
        Thread.sleep(500);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.linkText("课程管理"));
            }
        }).click();
        Thread.sleep(1000);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.cssSelector(".layui-this:nth-child(2)"));
            }
        }).click();
        Thread.sleep(2000);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.cssSelector(".layui-this:nth-child(2)"));
            }
        }).click();
        Thread.sleep(1000);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.xpath("//span[contains(.,\'视频剪辑教程\')]"));
            }
        }).click();

        Thread.sleep(2000);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.cssSelector(".layui-upload-file:nth-child(10)"));
            }
        }).sendKeys("D:\\springsource\\springcloud.pptx");
        Thread.sleep(6000);

      }
}
