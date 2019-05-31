package com.automation.modules;

import com.automation.pageObjects.VanillaMasker;
import org.openqa.selenium.WebDriver;


public class VanillaMaskerActions {
    public static void executePhoneNumber(WebDriver driver, String phoneNumber) throws InterruptedException {

        VanillaMasker.phone.click();

        Thread.sleep(1000);

        VanillaMasker.phone.sendKeys(phoneNumber);


    }

    public static void executeOnlyNumber(WebDriver driver, String phoneNumber) throws InterruptedException {

        VanillaMasker.numbers.click();

        Thread.sleep(1000);

        VanillaMasker.numbers.sendKeys(phoneNumber);


    }
}
