package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.BaseClass.getDriver;

public class LoginPage extends Base{
    private static By loginField = By.id("email");
    private static By passwordField = By.id("password");
    private static By loginButton = By.xpath("//button[contains(text(), 'Sign In')]");
    private static By downloadAppLink = By.xpath("//a[contains(text(), 'Download the application for android')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static void inputUser(String username) throws Exception {
        driver = getDriver();
        WaitTillElementIsClickeable(loginField, 30);
        Click(loginField);
        Type(username,loginField);
        Wait(3);
    }
    private static void inputPassword(String password) throws Exception {
        Click(passwordField);
        Type(password,passwordField);
        Wait(10);
    }
    private static void clickLogin() throws Exception{
        WaitTillElementIsClickeable(loginButton,10);
        Click(loginButton);
        Wait(30);
    }

    public static void Login(String usename, String password) throws Exception{
        inputUser(usename);
        inputPassword(password);
        clickLogin();
    }


}
