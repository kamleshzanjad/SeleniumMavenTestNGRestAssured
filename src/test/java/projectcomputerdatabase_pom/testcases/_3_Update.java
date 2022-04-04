package projectcomputerdatabase_pom.testcases;

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
import projectcomputerdatabase_pom.pages.CreatePage;
import projectcomputerdatabase_pom.pages.SearchPage;
import projectcomputerdatabase_pom.pages.UpdatePage;

import static java.util.concurrent.TimeUnit.SECONDS;

public class _3_Update {
    String driverExecutablePath = "./src/main/resources/driver/chromedriver";
    WebDriver driver = null;
    WebDriverWait wait = null;

    BasePage basePage=null;
    SearchPage searchPage=null;
    UpdatePage updatePage =null;


    @BeforeTest
    public void setup() throws InterruptedException {
        basePage= new BasePage() ;
        this.driver = basePage.createDriver();
        wait = new WebDriverWait(this.driver, 10);
    }

    @Test
    public void updateComputer() throws InterruptedException {
        searchPage= new SearchPage(this.driver);
        updatePage= new UpdatePage(this.driver);

        searchPage.waitForSearchButton();
        searchPage.clearSearchTextBox();
        searchPage.enterTextInSearchTextBox("ARRA");
        searchPage.clickSearchButton();
        basePage.staticWait(5000);
        searchPage.waitForComputerSearch();
        searchPage.clickFirstComputerName();

        updatePage.waitForSaveComputerButton();
        updatePage.enterComputerName(" Update");
        updatePage.enterIntroducedDate("2000-10-10");
        updatePage.enterDiscontinuedDate("2012-12-12");
        updatePage.selectCompany(6);
        basePage.staticWait(5000);
        updatePage.clickSaveComputerButton();

        searchPage.waitForAlertMessage();
        String actualAlertMessage = searchPage.getAlertMessage();
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
Actual Alert Message: Done ! Computer ARRA Update has been updated
 */