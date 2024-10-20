package com.juaracoding.pages;

import com.juaracoding.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

public class CheckOutPage {

    private WebDriver driver;

    public CheckOutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement itemCheckOut;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCode;

    @FindBy(xpath = "//div[normalize-space()='Payment Information:']")
    private WebElement validInformation;

    @FindBy(xpath = "//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3")
    private WebElement invalidInformation;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement btnFinish;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement btnBackHome;

    public void checkOut(){
        itemCheckOut.click();
    }

    public void inputInformation(String firstName, String lastName, String zipCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
        btnContinue.click();
    }

    public void finish(){
        btnFinish.click();
    }

    public void backHome(){
        btnBackHome.click();
    }

    public String inputValidInformation(){
        return validInformation.getText();
    }

    public String inputInvalidInformation(){
        return invalidInformation.getText();
    }

}
