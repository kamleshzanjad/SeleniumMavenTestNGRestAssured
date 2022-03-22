# 1  Goto Intellij IDEA preferences ,search (command+,)
   Search for plugins.
   Click on Marketplace.
   Search for testng.
   Install the plugin "Create TestNG XML" and Apply the changes.
   Restart Intellij.
   Right on your project and click on "Create TestNG XML"
   Click OK on the confirmation dialog


# 2 Most of the time, Maven plug-in is automatically installed in the Eclipse, but if it is not present, we will go to the
    Eclipse Market Place and search for Maven and download the M2E integrated version from there.

# 3  Download the jar files here: https://www.selenium.dev/downloads/  Section Selenium Clients and WebDriver Language Bindings
   Java  Stable: <Version> <Date>
   Save it on local pc
   
   Then add them in intellij via File ->Project Structure->Modules.
   Click the Dependencies Tab.
   Click the plus +.
   Add all the extracted jars from the zip you downloaded including those inside and outside the lib folder.
   Select them all and Apply
   If Issue persist Intellij > File ->Invalidate Caches/Restart And Build your project
   
# 4  Down POM dependency / Jar
    Right click Pom.xml file
    Select Maven
    Select Reload Project
    Wait for all jar files to download.
    Verify under External Libraries, all Maven jar are present

# 5 Execution
     A Right-click on the java file, and select Run As → 1 TestNG Test 
     B open Terminal / command prompt and write command
        Run once 
        mvn clean install
        
        Execute below multiple time    
        mvn clean compile test
 
# 6 If Issue persist Intellij > File ->Invalidate Caches/Restart And Build your project
  Menu Build> Build Project


# 7 "https://demo.guru99.com/";  // 20 days access . login and get crednetials. change uid and pwd in ALL FILES