package com.autotest.api;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * 窗口操作
 */
public class WindowDemo {

    private WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @Test
    public void testWindow(){
        driver.get("http://www.taobao.com");
        //浏览器方法最大化
        driver.manage().window().maximize();

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
