package projectcomputerdatabase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _1_Search {
    @Test
    public void test() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
        driver.manage().timeouts().implicitlyWait(20, SECONDS);

        driver.get("https://computer-database.gatling.io/computers");
        Thread.sleep(5000);

        String loc_SearchBox_css = "input#searchbox";
        String loc_SearchButton_css = "input#searchsubmit";

        WebElement element_SearchButton = driver.findElement(By.cssSelector(loc_SearchButton_css));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element_SearchButton));

        driver.findElement(By.cssSelector(loc_SearchBox_css)).sendKeys("ACE");
        element_SearchButton.click();
        Thread.sleep(5000);

        String loc_ComputerNames = "//table[@class='computers zebra-striped']/tbody/tr/td[1]";

        List<WebElement> lst = driver.findElements(By.xpath(loc_ComputerNames));

        for (int i = 0; i < lst.size(); i++) {
            System.out.println("Element at index: " + i + " is: " + lst.get(i).getText());
        }


        driver.quit();

    }
}