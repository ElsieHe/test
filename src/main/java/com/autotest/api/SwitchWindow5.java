package com.autotest.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * 1.访问ganji网
 * 2. 跳转到租房tab
 * 3. 关闭主页面，保留租房tab
 */
public class SwitchWindow5 {
    private static final String HTTP_SH_GANJI_COM = "http://sh.ganji.com/";
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @Test
    public void testGanJi_PageSwitch_Keep_New() {
        driver.get(HTTP_SH_GANJI_COM);
        //浏览器方法最大化
        driver.manage().window().maximize();
        String wantwindow = null;
        driver.findElement(By.linkText("租房")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            WebDriver window1 = driver.switchTo().window(window);
            String url = window1.getCurrentUrl();
            System.out.println(url);
            if (url.contains("fang1")) {
                wantwindow = driver.getWindowHandle();
            }
            else {
                driver.close();
            }
        }
        driver.switchTo().window(wantwindow);
        pause(50);
        driver.findElement(By.id("search_keyword")).sendKeys("我是新页面");

    }

    private void pause(int i){
        try {
            Thread.sleep(1000 * i);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
