package _2gurubank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _3_LoginRefactor {
    public WebDriver driver;
    // declaring variables
    String driverPath = "./src/main/resources/driver/chromedriver";

    // these credentials expires after 20 days. recreate credentials if below are not working  "https://demo.guru99.com/";  // 20 days access
    String url="https://demo.guru99.com/V1/index.php";
    String userId="mngr391441";
    String pwd="tAbAzej";

    String nameUserId="uid";
    String xPathPassord = "//input[@name='password']";
    String cssLoginButton = "input[name='btnLogin']";

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        System.out.println("before test. Started Test Case.");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(url);
        Thread.sleep(5000);
    }

    @Test
    public void test() throws InterruptedException {
        // enter login credentials.
        driver.findElement(By.name("uid")).sendKeys(userId);
        driver.findElement(By.xpath(xPathPassord)).sendKeys(pwd);
        driver.findElement(By.cssSelector(cssLoginButton)).click();

        Thread.sleep(5000);
        String getUrl= driver.getCurrentUrl();
        System.out.println("\nAfter Login, Url: '" + getUrl+"'");

        Thread.sleep(5000);
        driver.navigate().back();

        getUrl= driver.getCurrentUrl();
        System.out.println("After Navigating back, Url: " + getUrl + "'");

    }


    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("after test. Completed Test Case");
    }
}
