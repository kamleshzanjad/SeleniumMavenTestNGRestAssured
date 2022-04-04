package projectcomputerdatabase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _2_Search_Hooks {
    String driverExecutablePath = "./src/main/resources/driver/chromedriver";
    WebDriver driver = null;
    WebDriverWait wait = null;

    String loc_SearchBox_css = "input#searchbox";
    String loc_SearchButton_css = "input#searchsubmit";
    String loc_ComputerNames = "//table[@class='computers zebra-striped']/tbody/tr/td[1]";

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://computer-database.gatling.io/computers");
        Thread.sleep(5000);
    }

    @Test
    public void SearchUsingIBM() throws InterruptedException {
        WebElement element_SearchButton = driver.findElement(By.cssSelector(loc_SearchButton_css));

        wait.until(ExpectedConditions.elementToBeClickable(element_SearchButton));

        // importance of clearing text box to avoid error else it will search for IBMHP in second testcase
        driver.findElement(By.cssSelector(loc_SearchBox_css)).clear();

        driver.findElement(By.cssSelector(loc_SearchBox_css)).sendKeys("IBM");
        element_SearchButton.click();
        Thread.sleep(5000);

        List<WebElement> lst = driver.findElements(By.xpath(loc_ComputerNames));
        for (int i = 0; i < lst.size(); i++) {
            System.out.println("Element at index: " + i + " is: " + lst.get(i).getText());
        }
    }

    @Test
    public void SearchUsingHP() throws InterruptedException {
        WebElement element_SearchButton = driver.findElement(By.cssSelector(loc_SearchButton_css));

        wait.until(ExpectedConditions.elementToBeClickable(element_SearchButton));

        driver.findElement(By.cssSelector(loc_SearchBox_css)).clear();

        driver.findElement(By.cssSelector(loc_SearchBox_css)).sendKeys("HP");
        element_SearchButton.click();
        Thread.sleep(5000);

        List<WebElement> lst = driver.findElements(By.xpath(loc_ComputerNames));
        for (int i = 0; i < lst.size(); i++) {
            System.out.println("Element at index: " + i + " is: " + lst.get(i).getText());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

/*
execution order is aplhabeticalling First HP is search and then IBM search.

 */

/*
        Element at index: 0 is: IBM 1401
        Element at index: 1 is: IBM 305
        Element at index: 2 is: IBM 3270
        Element at index: 3 is: IBM 5100
        Element at index: 4 is: IBM 650
        Element at index: 5 is: IBM 701
        Element at index: 6 is: IBM 7030
        Element at index: 7 is: IBM 7090
        Element at index: 8 is: IBM 801
        Element at index: 9 is: IBM AP-101
 */