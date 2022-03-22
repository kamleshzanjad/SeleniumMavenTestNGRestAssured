package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class _7_ToolTip_MouseHover {
    @Test
    public void ToolTipOperition_UsingTitle() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        //CASE 2 : Using Actions class method
		driver.get("https://demoqa.com/tool-tips");

        System.out.println("demoqa webpage Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        org.openqa.selenium.interactions.Actions actions = new Actions(driver);

        //Retrieve WebElement
        WebElement element = driver.findElement(By.id("toolTipButton"));

        // Use action class to mouse hover
        actions.moveToElement(element).perform();
        Thread.sleep(5000);

//        WebElement toolTip = driver.findElement(By.cssSelector("#toolTipButton"));
//
//        // To get the tool tip text and assert
//        String toolTipText = toolTip.getText();
//        System.out.println("toolTipText-->"+toolTipText);
//
//        //Verification if tooltip text is matching expected value
//        if(toolTipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")){
//            System.out.println("Pass* : Tooltip matching expected value");
//        }else{
//            System.out.println("Fail : Tooltip NOT matching expected value");
//        }
        Thread.sleep(5000);
        // Close the main window
        driver.close();

    }
}


/*
Practice Exercise to retrieve ToolTip in Selenium

Find below the steps of the scenario to be automated:

    Open URL http://demoqa.com/tooltip/
    Identify web element Age textbox
    Retrieve 'title' attribute value of the web element
    Verify the text of 'title' attribute value matches with expected text
    Close the page

 */