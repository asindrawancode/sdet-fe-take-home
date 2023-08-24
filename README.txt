To run the code, you will need to follow these steps:

1. Install Java Development Kit (JDK) if you haven't already.
2. Set up the Selenium WebDriver and TestNG dependencies in your project. You can do this by adding the necessary dependencies in your project's build configuration (e.g., Maven pom.xml or Gradle build.gradle).
   - Selenium WebDriver Dependency:
     ```xml
     <dependency>
         <groupId>org.seleniumhq.selenium</groupId>
         <artifactId>selenium-java</artifactId>
         <version>3.141.59</version>
     </dependency>
     ```
   - TestNG Dependency:
     ```xml
     <dependency>
         <groupId>org.testng</groupId>
         <artifactId>testng</artifactId>
         <version>7.4.0</version>
     </dependency>
     ```
   - Utils Dependency:
     ```xml
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.13.0</version>
        </dependency>
3. Download the ChromeDriver executable from the official website: https://chromedriver.chromium.org/downloads. Make sure to choose the appropriate version that matches your Chrome browser version.
4. Update the "path/to/chromedriver" in the AutomationTest.java with the path to the downloaded ChromeDriver executable file.
5. Run the TestFlowTest class as a TestNG test.
   - You can right-click on the AutomationTest.java class and select "Run AutomationTest" if you are using an IDE like Eclipse or IntelliJ IDEA.
Make sure you have your test environment properly set up with the required WebDriver configuration, such as browser versions, Java versions, etc., to ensure a successful test run.