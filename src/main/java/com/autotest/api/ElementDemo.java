package com.autotest.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementDemo {
    private WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @Test
    public void testBrowser(){
        driver.get("https://www.jd.com/");
        //浏览器方法最大化
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("key"));
        element.clear();
        element.sendKeys("测试");
        pause(3);
        element = driver.findElement(By.className("button"));
        System.out.println(element.isEnabled()+"\t"+element.isDisplayed());
        element.click();
        pause(3);
        element = driver.findElement(By.xpath("//button[text()='搜索']"));
        element.click();
        //element.submit();
        String className = element.getAttribute("class");
        System.out.println("classname" + className);
        String top  = element.getAttribute("top");
        System.out.println("top \t" + top);




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
        //WindowsUtils.findTaskKill();
    }
}
