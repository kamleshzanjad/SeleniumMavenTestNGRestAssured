package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _7_RadioButtonHandling {
    @Test
    public void test() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement radioEle = driver.findElement(By.xpath("//label[contains(text(), 'Other')]"));
        boolean select = radioEle.isSelected();
        System.out.print(select);
        Thread.sleep(5000);
        if (!select ) {
           // radioEle.sendKeys();
            radioEle.click();
        }
        Thread.sleep(5000);

        WebElement radioElem = driver.findElement(By.xpath("//label[contains(text(), 'Male')]"));
        boolean sel = radioEle.isDisplayed();
        if (sel ) {
            radioElem.click();
        }
        Thread.sleep(5000);


        WebElement radioNo = driver.findElement(By.xpath("//label[contains(text(), 'Female')]"));
        boolean selectNo = radioEle.isDisplayed();
        if (selectNo ) {
            radioNo.click();
        }
        Thread.sleep(5000);

    }
}




/*
Radio buttons are denoted by the <input> HTML tags having "type" as "radio"
Moreover, we can locate the Radio button elements by id, name, XPath, or CSS selector.
Also, we can select Radio buttons by using the click() method.
Selenium also offers validation methods like isSelected(), isEnabled() and isDisplayed(). We can use these methods before performing any operation to make sure radio buttons are in the correct state
 */