package com.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SetupSeleniumWebDriver {

    public void setBrowserDriver(String browserName){
        String browserDriverDir = System.getProperty("user.dir") + "\\browserDrivers";
        switch (browserName){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", browserDriverDir+"\\geckodriver.exe");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", browserDriverDir+"\\msedgedriver.exe");
                break;
            default:
                System.setProperty("webdriver.chrome.driver", browserDriverDir+"\\chromedriver.exe");
                break;
        }

    }

//

// WebDrivermanager library is added in libs and configer jar
        public static WebDriver launchBrowserUsingWDM(String browserName){
        WebDriver browserInstance = null;

        if(browserName.equalsIgnoreCase("FF")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            browserInstance = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);// for load the page
            browserInstance = new EdgeDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);//pageload strategy is for to help page load
            browserInstance = new ChromeDriver();
        }
        return browserInstance;
    }
    public static void browserCommands(WebDriver driver){
        driver.get("https://www.google.com");
        driver.navigate().refresh();
        driver.get("https://twitter.com");
        driver.navigate().back();
        //driver.navigate().forward();
        System.out.println("Page Title: "+driver.getTitle());
    }

    public static String openNewTab(WebDriver driver){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        System.out.println("Page title: "+driver.getTitle());
        String nameofTheNewTab = driver.getWindowHandle();
        System.out.println("Tab name: "+ nameofTheNewTab);
        return nameofTheNewTab;
    }
    public static void main(String[] args){
        WebDriver bs = launchBrowserUsingWDM("chrome");
        //bs.manage().window().maximize();
       browserCommands(bs);
       String firstTabHandle = bs.getWindowHandle();
        System.out.println("First Tab name: "+firstTabHandle);
       String secondTabHandle = openNewTab(bs);
        bs.switchTo().window(firstTabHandle);
        bs.navigate().forward();
        System.out.println("Page title: "+bs.getTitle());
//        bs.close();
//        bs.quit();
    }
}



