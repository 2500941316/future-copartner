package com.leassons;

import com.testng.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

public class LeassonManageApply extends BaseTest {
    @Test
    public void leassonApply() throws InterruptedException {
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

        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("title"));
            }
        }).click();

        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("title"));
            }
        }).sendKeys("人工智能概论");

        Thread.sleep(1500);

        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("body")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("body"));
            js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p class=\"p_text_indent_2\">本专业培养学生德智体美劳全面发展，具有坚实的数理基础、信息科学和经济管理科学等相关知识和技能，具有良好的科学思维和研究素养，系统掌握运用人工智能基础理论与基本方法实施智能商务数据的采集、存储、学习、分析和推理；具有运用人工智能的基本模型、原理与方法研究、分析、设计和解决复杂工程问题的能力，具有能够从事商务智能领域的相关应用研究与开发的能力，具有高度的社会责任感、良好的职业道德和终生学习能力的创新精神、创业意识和实践能力，了解人工智能关键领域的国际前沿技术，适应经济社会发展需要的新时代高层次复合型应用人才。</p><p><strong>二、基本要求</strong></p><p class=\"p_text_indent_2\">本专业培养的毕业生，必须从知识、能力、素养三方面达到以下基本要求：</p><p class=\"p_text_indent_2\">知识学习：</p><p class=\"p_text_indent_2\">（1）工程知识，能够将数学、自然科学、信息科学、工程基础、经管领域和人工智能专业知识结合，用于解决人工智能领域的复杂工程问题，采用人工智能方法处理商务数据的能力。</p><p class=\"p_text_indent_2\">（2）工具使用，能够针对人工智能应用领域的复杂工程问题，开发、选择与使用恰当的平台、技术、资源、现代工程工具和信息技术工具，包括对复杂工程问题的智能预测与人工模拟，并能够理解其局限性。</p><p class=\"p_text_indent_2\">（3）终生学习，具有自主学习和终身学习的意识，有不断学习和适应发展的能力，能够通过自主学习适应社会发展和技术革新的需要。</p>'}", element);
        }
        driver.switchTo().defaultContent();
        driver.findElement(By.id("teacher")).click();
        driver.findElement(By.id("teacher")).sendKeys("陈兴业");
        driver.findElement(By.id("number")).click();
        driver.findElement(By.id("number")).sendKeys("5");
        driver.findElement(By.id("time")).click();
        driver.findElement(By.id("time")).sendKeys("500");

        Thread.sleep(1500);

        driver.findElement(By.cssSelector(".layui-upload-file:nth-child(3)")).sendKeys("D:\\ad020.jpg");
        Thread.sleep(2000);
        driver.findElement(By.id("publish")).click();
        Thread.sleep(2000);
    }
}
