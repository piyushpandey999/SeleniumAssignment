package com.assignment.Base;

import com.assignment.Utilities.ReadingPropertiesFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SetupPage {

    public static WebDriver driver;
    public static ExtentTest test;
    public static Logger log = Logger.getLogger(SetupPage.class);

    @BeforeClass
    public void initializeBrowser() {

        String log4jPath = System.getProperty("user.dir") + "\\log4j.properties";
        PropertyConfigurator.configure(log4jPath);

        log.info("reading browser name from properties file");
        String browser = ReadingPropertiesFile.getProperty("browser");
        log.info("reading mode from properties file");
        String mode = ReadingPropertiesFile.getProperty("mode");


        // Initializing the browser

        if (mode.equals("non-headless")) {
            log.info("run tests in non-headless mode");
            switch (browser) {
                case "chrome":
//                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ReadingPropertiesFile.getProperty("chrome_path"));
                    log.info("opening  chrome browser");
                    ChromeOptions options = new ChromeOptions();
                    options.addExtensions(new File(System.getProperty("user.dir")+ReadingPropertiesFile.getProperty("extensionPath")));
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
//                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + ReadingPropertiesFile.getProperty("firefox_path"));
                    log.info("opening firefox browser");
                    driver = new FirefoxDriver();
                    break;
                case "edge":
//                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + ReadingPropertiesFile.getProperty("edge_path"));
                    log.info("loading edge browser");
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("browser name is invalid");
                    break;
            }
        } else if (mode.equals("headless")) {
            log.info("run tests in headless mode");
            switch (browser) {
                case "chrome": {
//                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ReadingPropertiesFile.getProperty("chrome_path"));
                    ChromeOptions options = new ChromeOptions();

                    // Add the headless argument
                    options.addArguments("headless");

                    //pass the options parameter in the Chrome driver declaration
                    log.info("opening  chrome driver");
                    driver = new ChromeDriver(options);
                    break;
                }
                case "firefox": {
//                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + ReadingPropertiesFile.getProperty("firefox_path"));
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("headless");

                    log.info("opening firefox browser");
                    driver = new FirefoxDriver(options);
                    break;
                }
                case "edge": {
//                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + ReadingPropertiesFile.getProperty("edge_path"));
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("headless");
                    driver = new EdgeDriver(options);
                    break;
                }
                default:
                    log.info("browser name is invalid. Please enter a valid browser name");
                    System.out.println("browser name is invalid");
                    break;
            }
        }

        // Maximizing the window
        log.info("maximizing the window");
        driver.manage().window().maximize();

        // Deleting the cookies
        log.info("deleting the cookies");
        driver.manage().deleteAllCookies();

        // Open the url
        log.info("open the base url");
        driver.get(ReadingPropertiesFile.getProperty("baseurl"));
        String parent = driver.getWindowHandle();
        for (String child : driver.getWindowHandles()) {
            driver.switchTo().window(child);
        }
        driver.close();
        driver.switchTo().window(parent);
    }

    @BeforeMethod
    public void OpenUrl(Method method) {
    }


    @AfterClass
    public void tearDown() throws InterruptedException {

        // Quitting The Browser
        Thread.sleep(2000);
        log.info("----------- closing the browser ---------------");
        driver.quit();
    }

}
