package com.automation.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderForTasks {


    @DataProvider(name = "PhoneNumberValidation")
    public static Object[][] phoneNumberData() {
        return new Object[][]{
                {"9085010012", "(90) 8501-0012"},
                {"!@#$%^&*()1234567890", "(12) 3456-7890"}
        };
    }

    @DataProvider(name = "OnlyNumberValidation")
    public static Object[][] onlyNumberData() {
        return new Object[][]{
                {"0p9o8i7u6y", "09876"},
                {"!@#$%^&*()1234567890", "1234567890"}
        };
    }

}
