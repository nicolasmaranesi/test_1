package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Util {
    public static String folderDate;

    public static void EvidenceCapture(WebDriver driver, String classType, String folderName, String fileName){
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy-HHmmss");
        if(folderDate == null){
            folderDate = formatter.format(date);
        }
        String pathAndFile = System.getProperty("user.dir")
                + File.separator + "Evidences"
                + File.separator + folderDate
                + File.separator + classType
                + File.separator + folderName
                + File.separator + fileName + ".png";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src, new File(pathAndFile));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static int createRandomDNI(){
        Random random = new Random();
        int numeroDNI = 10000000 + random.nextInt(90000000);
        return numeroDNI;
    }
}
