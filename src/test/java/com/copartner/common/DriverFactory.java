package com.copartner.common;

import com.copartner.testng.TestStatic;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverFactory {
    public void init(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
        System.setProperty(TestStatic.FIREFOXDRIVERKEY, TestStatic.FIREFOXDRIVERVALUE);
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, TestStatic.BROWSER_LOGFILE);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(TestStatic.BROWSER_EXE);
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        //显式等待， 针对某个元素等待
        wait = new WebDriverWait(driver, 10, 1);
    }


    public void close(WebDriver driver) {
        driver.close();
    }
}
