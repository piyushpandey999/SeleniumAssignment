package com.assignment.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.assignment.Base.SetupPage.driver;

public class AddToBasketPage {

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Shop')]")
    WebElement shopBtn;
    @FindBy(how = How.XPATH,using = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/ul[1]/li[4]/a[2]")
    WebElement add;


    public AddToBasketPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void addToCart(){
        shopBtn.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        add.click();
    }

}
