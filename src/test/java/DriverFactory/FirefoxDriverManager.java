package DriverFactory;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{
    @Override
    public void createDriver(){
        System.setProperty("webdriver.gecko.driver","Drivers/geckodriver");
        System.setProperty("webdriver.gecko.silentOutput","true");
        driver = new FirefoxDriver();
    }

}
