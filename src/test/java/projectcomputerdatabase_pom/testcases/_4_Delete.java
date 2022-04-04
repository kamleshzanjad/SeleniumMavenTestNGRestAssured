package projectcomputerdatabase_pom.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import projectcomputerdatabase_pom.pages.BasePage;
import projectcomputerdatabase_pom.pages.CreatePage;
import projectcomputerdatabase_pom.pages.SearchPage;
import projectcomputerdatabase_pom.pages.DeletePage;


import static java.util.concurrent.TimeUnit.SECONDS;

public class _4_Delete {
    String driverExecutablePath = "./src/main/resources/driver/chromedriver";
    WebDriver driver = null;
    WebDriverWait wait = null;


    BasePage basePage=null;
    SearchPage searchPage=null;
DeletePage deletePage=null;

    @BeforeTest
    public void setup() throws InterruptedException {
        basePage= new BasePage() ;
        this.driver = basePage.createDriver();
        wait = new WebDriverWait(this.driver, 10);
    }

    @Test
    public void deleteComputer() throws InterruptedException {
        searchPage= new SearchPage(this.driver);
        deletePage= new DeletePage(this.driver);
        searchPage.waitForSearchButton();
        searchPage.clearSearchTextBox();
        searchPage.enterTextInSearchTextBox("ARRA");
        searchPage.clickSearchButton();
        basePage.staticWait(5000);
        searchPage.waitForComputerSearch();
        searchPage.clickFirstComputerName();
        deletePage.waitForDeleteButton();
        deletePage.clickDeleteComputerButton();

        searchPage.waitForAlertMessage();
        String actualAlertMessage = searchPage.getAlertMessage();
        String expectedAlertMessage = "Done ! Computer ARRA has been deleted";

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
        Expected Alert Message: Done ! Computer ARRA has been deleted
Actual Alert Message: Done ! Computer ARRA has been deleted
 */