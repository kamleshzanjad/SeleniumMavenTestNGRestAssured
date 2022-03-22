package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _8_SelectDropDown {
    @Test
    public void test() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");


        //Selecting the multi-select element by locating its id
        Select select = new Select(driver.findElement(By.id("cars")));

        //Get the list of all the options
        System.out.println("The dropdown options are -");
        Thread.sleep(5000);

        List<WebElement> options = select.getOptions();

        for(WebElement option: options)
            System.out.println(option.getText());
        Thread.sleep(5000);

        //Using isMultiple() method to verify if the element is multi-select, if yes go onto next steps else eit
        if(select.isMultiple()){

            //Selecting option as 'Opel'-- ByIndex
            System.out.println("Select option Opel by Index");
            select.selectByIndex(2);
            Thread.sleep(5000);

            //Selecting the option as 'Saab'-- ByValue
            System.out.println("Select option saab by Value");
            select.selectByValue("saab");
            Thread.sleep(5000);

            // Selecting the option by text
            System.out.println("Select option Audi by Text");
            select.selectByVisibleText("Audi");
            Thread.sleep(5000);

            //Get the list of selected options
            System.out.println("The selected values in the dropdown options are -");

            List<WebElement> selectedOptions = select.getAllSelectedOptions();

            for(WebElement selectedOption: selectedOptions)
                System.out.println(selectedOption.getText());
            Thread.sleep(5000);

            // Deselect the value "Audi" by Index
            System.out.println("DeSelect option Audi by Index");
            select.deselectByIndex(3);
            Thread.sleep(5000);

            //Deselect the value "Opel" by visible text
            System.out.println("Select option Opel by Text");
            select.deselectByVisibleText("Opel");
            Thread.sleep(5000);

            //Validate that both the values are deselected
            System.out.println("The selected values after deselect in the dropdown options are -");
            List<WebElement> selectedOptionsAfterDeselect = select.getAllSelectedOptions();

            for(WebElement selectedOptionAfterDeselect: selectedOptionsAfterDeselect)
                System.out.println(selectedOptionAfterDeselect.getText());
            Thread.sleep(5000);

            //Step#8- Deselect all values
            select.deselectAll();
            Thread.sleep(5000);
        }

        driver.quit();

    }
}




/*
The dropdown options are -
Volvo
Saab
Opel
Audi
Select option Opel by Index
Select option saab by Value
Select option Audi by Text
The selected values in the dropdown options are -
Saab
Opel
Audi
DeSelect option Audi by Index
Select option Opel by Text
The selected values after deselect in the dropdown options are -
Saab



The Select class in selenium can be used by importing the org.openqa.selenium.support.ui.Select package.
Moreover, the Select Class provides different methods to select values from dropdown/multi-select.
The Select Class also provides deselection methods to deselect certain values from a dropdown.
The multiple attributes can differentiate the multi-select elements provided bt the <select> tag.
The select and deselect methods can use an index, visible text, or values to select/deselect the values from a dropdown.
* */