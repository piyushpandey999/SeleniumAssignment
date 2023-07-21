package com.assignment.TestCases;

import com.assignment.Base.SetupPage;
import com.assignment.Pages.LoginPage;
import com.assignment.Pages.SignOutPage;
import com.assignment.Utilities.DataProviderClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SignOut extends SetupPage {
    public static Logger log = Logger.getLogger(SignOut.class);

    @Test(priority = 0 ,dataProviderClass = DataProviderClass.class,dataProvider = "getDetails")
    public void login(String username, String password){
        log.info("Login using valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        log.info("entering username and password");
        loginPage.login(username, password);
        log.info("user is logged in");

    }
    @Test(priority = 1,dependsOnMethods = {"login"})
    public void logOut() throws InterruptedException {
        SignOutPage sp = new SignOutPage(driver);
        log.info("sign out button clicked");
        sp.logOut();
        log.info("user is signed out");
    }
}
