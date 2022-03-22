package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _2_NavigationCommands {
    @Test
    public void test() {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);

        // Create a new instance of the FireFox driver
        WebDriver driver = new ChromeDriver();

        // Open ToolsQA web site
        String appUrl = "https://demoqa.com/";
        driver.get(appUrl);

        // Click on Registration link
        driver.findElement(By.xpath("//h5[text()='Forms']")).click();

        // Go back to Home Page
        driver.navigate().back();

        // Go forward to Registration page
        driver.navigate().forward();

        // Go back to Home page
        driver.navigate().to(appUrl);

        // Refresh browser
        driver.navigate().refresh();

        // Close browser
        driver.close();
    }

}




/*
Practice Exercise

    Launch new Browser
    Open DemoQA.com website
    Click on Registration link using "driver.findElement(By.xpath(".//[@id='menu-item-374']/a")).click();"*  or //h5[text()='Forms']
    Come back to Home page (Use 'Back' command)
    Again go back to Registration page (This time use 'Forward' command)
    Again come back to Home page (This time use 'To' command)
    Refresh the Browser (Use 'Refresh' command)
    Close the Browser

 */