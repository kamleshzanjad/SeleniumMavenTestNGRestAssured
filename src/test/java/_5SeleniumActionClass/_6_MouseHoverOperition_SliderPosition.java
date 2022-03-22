package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class _6_MouseHoverOperition_SliderPosition {
    @Test
    public void MouseHoverOperition() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        // CASE 2 : Using Actions class method
		driver.get("https://demoqa.com/tool-tips");

        System.out.println("demoqa webpage Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement
        WebElement element = driver.findElement(By.id("tooltipDemo"));

        // Use action class to mouse hover
        actions.moveToElement(element).perform();

        WebElement toolTip = driver.findElement(By.cssSelector(".tooltiptext"));

        // To get the tool tip text and assert
        String toolTipText = toolTip.getText();
        System.out.println("toolTipText-->"+toolTipText);

        //Verification if tooltip text is matching expected value
        if(toolTipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")){
            System.out.println("Pass* : Tooltip matching expected value");
        }else{
            System.out.println("Fail : Tooltip NOT matching expected value");
        }

        // Close the main window
        driver.close();

    }
}


/*
 */