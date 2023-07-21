package com.assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.assignment.Base.SetupPage.driver;

public class LoginPage {

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'My Account')]")
    WebElement myAccountBtn;
    @FindBy(how = How.XPATH,using = "//input[@id='username']")
    WebElement Username;
    @FindBy(how = How.XPATH,using = "//input[@id='password']")
    WebElement Password;
    @FindBy(how = How.XPATH,using = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[3]/input[3]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login(String username,String password){
        myAccountBtn.click();

//        WebElement frame1= driver.findElement(By.id("aswift_8"));
//        driver.switchTo().frame(frame1);
//        WebElement frame2 = driver.findElement(By.id("ad_iframe"));
//        driver.switchTo().frame(frame2);
//        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
//        driver.switchTo().defaultContent();

        Username.sendKeys(username);
        Password.sendKeys(password);
        loginBtn.click();
    }
}
