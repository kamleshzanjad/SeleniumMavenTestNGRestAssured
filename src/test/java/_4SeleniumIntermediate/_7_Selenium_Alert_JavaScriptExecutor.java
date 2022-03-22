package _4SeleniumIntermediate;

//import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _7_Selenium_Alert_JavaScriptExecutor {
    @Test
    public void TestAlert() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        // This step will result in an alert on screen
        WebElement element = driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        Thread.sleep(5000);
        System.out.println("Alert text is: " + alertText);
        confirmationAlert.accept();
        Thread.sleep(5000);
        driver.quit();
    }
}


/*



 */
