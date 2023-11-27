package Utils;

import DriverFactory.DriverManager;
import DriverFactory.DriverManagerFactory;
import DriverFactory.DriverType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.varia.NullAppender;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    public static WebDriver driver;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;
    private static int caseNumber = 0;

    private DriverManager driverManager;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeSuite
    public void setRport(){
        String suitName = this.getClass().getSimpleName();
        htmlReporter =  new ExtentHtmlReporter("./src/report/" + suitName + ".html");
        htmlReporter.config().setEncoding("uft-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester","Nicolas Maranesi");
        extent.setSystemInfo("organization","Teceng Gaming");
        org.apache.log4j.BasicConfigurator.configure(new NullAppender());
        String ANSI_PURPLE = "\u001B[35m";
        System.out.println( ANSI_PURPLE +"Test suite execution starts. "  + ANSI_PURPLE);

    }

    @BeforeMethod
    public void setUp(){
        caseNumber++;
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("http://192.168.80.236/login");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void getResutl(ITestResult result) throws Exception {
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";

        Util.EvidenceCapture(driver, this.getClass().getSimpleName(),result.getName(),result.getName());

        if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL,"The Test "+ result.getName() + " failed.");
            System.out.println(ANSI_RED+"The Test: "+result.getName()+", Description: "+result.getMethod().getDescription()+"Failed"+ANSI_RED);
            System.out.println(ANSI_RED+"Scenario Nro:" + caseNumber + " failed the execution."+ ANSI_RED);
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP,"The Test "+ result.getName() + " skipped.");
            System.out.println(ANSI_YELLOW+"The Test: "+result.getName()+", Description: "+result.getMethod().getDescription()+" Skipped. "+ANSI_YELLOW);
            System.out.println(ANSI_YELLOW+"Scenario Nro:" + caseNumber + " skipped the execution." +ANSI_YELLOW);

        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS,"The Test "+ result.getName() + " passed. ");
            System.out.println(ANSI_GREEN+"The Test: "+result.getName()+", Description: "+result.getMethod().getDescription()+" Passed. "+ANSI_GREEN);
            System.out.println(ANSI_GREEN+"Scenario Nro:" + caseNumber + " passed the execution."  +ANSI_GREEN);
        }
        driverManager.quitDriver();
    }
    @AfterSuite
    public void endClass(){
        String ANSI_PURPLE = "\u001B[35m";
        extent.flush();
        if(driver != null){
            driver.quit();
        }
        System.out.println( ANSI_PURPLE +"Test suite execution end. " + ANSI_PURPLE);
    }


}
