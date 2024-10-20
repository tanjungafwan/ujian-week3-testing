package com.test;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.pages.AddProducts;
import com.juaracoding.pages.CheckOutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckOutTest {

        private WebDriver driver;

        private LoginPage loginPage;

        private AddProducts addProducts;

        private CheckOutPage checkOutPage;

        @BeforeClass
        public void setUp() {
            DriverSingleton.getInstance("firefox");
            driver = DriverSingleton.getDriver();
            driver.get("https://www.saucedemo.com/");
            loginPage = new LoginPage();
            addProducts = new AddProducts();
            checkOutPage = new CheckOutPage();
        }

        @AfterClass
        public void finish() {
            Utils.delay(5);
            DriverSingleton.closeObjectsInstance();
        }

        @Test(priority = 1)
        public void testValidCheckOutItem() {
            loginPage.loginUser("standard_user", "secret_sauce");
            addProducts.addToCart();
            addProducts.checkCart();
            checkOutPage.checkOut();
            checkOutPage.inputInformation("rizki","afwan","11234");
            Assert.assertEquals(checkOutPage.inputValidInformation(),"Payment Information:");
            checkOutPage.finish();
            checkOutPage.backHome();
        }

        @Test(priority = 2)
        public void testInvalidCheckOutItem() {
            addProducts.addToCart();
            addProducts.checkCart();
            checkOutPage.checkOut();
            checkOutPage.inputInformation("","","");
            Assert.assertEquals(checkOutPage.inputInvalidInformation(),"Error: First Name is required:");
            checkOutPage.finish();
            checkOutPage.backHome();
        }


}
