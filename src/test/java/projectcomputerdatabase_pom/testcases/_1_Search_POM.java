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

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

import projectcomputerdatabase_pom.pages.BasePage;
import projectcomputerdatabase_pom.pages.SearchPage;

public class _1_Search_POM {
    String driverExecutablePath = "./src/main/resources/driver/chromedriver";
    WebDriver driver = null;
    WebDriverWait wait = null;

    BasePage basePage=null;
    SearchPage searchPage=null;


    @BeforeTest
    public void setup() throws InterruptedException {
        basePage= new BasePage() ;
        this.driver = basePage.createDriver();
        wait = new WebDriverWait(this.driver, 10);
    }

    @Test
    public void SearchUsingIBM() throws InterruptedException {
        searchPage= new SearchPage(this.driver);
        searchPage.waitForSearchButton();
        searchPage.clearSearchTextBox();
        searchPage.enterTextInSearchTextBox("IBM");
        searchPage.clickSearchButton();
        basePage.staticWait(5000);
        searchPage.printComputerNameList();

    }

    @Test
    public void SearchUsingHP() throws InterruptedException {

        searchPage= new SearchPage(this.driver);
        searchPage.waitForSearchButton();
        searchPage.clearSearchTextBox();
        searchPage.enterTextInSearchTextBox("HP");
        searchPage.clickSearchButton();
        basePage.staticWait(5000);
        searchPage.printComputerNameList();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}



/*
        Element at index: 0 is: CrunchPad
Element at index: 1 is: HP 2133 Mini-Note PC
Element at index: 2 is: HP 9000
Element at index: 3 is: HP Integrity
Element at index: 4 is: HP MediaSmart Server
Element at index: 5 is: HP Mini 1000
Element at index: 6 is: HP Superdome
Element at index: 7 is: HP TouchPad
Element at index: 8 is: HP Veer
Element at index: 9 is: HP nPar


Element at index: 0 is: IBM 1401
Element at index: 1 is: IBM 305
Element at index: 2 is: IBM 3270
Element at index: 3 is: IBM 5100
Element at index: 4 is: IBM 650
Element at index: 5 is: IBM 701
Element at index: 6 is: IBM 7030
Element at index: 7 is: IBM 7090
Element at index: 8 is: IBM 801
Element at index: 9 is: IBM AP-101
 */