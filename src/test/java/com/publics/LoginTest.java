package com.publics;

import com.testng.BaseTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class LoginTest extends BaseTest {

    @Test
    public void login() throws InterruptedException {

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
}
