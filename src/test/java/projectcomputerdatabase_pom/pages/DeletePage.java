package projectcomputerdatabase_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DeletePage {
    WebDriver driver=null;
    WebDriverWait wait = null;
    String loc_DeleteComputerButton = "//input[@value='Delete this computer']";

    public  DeletePage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, 10);
    }



    public void waitForDeleteButton() {
        WebElement element_SearchButton = driver.findElement(By.xpath(loc_DeleteComputerButton));
        wait.until(ExpectedConditions.elementToBeClickable(element_SearchButton));
    }
    public void clickDeleteComputerButton(){
        driver.findElement(By.xpath(loc_DeleteComputerButton)).click();
    }

}
