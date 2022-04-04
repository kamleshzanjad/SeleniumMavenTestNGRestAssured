package projectcomputerdatabase_pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage {
    WebDriver driver =null;
    WebDriverWait wait = null;
    String driverExecutablePath = "./src/main/resources/driver/chromedriver";


    public WebDriver createDriver() throws InterruptedException {
       // this.driver = driver;
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://computer-database.gatling.io/computers");
        Thread.sleep(5000);
        return this.driver;
    }

    public void staticWait(int timeInMilliseconds) throws InterruptedException {
        Thread.sleep(timeInMilliseconds);
    }
}
