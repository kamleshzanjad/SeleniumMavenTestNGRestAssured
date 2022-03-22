package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _3_DragAndDropOperation {
    @Test
    public void DragAndDropOperation() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        String URL = "https://demoqa.com/droppable/";

        driver.get(URL);

        // It is always advisable to Maximize the window before performing DragNDrop action
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));
        //Perform drag and drop
        builder.dragAndDrop(from, to).perform();
        Thread.sleep(5000);

        //verify text changed in to 'Drop here' box
        String textTo = to.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        driver.close();
    }
}


/*
This is an action performed with a mouse when a user moves (drags) a web element and then places (drops) it into an alternate area.

E.g. This is a very common action used in Windows Explorer while moving any file from one folder to another.
Here, the user selects any file in the folder, drags it to the desired folder and just drops it.

In Gmail, a file can be just dragged and dropped in new mail to send as an attachment

There are the methods Actions class provides for Drag-Drop action:

    dragAndDrop(WebElementsource, WebElement target)
    dragAndDropBy(WebElementsource, int xOffset, int yOffset)

Let’s see what happens internally when invoke the perform() method above:

    Click And Hold Action: dragAndDrop() method first performs click-and-hold at the location of the source element
    Move Mouse Action: Then source element gets moved to the location of the target element
    Button Release Action: Finally, it releases the mouse
    Build: build() method is used to generate a composite action containing all actions. But if you observe, we have not invoked it in our above command. The build is executed in the perform method internally
    Perform: perform() method performs the actions we have specified. But before that, it internally invokes build() method first. After the build, the action is performed


 */