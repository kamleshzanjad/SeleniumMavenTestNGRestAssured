package _4SeleniumIntermediate;

//import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class _6_Selenium_Alert {
    @Test
    public void TestAlert() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        // This step will result in an alert on screen
        driver.findElement(By.id("alertButton")).click();
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Alert message is: " + simpleAlert.getText());
        Thread.sleep(5000);
        simpleAlert.accept();
        Thread.sleep(5000);
        driver.quit();
    }
}


/*
A lot of the times, when we are filling in a form and press the submit button, an alert pops up,
telling me, "Contact Number is Required". At times, I forget to check the terms and conditions box,
and I get the same as a notification via a popup-up alert. Pressing the OK  button on the alert box
takes me back to the form, and the form does not submit until I have filled everything "required".
These use cases show how necessary are the "Alerts" or "Popups" in Web Applications.

Alerts are small popup boxes/windows which display the messages/notifications and
notify the user with some information seeking some permission on certain kinds of operations.
Additionally, we can also use them for warning purposes.
Sometimes, the user can enter a few details in the alert box as well.

To handle Javascript alerts, Selenium WebDriver provides the package org.openqa.selenium.Alert  and exposes the following methods:

    Void accept(): This method clicks on the 'OK' button of the alert box.

driver.switchTo( ).alert( ).accept();

    Void dismiss(): We use this method when the 'Cancel' button clicks in the alert box.

driver.switchTo( ).alert( ).dismiss();

    String getText(): This method captures the message from the alert box.

driver.switchTo().alert().getText();

    Void sendKeys(String stringToSend): This method sends data to the alert box.

driver.switchTo().alert().sendKeys("Text");


 */
