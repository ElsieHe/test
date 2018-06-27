package com.autotest.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseDemo {
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
        WebElement element = driver.findElement(By.linkText("设置"));
        Actions action = new Actions(driver);
        action.clickAndHold(element).perform();
        driver.findElement(By.linkText("高级搜索")).click();
        action.contextClick().perform();
        pause(2);


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
