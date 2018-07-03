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
 * 3. 回到主页面，关闭租房tab
 */
public class SwitchWindow4 {
    private static final String HTTP_SH_GANJI_COM = "http://sh.ganji.com/";
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @Test
    public void testGanJi_PageSwitch_Keep_Original() {
        driver.get(HTTP_SH_GANJI_COM);

        //浏览器方法最大化
        driver.manage().window().maximize();
        String wantwindow = driver.getWindowHandle();
        driver.findElement(By.linkText("租房")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            WebDriver window1 = driver.switchTo().window(window);
            String url = window1.getCurrentUrl();

            System.out.println(url);
            if (url.contains("fang1")) {
                driver.close();
                break;
            }

        }
        driver.switchTo().window(wantwindow);
        driver.findElement(By.id("search_keyword")).sendKeys("我是老页面");
        pause(50);
    }

    //  driver.findElement(By.linkText("qq登录")).click();
    //   driver.switchTo().frame("ptlogin_iframe");
    //   driver.findElement(By.id("")).click();
    //pause(5);



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
