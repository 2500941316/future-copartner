package com.news;

import com.testng.BaseTest;
import com.testng.TestStatic;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NewsApplyTest extends BaseTest {
    /**
     * 测试数据的二维数组，一行对应一次测试用例
     *
     * @return
     */
    @DataProvider(name = "newsDataProvider")
    public Object[][] rangeData() {
        String title = "国家卫健委：倡导在工作地过年 尽可能减少人员流动";
        String keywords = "疫情 过年";
        String category = "//option[. = '人文社科']";
        return new Object[][]{
                {title, keywords, category}
        };
    }

    /**
     * 用户是申请新闻的测试
     *
     * @param title
     * @param keywords
     * @param category
     */
    @Test(dataProvider = "newsDataProvider", priority = 0)
    public void newapply(String title, String keywords, String category) throws InterruptedException {
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
                return text.findElement(By.linkText("个人工作台"));
            }
        }).click();
        Thread.sleep(1500);
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.linkText("发布新闻"));
            }
        }).click();
        Thread.sleep(1500);
        driver.switchTo().frame(0);
        /**
         * 设置标题
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("title"));
            }
        }).sendKeys(title);
        Thread.sleep(1000);
        /**
         * 设置keywords
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("keywords"));
            }
        }).sendKeys(keywords);
        Thread.sleep(1000);
        /**
         * 设置种类
         */
        WebElement dropdown = driver.findElement(By.id("category"));
        dropdown.findElement(By.xpath(category)).click();
        Thread.sleep(1000);
        /**
         * 点击发布按钮
         */
        driver.findElement(By.id("publish")).sendKeys(Keys.ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
