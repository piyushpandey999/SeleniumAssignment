package com.assignment.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.assignment.Base.SetupPage.driver;

public class SortByPopularityPage {

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Shop')]")
    WebElement shopBtn;
    @FindBy(how = How.XPATH,using = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/form[1]/select[1]")
    WebElement sortingBtn;

    public SortByPopularityPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doSort() throws InterruptedException {
        shopBtn.click();

//        WebElement frame1= driver.findElement(By.id("aswift_8"));
//        driver.switchTo().frame(frame1);
//        WebElement frame2 = driver.findElement(By.id("ad_iframe"));
//        driver.switchTo().frame(frame2);
//        driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
//        driver.switchTo().defaultContent();
            Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,150)", "");

        Select select = new Select(sortingBtn);
        select.selectByIndex(1);
    }
}
