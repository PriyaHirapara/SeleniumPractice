package usege;

import com.selenium.SetupSeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadAFile {

    public UploadAFile(){
        //TODO Auto-generated constructor stub
    }
    public static void main(String[] args){
        String URL = "https://demo.guru99.com/test/upload/";
        WebDriver driver = SetupSeleniumWebDriver.launchBrowserUsingWDM("chrome");
        driver.get(URL);
        By uploadFileLoc = By.id("uploadfile_0");
        WebElement uploadFile = driver.findElement(uploadFileLoc);
        uploadFile.sendKeys("");
    }
}
