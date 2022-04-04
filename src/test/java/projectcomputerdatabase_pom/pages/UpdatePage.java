package projectcomputerdatabase_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UpdatePage {
    WebDriver driver=null;
    WebDriverWait wait = null;


    String loc_SaveComputerButton = "//input[@value='Save this computer']";

    public  UpdatePage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 10);
    }




    public void waitForSaveComputerButton() {
        WebElement element = driver.findElement(By.xpath(loc_SaveComputerButton));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public  void clickSaveComputerButton(){
        WebElement element = driver.findElement(By.xpath(loc_SaveComputerButton));
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
