package com.autotest.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DraggingDemo {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @Test
    public void testWindow(){
        driver.get("http://localhost:8080/index.html");
        //浏览器方法最大化
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("//li[text()='A']")).click();
        Actions action = new Actions(driver);
        // 鼠标右键点击指定的元素
        //action.contextClick(driver.findElement(By.xpath("//li[text()=\"A\"]"))).perform();
        // 鼠标右键点击指定的元素
        // action.doubleClick(driver.findElement(By. id ("element"))).perform();
        // 鼠标拖拽动作，将 source 元素拖放到 target 元素的位置。
        WebElement source = driver.findElement(By.xpath("//li[text()=\"A\"]"));
        WebElement target = driver.findElement(By.xpath("//div[@class=\"container\"]/ul[2]"));
        action.dragAndDrop(source,target).perform();
        // 释放鼠标
        action.release().perform();
        pause(4);
        source = driver.findElement(By.xpath("//li[text()=\"A\"]"));
        target = driver.findElement(By.xpath("//div[@class=\"container\"]/ul[3]"));
        action.dragAndDrop(source,target).perform();
        action.release().perform();
        pause(5);


    }
    private void pause(int i){
        try {
            Thread.sleep(1000 * i);
        }
        catch(InterruptedException e) {
            System.out.println(e);
        }

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
