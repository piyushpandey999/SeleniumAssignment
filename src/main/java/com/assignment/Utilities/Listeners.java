package com.assignment.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.assignment.Base.SetupPage.driver;

public class Listeners implements ITestListener{

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;



    public void onStart(ITestContext context) {

        String reportName = "TestResults-"+".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Test-Reports/"+reportName); // specify location
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Hostname","localhost");
        extent.setSystemInfo("OS","Windows 10");
        extent.setSystemInfo("user","Piyush");

        htmlReporter.config().setDocumentTitle("Selenium-Assignment");
        htmlReporter.config().setReportName("Test Results");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }



    public void onTestSuccess(ITestResult tr) {

        logger = extent.createTest(tr.getName());    // create new entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));      // send the passed information

    }


    public void onTestFailure(ITestResult tr) {

        logger = extent.createTest(tr.getName()); // create new entry in the report
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));  // send the passed information

        // Taking the screenshot of the error
        try {
            ScreenShots.takeScreenShots(driver, tr.getName()+" - element_not_found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {

        logger = extent.createTest(result.getName());
        logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));

        System.out.println("test has skipped........");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }
}
