package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class _1_RightClick {
    @Test
    public void RightClickOperation() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();


        // Launch the URL
        driver.get("https://demoqa.com/buttons");
        System.out.println("demoqa webpage displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform right click
        WebElement btnElement = driver.findElement(By.id("rightClickBtn"));

        //Right Click the button to display Context Menu&nbsp;
        actions.contextClick(btnElement).perform();
        Thread.sleep(5000);
        System.out.println("Right click Context Menu displayed");

        //Following code is to select item from context menu which gets open up on right click, this differs
        //depending upon your application specific test case:
        //Select and click 'Copy me' i.e. 2nd option in Context menu
        WebElement elementOpen = driver.findElement(By.xpath(".//div[@id='rightclickItem']/div[1]"));
        elementOpen.click();
        Thread.sleep(5000);

        // Accept the Alert
        driver.switchTo().alert().accept();
        System.out.println("Right click Alert Accepted");

        // Close the main window
        driver.close();
    }
}


/*
As the name suggests, when a user tries to click the Right mouse button on a website or a web element to look at its context menu.

E.g. This is a very common action used almost daily especially while working with Folders in Windows Explorer

Right Click in Selenium?

Let's see how to use Action class methods to right click:

First, instantiate an Actions class:

Actions actions = new Actions(driver);

Now as seen above, the contextClick() method has argument WebElement to be passed. So, need to pass a WebElement object to the method. This WebElement should be the button or any web element on which we want to perform Right click. To find the element use the below command:

WebElement webElement = driver.findElement(Any By strategy & locator);

Here, you can use any By strategy to locate the WebElement like find element by its id, name attribute, etc. To know more on all By strategies, please refer Find Elements tutorial.

Now, when we have got the action class object and the element as well, just invoke perform() method for the right-click:

actions.contextClick(webElement).perform();

Let's see what happens internally when invoke the perform() method above:

    Move to Element:  contextClick() method first performs mouseMove to the middle of the element location. This function performs the right click at the middle of the web element.
    Build: build() method is used to generate a composite action containing all actions. But if you observe, we have not invoked it in our above command. The build is executed in the perform method internally.
    Perform: perform() method performs the actions we have specified. But before that, it internally invokes build() method first. After the build, the action is performed.

 */