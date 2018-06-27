package com.autotest.api;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeWordDemo {
    private WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @Test
    public void testWindow(){
        driver.get("https://www.baidu.com/");
        //浏览器方法最大化
        driver.manage().window().maximize();
        driver.findElement(By.id("kw")).sendKeys("博客园"+ Keys.ENTER);
        pause(3);
        driver.findElement(By.id("kw")).sendKeys(""+Keys.BACK_SPACE);
        pause(3);
        driver.findElement(By.id("kw")).sendKeys(""+Keys.LEFT_CONTROL+"a");
        pause(3);
        driver.findElement(By.id("kw")).sendKeys(""+Keys.LEFT_CONTROL+"c");
        pause(3);
        driver.findElement(By.id("kw")).sendKeys(""+Keys.LEFT_CONTROL+"v");
        pause(3);


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
