package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class _2_DoubleClick {
    @Test
    public void DoubleClickOperation() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        // Launch the URL
        driver.get("https://demoqa.com/buttons");
        System.out.println("Demoqa Web Page Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform double click WebElement
        WebElement btnElement = driver.findElement(By.id("doubleClickBtn"));

        //Double Click the button
        actions.doubleClick(btnElement).perform();
        Thread.sleep(5000);

        System.out.println("Button is double clicked");

        //Following code just click on OK button on alert , this differs
        //depending upon application(under test) specific test case
        // Accept the Alert
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        System.out.println("Double click Alert Accepted");

        //Close the main window
        driver.close();
    }
}
