package projectcomputerdatabase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _7_ChromeDriverOptions {
    public String baseUrl = "https://www.javatpoint.com/";
    String driverPath = "./src/main/resources/driver/chromedriver";
    // "/Users/kzanjad/Documents/Software/chromedriver";

    //  "C://chromedriver_win321//chromedriver.exe";
    public WebDriver driver;

    @Test
    public void test() {

        // set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.setExperimentalOption("useAutomationExtension", false);

        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1580,1280");

        final HashMap<String, Object> prefs = new HashMap();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(chromeOptions);

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
