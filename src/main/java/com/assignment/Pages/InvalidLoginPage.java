package com.assignment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InvalidLoginPage {

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'My Account')]")
    WebElement myAccountBtn;
    @FindBy(how = How.XPATH,using = "//input[@id='username']")
    WebElement Username;
    @FindBy(how = How.XPATH,using = "//input[@id='password']")
    WebElement Password;
    @FindBy(how = How.XPATH,using = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[3]/input[3]")
    WebElement loginBtn;

    public InvalidLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void invalidLogin(){
        myAccountBtn.click();
        Username.sendKeys("therock@gmail.com");
        Password.sendKeys("admin");
        loginBtn.click();
    }
}
