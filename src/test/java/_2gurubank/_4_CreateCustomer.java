package _2gurubank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _4_CreateCustomer {
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
    String xpathBankName="//h2[@class='barone' and text()='Gtpl Bank' ] ";

    String xPathNewCustomer="//a[text()='New Customer' ]  ";

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        System.out.println("before test. Started Test Case.");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        // enter login credentials.

        // explicit wait condition wait till Login button is present
        WebDriverWait w = new WebDriverWait(driver,5);
        // presenceOfElementLocated condition
        w.until(ExpectedConditions.presenceOfElementLocated (By.cssSelector(cssLoginButton)));

        driver.findElement(By.name("uid")).sendKeys(userId);
        driver.findElement(By.xpath(xPathPassord)).sendKeys(pwd);
        driver.findElement(By.cssSelector(cssLoginButton)).click();
        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath(xpathBankName)));

    }

    @Test
    public void test() throws InterruptedException {

        driver.findElement(By.xpath(xPathNewCustomer)).click();

        driver.findElement(By.name("name")).sendKeys("FirstName");

        //select Radio Option female
        driver.findElement(By.xpath("(//input[@name='rad1'])[2]")).click();

        // select date
        driver.findElement(By.id("dob")).sendKeys("12121990");

        driver.findElement(By.name("addr")).sendKeys("Address 1");
        driver.findElement(By.name("city")).sendKeys("CityName");
        driver.findElement(By.name("state")).sendKeys("StateName");
        driver.findElement(By.name("pinno")).sendKeys("123456");
        driver.findElement(By.name("telephoneno")).sendKeys("9123456789");
        driver.findElement(By.name("emailid")).sendKeys("FirstName@gmail.com");


         Thread.sleep(5000);
        driver.findElement(By.name("sub")).click();

        Thread.sleep(5000);



    }


    @AfterTest
    public void afterTest() {
        driver.quit();
        System.out.println("after test. Completed Test Case");
    }
}
