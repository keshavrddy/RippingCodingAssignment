package com.automation.pageObjects;

import com.automation.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VanillaMasker extends TestBase {


    @FindBy(how = How.ID, using = "phone")
    public static WebElement phone;


    @FindBy(how = How.ID, using = "numbers")
    public static WebElement numbers;

}
