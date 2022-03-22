package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class _5_FindElements {
    @Test
    public void test() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box/");

        //The command findElements() returns a list of web elements that match the specified criteria, unlike findElement() which returned a unique element.
        // If there are no matching elements then an empty list returns.
        // Find elements using tag name
        List<WebElement> allInputElements = driver.findElements(By.tagName("input"));

        if(allInputElements.size() != 0)
        {
            System.out.println(allInputElements.size() + " Elements found by TagName as input \n");

            for(WebElement inputElement : allInputElements)
            {
                System.out.println(inputElement.getAttribute("placeholder"));
            }
        }
    }
}




/*
2 Elements found by TagName as input

Full Name
name@example.com
 */