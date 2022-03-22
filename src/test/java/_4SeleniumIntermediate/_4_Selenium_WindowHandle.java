package _4SeleniumIntermediate;

//import java.time.Duration;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class _4_Selenium_WindowHandle {
    @Test
    public void TestWindowHandle() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        String mainwindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + mainwindow);

        // Opening all the child window
        driver.findElement(By.id("windowButton")).click();


        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }

        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainwindow);
        driver.quit();
    }
}


/*
Exercise
    Launch the website "https://demoqa.com/browser-windows" and click on the windows - "windowbutton".
    String mainwindow = driver.getWindowHandle(): It stores parent window value in a unique identifier of string type.
    Set<String> s = driver.getWindowHandles(): All child windows are stored in a set of strings.
    Iterator<String> i = s.iterator() : Here we will iterate through all child windows.
    if (!MainWindow.equalsIgnoreCase(ChildWindow)) : Now check them by comparing the main window with the child windows.
    driver.switchTo().window (ChildWindow): Switch to the child window and read the heading.
    WebElement text = driver.findElement(By.id("sampleHeading")): Find the element and store in a web element through which we will get the text of heading using gettext() method.


    A window is a webpage that will open when a user hits a URL. There are two types of windows in the Selenium - parent window and its child windows.
    The window handle is a unique identifier that stores the values of windows opened on a webpage and helps in window handling in Selenium.
    getWindowHandles( ) and getWindowHandles( ) handle windows in Selenium.
    The user has to switch from the parent window to the child window to work on them using switchTo( ) method.
    To close windows two methods exist driver.close( ) and driver.quit( ).
    https://toolsqa.com/selenium-webdriver/window-handle-in-selenium/

 */