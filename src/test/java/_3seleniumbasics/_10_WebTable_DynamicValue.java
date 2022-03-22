package _3seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*

    Launch new Browser
    Open URL “http://toolsqa.com/automation-practice-table/”
    Get the value from cell 'Dubai' and print it on the console
    Click on the link 'Detail' of the first row and last column

 */
public class _10_WebTable_DynamicValue {
    @Test
    public void test() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        String sRow = "3";
        String sCol = "2";
        String sCellValue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
        System.out.println("Value ins row 1 and column 2 is: "+ sCellValue);

        for (int i=2;i<=5;i++){
                for (int j=2;j<=3;j++){
                    System.out.print("Printing value from row: " + i + " and column: " +j +": ");
                    Thread.sleep(1000);
                    String sColumnValue= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td["+ j +"]")).getText();
                    System.out.println( sColumnValue);
                }
        }
        driver.close();
    }
}




/*
Value ins row 1 and column 2 is: Francisco Chang
Printing value from row: 2 and column: 2: Maria Anders
Printing value from row: 2 and column: 3: Germany
Printing value from row: 3 and column: 2: Francisco Chang
Printing value from row: 3 and column: 3: Mexico
Printing value from row: 4 and column: 2: Roland Mendel
Printing value from row: 4 and column: 3: Austria
Printing value from row: 5 and column: 2: Helen Bennett
Printing value from row: 5 and column: 3: UK



driver.get("https://toolsqa.com/automation-practice-table");

        String sRow = "1";
        String sCol = "2";

        //Here we are locating the xpath by passing variables in the xpath
        String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
        System.out.println(sCellValue);
        String sRowValue = "Clock Tower Hotel";

        //First loop will find the 'ClOCK TWER HOTEL' in the first column
        for (int i=1;i<=5;i++){
            String sValue = null;
            sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
            if(sValue.equalsIgnoreCase(sRowValue)){
                // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                for (int j=1;j<=5;j++){
                    String sColumnValue= driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
                    System.out.println(sColumnValue);
                }
                break;
            }
        }
 */