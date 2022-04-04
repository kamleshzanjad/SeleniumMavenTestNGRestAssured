package projectcomputerdatabase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _6_ChromeDriverHeadless {
    public String baseUrl = "https://www.javatpoint.com/";
    String driverPath = "./src/main/resources/driver/chromedriver";
    // "/Users/kzanjad/Documents/Software/chromedriver";

    //  "C://chromedriver_win321//chromedriver.exe";
    public WebDriver driver;

    @Test
    public void test() {

        // set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // get the current URL of the page
        String URL = driver.getCurrentUrl();
        System.out.println(URL);

        //get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("after test");
    }
}
