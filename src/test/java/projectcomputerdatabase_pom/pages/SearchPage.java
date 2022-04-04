package projectcomputerdatabase_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    String loc_SearchBox_css = "input#searchbox";
    String loc_SearchButton_css = "input#searchsubmit";
    String loc_ComputerNames = "//table[@class='computers zebra-striped']/tbody/tr/td[1]";

    String loc_AlertMessage_CSS = "div.alert-message.warning";  //
    String loc_ComputerName = "//table[@class='computers zebra-striped']/tbody/tr[1]/td[1]/a";

    WebDriver driver=null;
    WebDriverWait wait = null;

    public  SearchPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 10);
    }



    public void waitForSearchButton() {
        WebElement element_SearchButton = driver.findElement(By.cssSelector(loc_SearchButton_css));
        wait.until(ExpectedConditions.elementToBeClickable(element_SearchButton));
    }
    public void clearSearchTextBox(){
        driver.findElement(By.cssSelector(loc_SearchBox_css)).clear();
    }

    public void enterTextInSearchTextBox(String value){
        driver.findElement(By.cssSelector(loc_SearchBox_css)).sendKeys(value);
    }

    public  void clickSearchButton(){
        driver.findElement(By.cssSelector(loc_SearchButton_css)).click();
    }


    public void printComputerNameList(){
        List<WebElement> lst = driver.findElements(By.xpath(loc_ComputerNames));
        for (int i = 0; i < lst.size(); i++) {
            System.out.println("Element at index: " + i + " is: " + lst.get(i).getText());
        }
    }


    public void waitForAlertMessage() {
        WebElement element = driver.findElement(By.cssSelector(loc_AlertMessage_CSS));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getAlertMessage(){
        return  driver.findElement(By.cssSelector(loc_AlertMessage_CSS)).getText();
    }


    public void waitForComputerSearch() {
        WebElement element = driver.findElement(By.xpath(loc_ComputerName));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public  void clickFirstComputerName(){
        WebElement element = driver.findElement(By.xpath(loc_ComputerName));
        element.click();
    }




}
