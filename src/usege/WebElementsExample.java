package usege;

import com.selenium.BrowserCommands;
import com.selenium.SetupSeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.LocalDate;

public class WebElementsExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = SetupSeleniumWebDriver.launchBrowserUsingWDM("chrome");

        String URL = "https://demo.seleniumeasy.com/";
        driver.get(URL);

        WebElementsExample webEleExample = new WebElementsExample();
        webEleExample.waitAndClosePopup(driver);
        webEleExample.formsDemo(driver);
        webEleExample.simpleCheckBoxDemo(driver);
        webEleExample.Dropdown(driver);
        webEleExample.datePicker(driver);

        BrowserCommands browserCommands = new BrowserCommands(driver);
        // browserCommands.closeBrowserWindow(true);

    }

    void waitAndClosePopup(WebDriver driver) throws InterruptedException {
        By closePopUpLoc = By.id("at-cv-lightbox-close");
        Thread.sleep(2000);
        WebElement closePopupLoc = driver.findElement(closePopUpLoc);
        closePopupLoc.click();
    }

    void formsDemo(WebDriver driver) throws InterruptedException {
        By inputFormsLoc = By.xpath("//ul[@id=\"treemenu\"]//a[text()='Input Forms']");
        WebElement inputformlink = driver.findElement(inputFormsLoc);
        inputformlink.click();

        By simpleFormDemoLoc = By.linkText("Simple Form Demo");
        WebElement simpleFormDemolink = driver.findElement(simpleFormDemoLoc);
        simpleFormDemolink.click();

        By enterMsgTextLoc = By.cssSelector("input#user-message");
        WebElement entermsgTextbox = driver.findElement(enterMsgTextLoc);
        entermsgTextbox.click();
        entermsgTextbox.clear();
        entermsgTextbox.sendKeys("This is the message for input box");
        Thread.sleep(2000);

        By showMsgBtnLoc = By.cssSelector("#get-input>button");
        Thread.sleep(2000);
        WebElement showMsgbutton = driver.findElement(showMsgBtnLoc);
        System.out.println("pass");
        showMsgbutton.click();
    }

    void simpleCheckBoxDemo(WebDriver driver) {
        By inputFormsLoc = By.xpath("//ul[@id=\"treemenu\"]//a[text()='Input Forms']");
        WebElement inputformlink = driver.findElement(inputFormsLoc);
        inputformlink.click();

        By checkBoxLinkLoc = By.xpath("//ul[@id=\"treemenu\"]//a[text()=\"Checkbox Demo\"]");
        WebElement checkboxDemolink = driver.findElement(checkBoxLinkLoc);
        checkboxDemolink.click();

        By ageCheckBoxLoc = By.id("isAgeSelected");
        WebElement agecheckbox = driver.findElement(ageCheckBoxLoc);
        System.out.println("check box is selected");
        agecheckbox.click();

        By checkAllboxloc = By.xpath("//input[@id=\"check1\"]");
        WebElement checkallbox = driver.findElement(checkAllboxloc);
        System.out.println("check all box");
        checkallbox.click();
        checkallbox.click();
        System.out.println("uncheck all box");
    }

    void Dropdown(WebDriver driver) {

        By inputFormsLoc = By.xpath("//ul[@id=\"treemenu\"]//a[text()='Input Forms']");
        WebElement inputformlink = driver.findElement(inputFormsLoc);
        inputformlink.click();

        By dropdownBoxLinkLoc = By.xpath("//ul[@id=\"treemenu\"]//a[text()=\"Select Dropdown List\"]");
        WebElement dropdownboxDemolink = driver.findElement(dropdownBoxLinkLoc);
        dropdownboxDemolink.click();

        By dropdownLoc = By.id("select-demo");
        WebElement dropdown = driver.findElement(dropdownLoc);

        Select daydropDown = new Select(dropdown);

        daydropDown.selectByValue("Sunday");

        daydropDown.selectByIndex(0);

        daydropDown.selectByVisibleText("Sunday");
        System.out.println("sunday selected");

        By cityDropDownLoc = By.id("multi-select");
        WebElement cityDD = driver.findElement(cityDropDownLoc);

        Select cityDropDown = new Select(cityDD);
        cityDropDown.selectByVisibleText("Florida");
        cityDropDown.deselectByIndex(1);
        System.out.println("city florida is selected");

        By getAllSelectedLoc = By.id("printAll");
        WebElement getAllSelectButton = driver.findElement(getAllSelectedLoc);
        getAllSelectButton.click();
    }

    void datePicker(WebDriver driver){

//    By inputFormsLoc = By.xpath("//ul[@id=\"treemenu\"]//a[text()='Input Forms']");
//    WebElement inputformlink = driver.findElement(inputFormsLoc);
//        inputformlink.click();

    By datePickerBoxLinkLoc = By.xpath("//ul[@id=\"treemenu\"]//a[text()='Date pickers']");
    WebElement datePickerBoxlink = driver.findElement(datePickerBoxLinkLoc);
         datePickerBoxlink.click();
        System.out.println("datepicker element is selected form");
        //ul[@id="treemenu"]//a[text()='Bootstrap Date Picker']
    By bootstripLoc = By.xpath("//ul[@id=\"treemenu\"]//a[text()='Bootstrap Date Picker']");
    WebElement bootstriplink = driver.findElement(bootstripLoc);
    bootstriplink.click();
        //td[contains(@class, 'day')and text()='26']
}

void getDMYFromLocalDate(){
    LocalDate todaysDate = LocalDate.now();
    System.out.println("Todays date:" + todaysDate);

    System.out.println("Day : "+ todaysDate.getDayOfMonth());
    System.out.println("Month : "+ todaysDate.getMonthValue());
    System.out.println("Month in words :"+ todaysDate.getMonth());
    System.out.println("Year: "+todaysDate.getYear());

    LocalDate nextTenDayDate = todaysDate.plusDays(10);
    System.out.println("next ten days Date : "+ nextTenDayDate.getDayOfMonth());
    System.out.println("next ten month :"+ nextTenDayDate.getMonthValue());
    System.out.println("month in word : "+nextTenDayDate.getMonth());
    System.out.println("Year: "+nextTenDayDate.getYear());

    LocalDate previous25DaysDate = todaysDate.minusDays(25);

    System.out.println("Day :"+ previous25DaysDate.getDayOfMonth());
    System.out.println("month :"+ previous25DaysDate.getMonthValue());
    System.out.println("Month in word: "+previous25DaysDate.getMonth());
    System.out.println("year : "+previous25DaysDate.getMonth());
}
void datePickerExample(){
        LocalDate todayDate = LocalDate.now();
    //div[@class="input-group date"]/input[@type='text']
}
}