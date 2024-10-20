package com.test;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        Utils.delay(5);
        DriverSingleton.closeObjectsInstance();
    }

    @Test(priority = 2)
    public void testValidLogin(){
    loginPage.loginUser("standard_user","secret_sauce");
    Assert.assertEquals(loginPage.getValidLogin(),"Swag Labs");
    }

    @Test(priority = 1)
    public void testInvalidLogin(){
        Utils.delay(3);
        loginPage.loginUser("invalid","invalid");
        Assert.assertEquals(loginPage.getTxtInvalid(),"Epic sadface: Username and password do not match any user in this service");
    }

}
