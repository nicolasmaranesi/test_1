package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.BaseClass.getDriver;

public class SearchPage extends Base{

    static By searchBar = By.id("APjFqb");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public static void newSearch(String text ) throws Exception{
        driver = getDriver();
        Type(text,searchBar);
        Sleep(10);
    }
}
