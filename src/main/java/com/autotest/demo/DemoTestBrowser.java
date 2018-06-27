package com.autotest.demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

/**
 * @author:Elsie
 * */
public class DemoTestBrowser {
    /**
     * 打开浏览器首页
     * */
    private WebDriver driver;
    @BeforeClass
    public void newDriver()
    {
        driver = new ChromeDriver();
    }
    @AfterClass
    public void quitDriver()
    {
        driver.quit();
    }
    @Test
    public void testChrome(){
    //    ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        Assert.assertEquals(title, "\u767e\u5ea6\u4e00\u4e0b，\u4f60\u5c31\u77e5\u9053");
  //      driver.quit();
    }
    @Test
    public void testFireFox(){
      //  System.setProperty("webdriver.firefox.bin,"");
      //  WebDriver driver = new FirefoxDriver();
      //  driver.get("http://www.baidu.com");
      //  driver.manage().window().maximize();
        // String title = driver.getTitle();
       // Assert.assertEquals(title, "\u767e\u5ea6\u4e00\u4e0b，\u4f60\u5c31\u77e5\u9053");
       // driver.quit();
    }

    @Test
    public void testIE(){
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        Assert.assertEquals(title, "\u767e\u5ea6\u4e00\u4e0b，\u4f60\u5c31\u77e5\u9053");
        driver.quit();
    }
}
