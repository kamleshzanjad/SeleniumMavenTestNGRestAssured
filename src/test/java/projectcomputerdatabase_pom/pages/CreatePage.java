package projectcomputerdatabase_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreatePage {
    WebDriver driver=null;
    WebDriverWait wait = null;

    String loc_AddNewComputer = "//a[text()='Add a new computer']";
    String loc_CreateNewComputerButton = "//input[@value='Create this computer']";
    String loc_AlertMessage_CSS = "div.alert-message.warning";  //

    public  CreatePage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 10);
    }


    public void waitForAddNewComputerButton() {
        WebElement element = driver.findElement(By.xpath(loc_AddNewComputer));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public  void clickAddNewComputerButton(){
        WebElement element = driver.findElement(By.xpath(loc_AddNewComputer));
        element.click();
    }

    public void waitForCreateNewComputerButton() {
        WebElement element = driver.findElement(By.xpath(loc_CreateNewComputerButton));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public  void clickCreateComputerButton(){
        WebElement element = driver.findElement(By.xpath(loc_CreateNewComputerButton));
        element.click();
    }


    public void enterComputerName(String value){
        driver.findElement(By.id("name")).sendKeys(value);
    }
    public void enterIntroducedDate(String value){
        driver.findElement(By.id("introduced")).sendKeys(value);
    }
    public void enterDiscontinuedDate(String value){
        driver.findElement(By.id("discontinued")).sendKeys(value);
    }
    public void selectCompany(int index){
        Select select = new Select(driver.findElement(By.id("company")));
        select.selectByIndex(index);
    }




}
