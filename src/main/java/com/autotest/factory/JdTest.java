package com.autotest.factory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class JdTest {
    private WebDriver driver;
    JdPage jdPage;
    JdItemPage jdItemPage;

    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
        jdPage = new JdPage(driver);
        driver.get("http://www.jd.com");
    }

    @Test(dataProvider = "test")
    public void test_Search(String key) {
        jdPage.search(key);
        jdPage.click();
        String title = driver.getTitle();
        pause(3);
        String original_item = jdPage.find_item();
        String original_price = jdPage.find_price();

        String wantwindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            WebDriver window1 = driver.switchTo().window(window);
            String url = window1.getCurrentUrl();
            System.out.println(url);
            if (url.contains(original_item)) {
                Assert.assertEquals(original_item, jdItemPage.find_item());
                Assert.assertEquals(original_price, jdItemPage.find_price());
                driver.close();
                break;
            }

        }
        driver.switchTo().window(wantwindow);

        pause(3);
    }
    @DataProvider
    public Object[][]test(){
        return new Object[][]{
                {"篮球"},{"足球"}
        };
    }
    private void screenShot(String desc){
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File files = new File(desc+".jpg");
        try{
            FileUtils.copyFile(screen,files);
        }catch (IOException e){
            e.printStackTrace();
        }
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
