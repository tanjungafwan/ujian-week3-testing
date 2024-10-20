package com.juaracoding.pages;

import com.juaracoding.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id='header_container']/div[1]/div[2]/div")  //span[@]
    private WebElement valid;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtInvalid;

    public void clearFields() {
        username.clear();
        password.clear();
    }

    public void loginUser(String username, String password){
        clearFields();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public String getValidLogin(){
        return valid.getText();
    }

    public String getTxtInvalid(){
        return txtInvalid.getText();
    }
}
