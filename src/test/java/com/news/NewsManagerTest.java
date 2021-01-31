package com.news;

import com.testng.BaseTest;
import com.testng.TestStatic;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;


public class NewsManagerTest  extends BaseTest {
    /**
     * 管理员审批新闻的测试
     */
    @Test
    public void newsManagerApprove() throws InterruptedException {
        driver.get(TestStatic.INDEXURL);
        driver.findElement(By.cssSelector(".current > .img-wrap")).click();
        Thread.sleep(1500);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.linkText("管理端"));
            }
        }).click();
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
}
