package com.test;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.pages.AddProducts;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductTest {

    private WebDriver driver;

    private LoginPage loginPage;

    private AddProducts addProducts;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        addProducts = new AddProducts();
    }

    @AfterClass
    public void finish(){
        Utils.delay(5);
        DriverSingleton.closeObjectsInstance();
    }

    @Test
    public void testAddToCart(){
        loginPage.loginUser("standard_user","secret_sauce");
        addProducts.addToCart();
        addProducts.checkCart();
    }



}
