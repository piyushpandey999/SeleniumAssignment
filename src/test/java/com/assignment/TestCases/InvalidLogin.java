package com.assignment.TestCases;

import com.assignment.Base.SetupPage;
import com.assignment.Pages.InvalidLoginPage;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class InvalidLogin extends SetupPage {
    public static Logger log = Logger.getLogger(InvalidLogin.class);

    @Test
    public void invalidLoginTest() {
        InvalidLoginPage il = new InvalidLoginPage(driver);
        log.info("Login using invalid credentials");
        il.invalidLogin();
        log.info("user is not logged in");
    }
}
