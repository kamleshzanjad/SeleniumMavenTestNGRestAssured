package projectcomputerdatabase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _4_Update {
    String driverExecutablePath = "./src/main/resources/driver/chromedriver";
    WebDriver driver = null;
    WebDriverWait wait = null;

    String loc_SearchBox_css = "input#searchbox";
    String loc_SearchButton_css = "input#searchsubmit";
    String loc_ComputerName = "//table[@class='computers zebra-striped']/tbody/tr[1]/td[1]/a";
    String loc_SaveComputerButton = "//input[@value='Save this computer']";
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
    public void updateComputer() throws InterruptedException {

        WebElement element_SearchButton = driver.findElement(By.cssSelector(loc_SearchButton_css));
        wait.until(ExpectedConditions.elementToBeClickable(element_SearchButton));
        driver.findElement(By.cssSelector(loc_SearchBox_css)).clear();

        driver.findElement(By.cssSelector(loc_SearchBox_css)).sendKeys("ARRA");
        element_SearchButton.click();
        Thread.sleep(5000);

        WebElement element_FirstSearchResult = driver.findElement(By.xpath(loc_ComputerName));
        wait.until(ExpectedConditions.elementToBeClickable(element_FirstSearchResult));
        element_FirstSearchResult.click();
        Thread.sleep(10000);


        WebElement element_SaveComputerButton = driver.findElement(By.xpath(loc_SaveComputerButton));

        wait.until(ExpectedConditions.elementToBeClickable(element_SaveComputerButton));

        driver.findElement(By.id("name")).sendKeys(" Updated");
        driver.findElement(By.id("introduced")).sendKeys("2000-10-10");
        driver.findElement(By.id("discontinued")).sendKeys("2012-12-12");
        Select select = new Select(driver.findElement(By.id("company")));
        select.selectByIndex(5);
        Thread.sleep(5000);

        element_SaveComputerButton.click();

        WebElement element_AlertMessage = driver.findElement(By.cssSelector(loc_AlertMessage_CSS));
        wait.until(ExpectedConditions.elementToBeClickable(element_AlertMessage));

        String actualAlertMessage = element_AlertMessage.getText();
        String expectedAlertMessage = "Done ! Computer ARRA Updated has been updated";

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
        Expected Alert Message: Done ! Computer ARRA Updated has been updated
        Actual Alert Message: Done ! Computer ARRA Updated has been updated
 */