package tasks;

import com.automation.base.TestBase;
import com.automation.dataProvider.DataProviderForTasks;
import com.automation.helper.WebEventListener;
import com.automation.modules.VanillaMaskerActions;
import com.automation.pageObjects.VanillaMasker;
import extentReportPackage.ExtentTestManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import org.testng.Assert;

@Listeners(WebEventListener.class)

public class TaskOne extends TestBase {


    @BeforeMethod
    public void setUp() {
        initialization();
    }

    /**
     * Parameterized testing. Data comes from DataProvider class which has hard coded values
     * In real projects DataProvider class will read from csv
     * Number of test case can be increased or decreased by preparing data accordingly
     * */
    @Test(dataProvider = "PhoneNumberValidation", dataProviderClass = DataProviderForTasks.class)
    public void phoneNumberValidation(String phoneNumberActual, String phoneNumberExpected, Method method) throws InterruptedException {
        ExtentTestManager.startTest(method.getName(), "Phone Number Validation");
        PageFactory.initElements(driver, VanillaMasker.class);
        VanillaMaskerActions.executePhoneNumber(driver, phoneNumberActual);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String myText = js.executeScript("return document.getElementById(\"phone\").value").toString();
        Assert.assertEquals(phoneNumberExpected, myText);

    }

    @Test(dataProvider = "OnlyNumberValidation", dataProviderClass = DataProviderForTasks.class)
    public void onlyNumbersValidation(String actualNumber, String expectedNumber, Method method) throws InterruptedException {
        ExtentTestManager.startTest(method.getName(), "Phone Number Validation");
        PageFactory.initElements(driver, VanillaMasker.class);
        VanillaMaskerActions.executeOnlyNumber(driver, actualNumber);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String myText = js.executeScript("return document.getElementById(\"numbers\").value").toString();
        Assert.assertEquals(expectedNumber, myText);

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

}
