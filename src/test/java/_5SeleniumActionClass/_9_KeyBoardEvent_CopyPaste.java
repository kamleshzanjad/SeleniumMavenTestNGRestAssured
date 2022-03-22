package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;

public class _9_KeyBoardEvent_CopyPaste {
    @Test
    public void KeyBoardOperation() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        //Navigate to the demo site
        driver.get("https://demoqa.com/text-box");

        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        //Enter the Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");

        // Enter the Current Address
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43SchoolLaneLondonEC719GO");

        // Copy the Current Address
//        currentAddress.sendKeys(Keys.CONTROL);
//        currentAddress.sendKeys("A");
//        currentAddress.sendKeys(Keys.CONTROL);
//        currentAddress.sendKeys("C");

        currentAddress.sendKeys(Keys.CONTROL+"a" );
        currentAddress.sendKeys(Keys.CONTROL+"c");
        //Press the TAB Key to Switch Focus to Permanent Address

        Thread.sleep(5000);
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("A");
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("C");


        Thread.sleep(5000);
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys(Keys.SHIFT);
        currentAddress.sendKeys(Keys.LEFT_SHIFT);
        currentAddress.sendKeys("a");
        currentAddress.sendKeys(Keys.CONTROL);
        currentAddress.sendKeys("c");


        Thread.sleep(5000);
        currentAddress.sendKeys(Keys.CONTROL+"A" );
        currentAddress.sendKeys(Keys.CONTROL+"C");

        Thread.sleep(5000);
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.CONTROL,"c")   );
        currentAddress.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.ARROW_LEFT,"a", Keys.CONTROL,"c")   );

        //Paste the Address in the Permanent Address field
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
//        permanentAddress.sendKeys(Keys.CONTROL);  //Keys.CONTROL+ "v"
//        permanentAddress.sendKeys("V");
        //currentAddress.sendKeys(Keys.TAB);
        permanentAddress.sendKeys(Keys.CONTROL+"v");

        Thread.sleep(15000);
        //Compare Text of current Address and Permanent Address
        //assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));

        driver.close();

    }
}


/*
Practice Exercise to retrieve ToolTip in Selenium

Find below the steps of the scenario to be automated:

    Open URL http://demoqa.com/tooltip/
    Identify web element Age textbox
    Retrieve 'title' attribute value of the web element
    Verify the text of 'title' attribute value matches with expected text
    Close the page

 */