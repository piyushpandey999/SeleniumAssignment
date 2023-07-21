package com.assignment.TestCases;

import com.assignment.Base.SetupPage;
import com.assignment.Pages.RegisterPage;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Regsiter extends SetupPage {
    public static Logger log = Logger.getLogger(Regsiter.class);


    @Test
    public void register() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        log.info("go to the my account page");
        registerPage.clickMyAccount();
        log.info("entering email and password and click on the register button");
        registerPage.enterDetails();
        log.info("user registered");
    }
}
