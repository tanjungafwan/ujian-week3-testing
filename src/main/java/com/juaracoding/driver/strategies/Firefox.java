package com.juaracoding.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

    @Override
    public WebDriver setStrategy(){
        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Tools\\geckodriver.exe");
        return new FirefoxDriver();
    }
}