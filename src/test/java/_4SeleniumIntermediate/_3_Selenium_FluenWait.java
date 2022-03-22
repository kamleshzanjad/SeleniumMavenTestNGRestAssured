package _4SeleniumIntermediate;

//import java.time.Duration;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait; //FluentWait is a Class and it is a part of this package
import org.testng.annotations.Test;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class _3_Selenium_FluenWait {
    @Test
    public void TestFluentWait() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.get("http://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
        driver.findElement(By.xpath("//*[@id='post-body-5280210221385817166']/div[1]/button")).click();
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                                            public WebElement apply(WebDriver driver) {
                                                WebElement element = driver.findElement(By.xpath("//*[@id='softwareTestingMaterial']"));
                                                String getTextOnPage = element.getText();
                                                if(getTextOnPage.equals("Software Testing Material - DEMO PAGE")){
                                                    System.out.println(getTextOnPage);
                                                    return element;
                                                }else{
                                                    System.out.println("FluentWait Failed");
                                                    return null;
                                                }
                                            }
        });
        driver.close();
    }
}


/*
Practice Exercise
Error Failure
org.openqa.selenium.TimeoutException: Expected condition failed: waiting for _4SeleniumIntermediate._3_Selenium_FluenWait$1@44040454 (tried for 30 second(s) with 5000 milliseconds interval)

 */

/*
FluentWait can define the maximum amount of time to wait for a specific condition and frequency with
which to check the condition before throwing an “ElementNotVisibleException” exception.
luent waits are also called smart waits also.
They are called smart primarily because they don't wait for the max time out, specified in the .withTimeout(5000, TimeUnit.MILLISECONDS).
Instead, it waits for the time till the condition specified in .until(YourCondition) method becomes true.
 */