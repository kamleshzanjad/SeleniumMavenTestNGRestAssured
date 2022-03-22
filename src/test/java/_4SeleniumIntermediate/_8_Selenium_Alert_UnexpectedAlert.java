package _4SeleniumIntermediate;

//import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class _8_Selenium_Alert_UnexpectedAlert {
    @Test
    public void TestAlert() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        try {
            driver.findElement(By.id("timerAlertButton")).click();
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            Thread.sleep(5000);
            simpleAlert.accept();
            Thread.sleep(5000);
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }

        driver.quit();
    }
}


/*



 */
