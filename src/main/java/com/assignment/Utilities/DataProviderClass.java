package com.assignment.Utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderClass {

    @DataProvider
    public static Object[][] getDetails() throws IOException {
        return ReadExcelData.getdata();
    }
}
