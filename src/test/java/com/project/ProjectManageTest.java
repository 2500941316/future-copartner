package com.project;

import com.testng.BaseTest;
import com.testng.TestStatic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

public class ProjectManageTest  extends BaseTest {

    @Test
    public void projectApply() throws InterruptedException {
        driver.get(TestStatic.INDEXURL);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".current > .img-wrap")).click();
        Thread.sleep(2000);
        /**
         * 设置标题
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("manager"));
            }
        }).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("通过")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("确定")).click();
        Thread.sleep(3000);
    }

}
