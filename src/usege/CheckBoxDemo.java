package usege;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxDemo {

    void simpleCheckBoxDemo(WebDriver driver){

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
    }
}
