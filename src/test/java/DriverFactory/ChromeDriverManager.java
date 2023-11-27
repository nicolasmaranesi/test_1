package DriverFactory;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{
    @Override
    public void createDriver(){
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput","true");
        driver = new ChromeDriver();
    }
}
