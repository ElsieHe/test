package com.autotest.api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserDemo {
    private WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @Test
    public void testBrowser(){
        driver.get("https://www.baidu.com/");
        //浏览器方法最大化
        driver.manage().window().maximize();

        driver.navigate().to("httpw://www.googole.com/");
        pause(2);
        driver.navigate().back();
        pause(2);
        driver.navigate().forward();
        pause(2);
        driver.navigate().refresh();
        pause(2);
        String title = driver.getTitle();
        System.out.println("title \t" +title);
        //获取当前的url
        String currenturl = driver.getCurrentUrl();
        System.out.println("current url \t" +currenturl);
        //获取页面源代码
        String pageSource = driver.getPageSource();
        System.out.println("pageSource \t" + pageSource);
        //driver.manage().window().setSize(new Dimension(375,600));
        //设置窗口在某个位置打开
        //driver.manage().window().setPosition(new Point(400,500));
        //driver.manage().window().fullscreen();

    }

    private void pause(int i){
        try {
            Thread.sleep(1000 * i);
        }
        catch(InterruptedException e) {System.out.println(e);}

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
