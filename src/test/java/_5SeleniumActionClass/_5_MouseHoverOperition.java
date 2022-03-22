package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _5_MouseHoverOperition {
    @Test
    public void MouseHoverOperition() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/menu/");
        System.out.println("demoqa webpage Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Adding wait
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement menuOption = driver.findElement(By.xpath(".//a[contains(text(),'Main Item 2')]"));  //Music

        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();
        System.out.println("Done Mouse hover on 'Main Item 2' from Menu");
        Thread.sleep(5000);

        //Now Select 'Rock' from sub menu which has got displayed on mouse hover of 'Music'
        WebElement subMenuOption = driver.findElement(By.xpath(".//a[contains(text(),'SUB SUB LIST »')]"));
        //Mouse hover menuOption 'Rock'
        actions.moveToElement(subMenuOption).perform();
        System.out.println("Done Mouse hover on 'SUB SUB LIST »' from Menu");
        Thread.sleep(5000);

        //Now , finally, it displays the desired menu list from which required option needs to be selected
        //Now Select 'Alternative' from sub menu which has got displayed on mouse hover of 'Rock'
        WebElement selectMenuOption = driver.findElement(By.xpath(".//a[contains(text(),'SUB SUB LIST »')]"));
        selectMenuOption.click();
        System.out.println("Selected 'SUB SUB LIST »' from Menu");

        // Close the main window
        driver.close();

    }
}


/*
A mouse hover is also called as hover. M
ouse hover action is basically an action where a user places a mouse over a designated area like a hyperlink.
It can cause some event to get triggered.

For Example, moving the mouse over an element on web page displays some pop-up windows or maybe description boxes.
In  website https://www.toolsqa.com,
if you mouse hover TUTORIAL tab, you will see Menu list of different topics gets displayed as below:

here are the methods Actions class has provided for Mouse Hover action:

    moveToElement(WebElement target)
    moveToElement(WebElement target, int xOffset, int yOffset)

 */