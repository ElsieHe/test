package com.autotest.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.html.CSS;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class JdPage {

    JdPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    private WebDriver driver;
    @FindBy(id="key")
    public WebElement input;

    @FindBy(className = "button")
    public WebElement button;

    @FindBy(css = "#J_goodsList > ul > li:nth-child(1) > div > div.p-name.p-name-type-2 > a")
    private WebElement CSS_Orignal_Item;

    @FindBy(css = "#J_goodsList > ul > li:nth-child(1) > div > div.p-price > strong > i")
    private WebElement CSS_Original_Price;

    public String find_item(){
        return CSS_Orignal_Item.getText();
    }

    public String find_price(){
        return CSS_Original_Price.getText();
    }
    public void search(String str){
        try{
            sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        input.clear();
        try{
            sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        input.sendKeys(str);
    }

    public void click(){
        try{
            sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        button.click();
    }


}
