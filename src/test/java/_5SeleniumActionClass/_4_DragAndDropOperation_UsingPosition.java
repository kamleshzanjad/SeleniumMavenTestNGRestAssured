package _5SeleniumActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _4_DragAndDropOperation_UsingPosition {
    @Test
    public void DragAndDropOperationUsingPosition() throws InterruptedException {
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

        //Here, getting x and y offset to drop source object on target object location
        //First, get x and y offset for from object
        int xOffset1 = from.getLocation().getX();

        int yOffset1 =  from.getLocation().getY();

        System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);

        //Secondly, get x and y offset for to object
        int xOffset = to.getLocation().getX();

        int yOffset =  to.getLocation().getY();

        System.out.println("xOffset--->"+xOffset+" yOffset--->"+yOffset);

        //Find the xOffset and yOffset difference to find x and y offset needed in which from object required to dragged and dropped
        xOffset =(xOffset-xOffset1)+10;
        yOffset=(yOffset-yOffset1)+20;


        //Perform dragAndDropBy
        builder.dragAndDropBy(from, xOffset,yOffset).perform();
        Thread.sleep(5000);

        //verify text changed in to 'Drop here' box
        //Get text value of 'to' element
        String textTo = to.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped at location as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped at location as expected");
        }

        driver.close();

    }
}


/*
xOffset1--->665 yOffset1--->302
xOffset--->976 yOffset--->294
PASS: Source is dropped at location as expected


    dragAndDrop: Here, we saw how to use Drag and Drop Action in Selenium where we need to drag and drop the source element to target
    dragAndDropBy: Here, we saw how to drag and drop the source element in a horizontal and vertical direction by the specified offset


 */