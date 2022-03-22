package _4SeleniumIntermediate;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class _5_Selenium_FrameHandle {
    @Test
    public void TestFrameHandle() throws InterruptedException {
        String driverExecutablePath = "./src/main/resources/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");

        //By finding all ifrmae By executing a java script
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        //By finding all the web elements using iframe tag
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());
        System.out.println("The iframes are " + iframeElements);


        //now use the switch command switch by index
        driver.switchTo().frame(0);
        driver.switchTo().defaultContent();

        //Switch by frame  id    <iframe src="/sample" id="frame1" width="500px" height="350px"></iframe>
        driver.switchTo().frame("frame1");
        driver.switchTo().defaultContent();

        //Switch by frame ID  <iframe id="aswift_0" name="aswift_0" style="left:0;position:absolute;top:0;border:0;width:undefinedpx;height:undefinedpx" sandbox="allow-forms allow-popups allow-popups-to-escape-sandbox allow-same-origin allow-scripts allow-top-navigation-by-user-activation" frameborder="0" marginwidth="0" marginheight="0" vspace="0" hspace="0" allowtransparency="true" scrolling="no" src="https://googleads.g.doubleclick.net/pagead/ads?client=ca-pub-5889298451609146&amp;output=html&amp;adk=1812271804&amp;adf=3025194257&amp;lmt=1647775485&amp;plat=1%3A16777216%2C9%3A32776%2C16%3A8388608%2C17%3A32%2C24%3A32%2C25%3A32%2C30%3A1081344%2C32%3A32&amp;format=0x0&amp;url=https%3A%2F%2Fdemoqa.com%2Fframes&amp;ea=0&amp;pra=5&amp;wgl=1&amp;uach=WyJtYWNPUyIsIjExLjYuNCIsIng4NiIsIiIsIjk5LjAuNDg0NC44MyIsW10sbnVsbCxudWxsLCI2NCIsW1siIE5vdCBBO0JyYW5kIiwiOTkuMC4wLjAiXSxbIkNocm9taXVtIiwiOTkuMC40ODQ0LjgzIl0sWyJHb29nbGUgQ2hyb21lIiwiOTkuMC40ODQ0LjgzIl1dLGZhbHNlXQ..&amp;dt=1647938288037&amp;bpp=2&amp;bdt=13714&amp;idt=1211&amp;shv=r20220317&amp;mjsv=m202203160101&amp;ptt=9&amp;saldr=aa&amp;abxe=1&amp;cookie=ID%3D3917e028b13322b1-222aea38f6d1006e%3AT%3D1647938287%3AS%3DALNI_MY6UH44_6qPKu8MxKGnXsO-bZUKfw&amp;nras=1&amp;correlator=2881858747466&amp;frm=20&amp;pv=2&amp;ga_vid=471353173.1647938287&amp;ga_sid=1647938287&amp;ga_hid=2020784803&amp;ga_fc=1&amp;u_tz=330&amp;u_his=2&amp;u_h=1120&amp;u_w=1792&amp;u_ah=1024&amp;u_aw=1792&amp;u_cd=30&amp;u_sd=2&amp;dmc=8&amp;adx=-12245933&amp;ady=-12245933&amp;biw=1792&amp;bih=900&amp;scr_x=0&amp;scr_y=0&amp;eid=44759876%2C44759927%2C44759842&amp;oid=2&amp;pvsid=3336722859899349&amp;pem=365&amp;tmod=1917257886&amp;uas=0&amp;nvt=1&amp;eae=2&amp;fc=1920&amp;brdim=0%2C25%2C0%2C25%2C1792%2C25%2C1792%2C1024%2C1792%2C900&amp;vis=1&amp;rsz=%7C%7Cs%7C&amp;abl=NS&amp;fu=32768&amp;bc=31&amp;ifi=2&amp;uci=a!2&amp;fsb=1&amp;dtd=1228" data-google-container-id="a!2" data-load-complete="true"></iframe>
        driver.switchTo().frame("aswift_0");

        //Do all the required tasks in the frame 0
        //Switch back to the main window
        driver.switchTo().defaultContent();
        driver.quit();

    }
}


/*
Exercise
 iFrame is a HTML document embedded inside an HTML document. iFrame is defined by an <iframe></iframe> tag in HTML.
  With this tag, you can identify an iFrame while inspecting the HTML tree.
    switchTo.frame(int frameNumber): Pass the frame index and driver will switch to that frame.
    switchTo.frame(string frameNameOrId): Pass the frame element Name or ID and driver will switch to that frame.
    switchTo.frame(WebElement frameElement): Pass the frame web element and driver will switch to that frame.
    Switch back to the main window  switchTo().defaultContent();

 */