package usege;

import com.selenium.BrowserCommands;
import com.selenium.SetupSeleniumWebDriver;
import org.openqa.selenium.WebDriver;

public class UsingBrowserCommand {
    public static void main(String[] args){
        String googleURL = "https://www.google.co.in";

        String selEasyURL = "https://demo.seleniumeasy.com";

        SetupSeleniumWebDriver selSetup = new SetupSeleniumWebDriver();
        WebDriver driver= selSetup.launchBrowserUsingWDM("chrome");


        BrowserCommands browserCommands = new BrowserCommands(driver);
        String firstTabName = browserCommands.getWindowOrTabHandle();

        browserCommands.setBrowserSize(1024, 768, false);
        browserCommands.openURL(googleURL);
        System.out.println("Page title: "+browserCommands.getPageTitle());

        browserCommands.openNewTabOrWindow("tab");
       // browserCommands.openURL(demoQAURL);

        browserCommands.closeBrowserWindow(false);
        browserCommands.switchToTabOrWindow(firstTabName);
       // browserCommands.openURL(facebookURL);

        browserCommands.openNewTabOrWindow("window");
        browserCommands.openURL(selEasyURL);
        System.out.println("Page title: "+browserCommands.getPageTitle());
        System.out.println("Page URL:" +browserCommands.getPageURL());

        System.out.println("All windows: "+browserCommands.getOpenedWindowNames());

        browserCommands.closeBrowserWindow(true);
    }
}

