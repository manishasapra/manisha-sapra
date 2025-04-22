package com.n26.monefy.app.core.dataprovider;

import org.testng.annotations.DataProvider;

public class MonefyDataProvider {

    @DataProvider
    public static Object[][] incomeDataProvider() {
        return new Object[][] {
                { "Balance $1,000.00", "$1,000.00", "Adding income" }
        };
    }

    @DataProvider
    public static Object[][] expenseDataProvider() {
        return new Object[][] {
                { "Balance $800.00", "$200.00" }
        };
    }

    @DataProvider
    public static Object[][] homePageDataProvider() {
        return new Object[][] {
                { "Balance $900.00", "$100.00" }
        };
    }

    @DataProvider
    public static Object[][] searchDataProvider() {
        return new Object[][] {
                { "$1,000.00", "Salary", "Adding income", "en" }
        };
    }
}
