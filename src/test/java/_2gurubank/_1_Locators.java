package _2gurubank;

/*
Locator is a command that tells Selenium IDE which GUI elements ( say Text Box, Buttons, Check Boxes etc) its needs to operate on.
    Locating Strategies By ID
    Locating Strategies By Name
    Locating Strategies By Class Name
    Locating Strategies By Tag Name
    Locating Strategies By Link Text
    Locating Strategies By Partial Link Text
    Locating Strategies By CSS
    Locating Strategies By XPath

    Open url https://demo.guru99.com/V1/index.php
    Put cursor on UserID, Right Click, click Inspect
    Select Network tab

    verify HTML dom with locators
    <input type="text" name="uid" maxlength="10" onkeyup="validateuserid();" onblur="validateuserid();">
    <input type="password" name="password" onkeyup="validatepassword();" onblur="validatepassword();">
    <input type="submit" name="btnLogin" value="LOGIN">

    <h2 class="barone" style="font-size:27px;font-weight:700;padding: 10px;">Gtpl Bank</h2>

 */
public class _1_Locators {
    String urlRegistered="https://demo.guru99.com/";  // 20 days access
    String url="https://demo.guru99.com/V1/index.php";
    String userId="mngr391441";
    String pwd="tAbAzej";

    String xPathUserId = "//input[@name='uid']";
    String xPathPassord = "//input[@name='password']";
    String xPathLoginButton = "//input[@name='btnLogin']";

    String nameUserId="uid";
    String cssLoginButton = "input[name='btnLogin']";

    String classNameLocatorH2Heading ="barone";



}



/*
Access details to demo site.
User ID :	mngr391441
Password :	tAbAzej
This access is valid only for 20 days.
 */