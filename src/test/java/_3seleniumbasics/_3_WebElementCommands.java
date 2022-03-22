package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _3_WebElementCommands {
    @Test
    public void test() {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        String appUrl = "https://demoqa.com/";
        driver.get(appUrl);

        // <img class="banner-image" src="/images/WB.svg" alt="Selenium Online Training">

        String loc="//img[@class='banner-image']";
        WebElement element = driver.findElement(By.xpath(loc));

        System.out.println("Print TagName: "+ element.getTagName());
        System.out.println("Print classname: "+ element.getClass());
        System.out.println("Print attribute src: "+ element.getAttribute("src"));  //alt
        System.out.println("Print size: "+ element.getSize());
        System.out.println("Print location: "+ element.getLocation());
        System.out.println("Print getCssValue: "+  element.getCssValue("color"));   //background-color
        System.out.println("Print getREct: "+  element.getRect());

         /*
        Dimension dimensions = element.getSize();
        System.out.println(“Height :” + dimensions.height + ”Width : "+ dimensions.width);
        Point point = element.getLocation();
        System.out.println("X cordinate : " + point.x + "Y cordinate: " + point.y);
         */
        driver.close();
    }
}




/*
Print TagName: img
Print classname: class org.openqa.selenium.remote.RemoteWebElement
Print attribute src: https://demoqa.com/images/WB.svg
Print size: (819, 320)
Print location: (190, 100)
Print getCssValue: rgba(0, 123, 255, 1)
Print getREct: org.openqa.selenium.Rectangle@3b1e7

 */