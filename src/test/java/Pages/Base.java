package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    public Base(WebDriver driver) {
        Base.driver = driver;

    }


    public static void Click(By locator) throws  Exception{
        try {
            driver.findElement(locator).click();
        }catch (Exception e){
            throw new Exception("Error: Element is not Clickeable." );
        }
    }

    public static void Type(String inputText , By locator) throws  Exception{
        try {
            driver.findElement(locator).sendKeys(inputText);
        }catch (Exception e){
            throw new Exception("Error: Element can not be writable.");
        }
    }

    public static String getText(By locator) throws Exception{
        try {
            return  driver.findElement(locator).getText();
        }catch (Exception e){
            throw new Exception("Error: Element does not contain a text.");
        }
    }

    public static void AssertText(By locator, String elementText) throws Exception{
        try {
            WebElement element = driver.findElement(locator);
            String currentString = element.getText();
            Assert.assertTrue(currentString.contains(elementText));
        }catch (Exception e){
            throw new Exception("Error: Assert could not be done.");
        }
    }

    public static void AssertElementIsDisplayed(By  locator) throws Exception{
        try {
            WebElement element = driver.findElement(locator);
            Assert.assertEquals(true,element.isDisplayed());
        }catch (Exception e){
            throw new Exception();
        }
    }

    public static void Wait(int seconds) throws Exception{
        try {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        }catch (Exception e){
            throw new Exception("Error: Driver could not execute the wait");
        }
    }

    public static void WaitTillElementIsClickeable(By locator, int seconds) throws Exception {

        try {
            WebDriverWait wait = new WebDriverWait(driver,seconds);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e){
            throw new Exception("Error: Element is not clickeable.");
        }
    }

    public static void WaitTillElementIsLocated(By locator, int seconds) throws Exception {

        try {
            WebDriverWait wait = new WebDriverWait(driver,seconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception e){
            throw new Exception("Error: Element is not located.");
        }
    }

    public static void AcceptAlert() throws Exception{

        try {
            driver.switchTo().alert().accept();
            driver.switchTo().window(driver.getWindowHandle());
        }catch (Exception e){
            throw new Exception("Error: browser couldn't manage Alert !");
        }
    }

    public static void Sleep(int second) throws InterruptedException {
        Thread.sleep(second* 1000L);
    }

    public static void Clear(By locator) throws Exception{
        try {
            driver.findElement(locator).clear();
        }catch (Exception e) {
            throw new Exception("Error: Field couldn't be cleared");
        }
    }



}
