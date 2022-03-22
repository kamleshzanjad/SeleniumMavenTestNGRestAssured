package _4SeleniumIntermediate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class _2_Selenium_ExplicitWait {
    @Test
    public void TestExplicitWait() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(1, MILLISECONDS);

        String locImage="html body div#app header a img";
        WebElement image= driver.findElement(By.cssSelector(locImage));
        System.out.println("Is image present? "+ image.isDisplayed());

        WebElement radioEle = driver.findElement(By.xpath("//label[contains(text(), 'Other')]"));


        // Create new WebDriver wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(radioEle));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Other')]"));


        boolean select = radioEle.isSelected();
        System.out.print("Is it selected?" +select);

        driver.close();
    }

}


/*
Practice Exercise




 */