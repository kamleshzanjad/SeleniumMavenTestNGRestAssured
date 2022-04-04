package projectcomputerdatabase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _3_Create {
    String driverExecutablePath = "./src/main/resources/driver/chromedriver";
    WebDriver driver = null;
    WebDriverWait wait = null;

    String loc_AddNewComputer = "//a[text()='Add a new computer']";
    String loc_CreateNewComputerButton = "//input[@value='Create this computer']";
    String loc_AlertMessage_CSS = "div.alert-message.warning";  //

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://computer-database.gatling.io/computers");
        Thread.sleep(2000);
    }

    @Test
    public void createNewComputer() throws InterruptedException {

        WebElement element_AddNewComputer = driver.findElement(By.xpath(loc_AddNewComputer));

        wait.until(ExpectedConditions.elementToBeClickable(element_AddNewComputer));
        element_AddNewComputer.click();
        Thread.sleep(5000);

        WebElement element_CreateNewComputerButton = driver.findElement(By.xpath(loc_CreateNewComputerButton));

        wait.until(ExpectedConditions.elementToBeClickable(element_CreateNewComputerButton));

        driver.findElement(By.id("name")).sendKeys("Demo Computer Name 1");
        driver.findElement(By.id("introduced")).sendKeys("2000-10-10");
        driver.findElement(By.id("discontinued")).sendKeys("2012-12-12");
        Select select = new Select(driver.findElement(By.id("company")));
        select.selectByIndex(2);
        Thread.sleep(5000);

        element_CreateNewComputerButton.click();

        WebElement element_AlertMessage = driver.findElement(By.cssSelector(loc_AlertMessage_CSS));
        wait.until(ExpectedConditions.elementToBeClickable(element_AlertMessage));

        String actualAlertMessage = element_AlertMessage.getText();
        String expectedAlertMessage = "Done ! Computer Demo Computer Name 1 has been created";

        System.out.println("Expected Alert Message: " + expectedAlertMessage);
        System.out.println("Actual Alert Message: " + actualAlertMessage);
        Thread.sleep(5000);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}



/*
        Expected Alert Message: Done ! Computer Demo Computer Name 1 has been created
        Actual Alert Message: Done ! Computer Demo Computer Name 1 has been created
 */