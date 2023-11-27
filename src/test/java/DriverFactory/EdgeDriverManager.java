package DriverFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{

    @Override
    public void createDriver(){
        System.setProperty("webdriver.edge.driver","Drivers/msedgedriver");
        System.setProperty("webdriver.edge.silentOutput","true");
        driver = new EdgeDriver();
    }
}
