package com.assignment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.assignment.Base.SetupPage.driver;

public class FilterByPricePage {

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Shop')]")
    WebElement shopBtn;
    @FindBy(how = How.XPATH, using = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/aside[@id='sidebar']/div[@id='woocommerce_price_filter-2']/form[1]/div[1]/div[1]/span[2]")
    WebElement slider;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Filter')]")
    WebElement filterBtn;

    public FilterByPricePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void moveSlider() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(shopBtn)).click();

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,-150,0).perform();
        filterBtn.click();

    }
}