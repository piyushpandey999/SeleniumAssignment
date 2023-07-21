package com.assignment.TestCases;

import com.assignment.Base.SetupPage;
import com.assignment.Pages.ProductCategoryPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ProductCategory extends SetupPage {
    public static Logger log = Logger.getLogger(ProductCategory.class);

    @Test(groups = {"shop"})
    public void selectProductCategory(){
        ProductCategoryPage pc = new ProductCategoryPage(driver);
        pc.productCategory();
        log.info("Selecting the Product Category.........");
        String title =driver.getTitle();
        Assert.assertEquals("Android – Automation Practice Site",title);
        log.info("Android is selected as the Product Category");
    }
}
