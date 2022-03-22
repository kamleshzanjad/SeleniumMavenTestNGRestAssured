package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class _6_CheckBoxHandling {
    @Test
    public void test() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();


        /**
         * Validate isSelected and click
         */

        WebElement checkBoxSelected = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isSelected = checkBoxSelected.isSelected();

        // performing click operation if element is not selected
        if(isSelected == false) {
            checkBoxSelected.click();
        }
        Thread.sleep(5000);
        /**
         * Validate isDisplayed and click
         */
        WebElement checkBoxDisplayed = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isDisplayed = checkBoxDisplayed.isDisplayed();

        // performing click operation if element is displayed
        if (isDisplayed == true) {
            checkBoxDisplayed.click();
        }
        Thread.sleep(5000);

        /**
         * Validate isEnabled and click
         */
        WebElement checkBoxEnabled = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isEnabled = checkBoxEnabled.isDisplayed();

        // performing click operation if element is enabled
        if (isEnabled == true) {
            checkBoxEnabled.click();
        }
        Thread.sleep(5000);

    }
}




/*

    CheckBoxes are denoted by <input type="checkbox">` HTML tag
    We can identify the Checkbox elements by locator strategies such as id, XPath, CSS selector, or any other selenium locator that can uniquely identify the checkbox
    We can select a checkbox either by using the click() method on the input node or on the label node that represents the checkbox.
    Selenium also offers validation methods like isSelected, isEnabled, and isDisplayed. We can use these methods to make sure checkboxes are in the correct status before performing any operation.

 */