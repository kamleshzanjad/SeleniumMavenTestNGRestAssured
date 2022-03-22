package _4SeleniumIntermediate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _1_Selenium_ImplicitWait {
    @Test
    public void TestImplicitlyWait() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        // Exercise commnet timeouts like pageload and implicit wait
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        //  driver.manage().timeouts().setScriptTimeout(100,SECONDS);

        driver.manage().timeouts().implicitlyWait(20, SECONDS);


        WebElement radioEle = driver.findElement(By.xpath("//label[contains(text(), 'Other')]"));
        boolean select = radioEle.isSelected();
        System.out.print("Is is selected? " + select);

        driver.quit();
    }

}

/*
Is is selected? false
 */

/*
1 implicitlyWait
This means that we can tell Selenium that we would like it to wait for a certain amount of time
before throwing an exception that it cannot find the element on the page.
We should note that implicit waits will be in place for the entire time the browser is open.
This means that any search for elements on the page could take the time the implicit wait is set for.

2 PageLoadTimeout Command
Purpose: Sets the amount of time to wait for a page-load to complete before throwing an error.
If the timeout is negative, page loads can be indefinite.

3 SetScriptTimeout Command
Purpose: Sets the amount of time to wait for an asynchronous script to finish execution before throwing an error.
If the timeout is negative, then the script will be allowed to run indefinitely.
driver.manage().timeouts().setScriptTimeout(100,SECONDS);

4 Sleep Command
Purpose: This is rarely used, as it always force the browser to wait for a specific time.
Thread.Sleep is never a good idea and that's why Selenium provides wait for primitives.
If you use them you can specify much higher timeout value which makes tests more reliable without slowing them down as the condition can be evaluated as often as it's required.
thread.sleep(1000);

 */