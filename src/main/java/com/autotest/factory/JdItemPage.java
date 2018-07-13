package com.autotest.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class JdItemPage {
    JdItemPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    private WebDriver driver;


    @FindBy(css = "div.sku-name")
    private WebElement CSS_New_Item;

    @FindBy(css = "span.p-price > span.price")
    private WebElement CSS_New_Price;


    public String find_item(){
        return CSS_New_Item.getText();
    }
    public String find_price(){
        return CSS_New_Price.getText();
    }
}
