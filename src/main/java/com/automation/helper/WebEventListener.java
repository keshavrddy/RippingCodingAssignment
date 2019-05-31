package com.automation.helper;


import com.automation.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import extentReportPackage.ExtentManager;
import extentReportPackage.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class WebEventListener extends TestBase implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Executing " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Currently executing " + iTestContext.getName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Initiating Test " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Testcase  " + getTestMethodName(iTestResult) + " succeeded");
        //ExtentReports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Failed!!!  " + getTestMethodName(iTestResult) + " failed");

        driver.quit();
        //Take base64Screenshot screenshot.
//        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).
//                getScreenshotAs(OutputType.BASE64);
//
//        //ExtentReports log and screenshot operations for failed tests.
//        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
//                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //ExtentReports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}