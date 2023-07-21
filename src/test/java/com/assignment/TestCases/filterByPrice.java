package com.assignment.TestCases;

import com.assignment.Base.SetupPage;
import com.assignment.Pages.FilterByPricePage;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class filterByPrice extends SetupPage {
    public static Logger log = Logger.getLogger(filterByPrice.class);

    @Test(groups = {"shop"})
    public void sliderTest() throws InterruptedException {
        FilterByPricePage sliderPage = new FilterByPricePage(driver);
        log.info("Filtering the items by price");
        sliderPage.moveSlider();
        log.info("Items filtered by price");

    }
}
