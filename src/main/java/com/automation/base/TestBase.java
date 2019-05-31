package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.automation.helper.TestUtils;
import com.automation.helper.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class TestBase {

    public static WebDriver driver;
    public static Properties properties;
    public  static EventFiringWebDriver eventFiringDriver;
    public static WebEventListener eventListener;

    public TestBase(){
        try {
            properties = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/automation/config/config.properties");
            properties.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialization(){
        String browserName = properties.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setJavascriptEnabled(false);
            driver = new ChromeDriver(desiredCapabilities);
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }









}

