package com.assignment.TestCases;

import com.assignment.Base.SetupPage;
import com.assignment.Pages.LoginPage;
import com.assignment.Utilities.DataProviderClass;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends SetupPage {
    public static Logger log = Logger.getLogger(Login.class);

    @Test(dataProviderClass = DataProviderClass.class,dataProvider = "getDetails",groups = {"login"})
    public void login(String username, String password){
        log.info("Login using valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        log.info("entering username and password");
        loginPage.login(username, password);
        log.info("user is now logged in");
        String title = driver.getTitle();
        Assert.assertEquals("My Account – Automation Practice Site", title);
    }
}
