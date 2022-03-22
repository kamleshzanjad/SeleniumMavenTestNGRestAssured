package _2gurubank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _2_Login {
    public WebDriver driver;
    @Test
    public void test() throws InterruptedException {
        System.out.println("Started test case");
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver");
        // Create driver object for CHROME browser, set implicit wait
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/V1/index.php");
        Thread.sleep(10000);

        // enter login credentials. These expires after every 20 days.
        driver.findElement(By.name("uid")).sendKeys("mngr391441");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tAbAzej");
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();


        Thread.sleep(10000);
        String getUrl= driver.getCurrentUrl();
        System.out.println("\nAfter Login, Url: '" + getUrl+"'");

        Thread.sleep(10000);
        driver.navigate().back();

        getUrl= driver.getCurrentUrl();
        System.out.println("After Navigating back, Url: " + getUrl + "'");

        System.out.println("Completed test case");

    }

}
