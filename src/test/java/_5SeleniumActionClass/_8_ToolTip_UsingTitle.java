package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _8_ToolTip_UsingTitle {
    @Test
    public void ToolTipOperition_UsingTitle() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        // Launch the URL
         driver.get("https://demoqa.com/tool-tips/");
        System.out.println("Tooltip web Page Displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        // Get element for which we need to find tooltip
        // <button id="toolTipButton" type="button" class="btn btn-success">Hover me to see</button>
        WebElement ageTextBox = driver.findElement(By.id("toolTipButton"));

        //Get title attribute value
        String tooltipText = ageTextBox.getAttribute("title");

        System.out.println("Retrieved tooltip text as :"+tooltipText);

        //Verification if tooltip text is matching expected value
        if(tooltipText.equalsIgnoreCase("We ask for your age only for statistical purposes.")){
            System.out.println("Pass : Tooltip matching expected value");
        }
        else{
            System.out.println("Fail : Tooltip NOT matching expected value");
        }

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