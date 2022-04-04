package projectcomputerdatabase_pom.testcases;

//import com.sun.xml.internal.rngom.parse.host.Base;
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
import projectcomputerdatabase_pom.pages.BasePage;
import projectcomputerdatabase_pom.pages.SearchPage;
import projectcomputerdatabase_pom.pages.CreatePage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _2_Create {
    String driverExecutablePath = "./src/main/resources/driver/chromedriver";
    WebDriver driver = null;
    WebDriverWait wait = null;


    BasePage basePage=null;
    SearchPage searchPage=null;
    CreatePage createPage =null;


    @BeforeTest
    public void setup() throws InterruptedException {
        basePage= new BasePage() ;
        this.driver = basePage.createDriver();
        wait = new WebDriverWait(this.driver, 10);
    }

    @Test
    public void createNewComputer() throws InterruptedException {
        searchPage= new SearchPage(this.driver);
        createPage= new CreatePage(this.driver);
        createPage.waitForAddNewComputerButton();
        createPage.clickAddNewComputerButton();
        basePage.staticWait(5000);

        createPage.waitForCreateNewComputerButton();
        createPage.enterComputerName("Demo Computer Name 1");
        createPage.enterIntroducedDate("2001-10-10");
        createPage.enterDiscontinuedDate("2012-12-12");
        createPage.selectCompany(4);
        basePage.staticWait(5000);
        createPage.clickCreateComputerButton();

        searchPage.waitForAlertMessage();


        String actualAlertMessage = searchPage.getAlertMessage();
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