package com.assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.assignment.Base.SetupPage.driver;

public class RegisterPage {


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'My Account')]")
    WebElement myAccount;
    @FindBy(how = How.XPATH, using = "//input[@id='reg_email']")
    WebElement email;
    @FindBy(how = How.XPATH, using = "//input[@id='reg_password']")
    WebElement password;
    @FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/p[3]/input[3]")
    WebElement registerBtn;
    @FindBy(how = How.ID,using = "dismiss-button")
    WebElement dismissBtn;

//    public static By adclose = By.xpath("//div[@id='ad_position_box']");
    @FindBy(how = How.XPATH,using = "//div[@id='ad_position_box']")
    WebElement adposition;
    @FindBy(how = How.ID,using = "ad_iframe")
    WebElement adiframe;


    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickMyAccount() {
        myAccount.click();
    }
    public void enterDetails() throws InterruptedException {
        Thread.sleep(3000);

//        WebElement frame1= driver.findElement(By.id("aswift_7"));
//        driver.switchTo().frame(frame1);
//        WebElement frame2 = driver.findElement(By.id("ad_iframe"));
//        driver.switchTo().frame(frame2);
////        driver.findElement(By.className("ns-uwuq9-e-18")).click();
//        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
//        driver.switchTo().defaultContent();

        email.sendKeys("therock219@gmail.com");
        password.sendKeys("@theking999");
        registerBtn.click();

    }
}
