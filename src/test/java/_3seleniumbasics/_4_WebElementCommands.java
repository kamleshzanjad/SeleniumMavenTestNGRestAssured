package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class _4_WebElementCommands {
    @Test
    public void test() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/V1/index.php");

        WebElement element = driver.findElement(By.name("uid"));
        boolean statusIsDisplayed = element.isDisplayed();
        boolean statusIsEnabled = element.isEnabled();
        boolean statusIsSelected = element.isSelected();

        System.out.println("statusIsDisplayed "  + statusIsDisplayed);
        System.out.println("statusIsEnabled "  + statusIsEnabled) ;
        System.out.println("statusIsSelected "  + statusIsSelected);


        driver.findElement(By.name("uid")).sendKeys("mngr391441");
        Thread.sleep(5000);
        driver.findElement(By.name("uid")).clear();
        Thread.sleep(5000);

        driver.findElement(By.name("uid")).sendKeys("mngr391441");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tAbAzej");
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
        driver.close();
    }
}




/*
statusIsDisplayed true
statusIsEnabled true
statusIsSelected false

 */