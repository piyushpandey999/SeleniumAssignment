package com.assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import static com.assignment.Base.SetupPage.driver;

public class ProductCategoryPage {

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Shop')]")
    WebElement shopBtn;
    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Android')]")
    WebElement android;

    public ProductCategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void productCategory(){
            shopBtn.click();

//        WebElement frame1= driver.findElement(By.id("aswift_8"));
//        driver.switchTo().frame(frame1);
//        WebElement frame2 = driver.findElement(By.id("ad_iframe"));
//        driver.switchTo().frame(frame2);
//        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
//        driver.switchTo().defaultContent();

            android.click();

    }
}
