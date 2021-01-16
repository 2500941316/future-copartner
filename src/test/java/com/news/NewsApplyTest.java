package com.news;

import com.testng.TestStatic;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NewsApplyTest extends AbstractTestNGSpringContextTests {
    private WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

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
     * 测试前获取driver
     */
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", TestStatic.FIREFOXDRIVERVALUE);
        System.out.println("启动 ...");
        ChromeOptions chromeOptions = new ChromeOptions();
        //设置 chrome 的无头模式
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--hide-scrollbars");
        chromeOptions.addArguments("blink-settings=imagesEnabled=false");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--headless");
        //启动一个 chrome 实例
        driver = new ChromeDriver(chromeOptions);
        js = (JavascriptExecutor) driver;
        //显式等待， 针对某个元素等待
        wait = new WebDriverWait(driver, 10, 1);
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
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".current > .img-wrap")).click();
        driver.findElement(By.linkText("个人工作台")).click();
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
        }).sendKeys(title);
        /**
         * 设置keywords
         */
        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("keywords"));
            }
        }).sendKeys(keywords);

        /**
         * 设置种类
         */
        WebElement dropdown = driver.findElement(By.id("category"));
        dropdown.findElement(By.xpath(category)).click();

        /**
         * 点击发布按钮
         */
        driver.findElement(By.id("publish")).sendKeys(Keys.ENTER);

        //固定等待2秒
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
