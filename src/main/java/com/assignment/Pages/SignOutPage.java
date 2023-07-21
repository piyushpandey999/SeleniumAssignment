package com.assignment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage {

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Sign out')]")
    WebElement signOutBtn;

    public SignOutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void logOut() throws InterruptedException {
        Thread.sleep(2000);
        signOutBtn.click();
    }
}
