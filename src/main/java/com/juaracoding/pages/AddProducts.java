package com.juaracoding.pages;

import com.juaracoding.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProducts {

    private WebDriver driver;

    public AddProducts(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement btnAddBackPack;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement btnCart;

    public void addToCart(){
        btnAddBackPack.click();
    }

    public void checkCart(){
        btnCart.click();
    }
}
