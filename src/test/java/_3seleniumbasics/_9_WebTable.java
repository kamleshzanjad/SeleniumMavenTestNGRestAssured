package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*

    Launch new Browser
    Open URL “http://toolsqa.com/automation-practice-table/”
    Get the value from cell 'Dubai' and print it on the console
    Click on the link 'Detail' of the first row and last column

 */
public class _9_WebTable {
    @Test
    public void test() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        String sCellValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[2]/table/tbody/tr[4]/td[2]")).getText();
        System.out.println(sCellValue);
        Thread.sleep(5000);

        sCellValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[2]/table/tbody/tr[3]/td[1]")).getText();
        System.out.println(sCellValue);
        Thread.sleep(5000);

    }
}



/*
//  driver.get("https://toolsqa.com/automation-practice-table");
        //Here we are storing the value from the cell in to the string variable
//        String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
//        System.out.println(sCellValue);
//        Thread.sleep(5000);
//
//        // Here we are clicking on the link of first row and the last column
//        driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();
//        System.out.println("Link has been clicked otherwise an exception would have thrown");
//        Thread.sleep(5000);
//        driver.close();
 */

