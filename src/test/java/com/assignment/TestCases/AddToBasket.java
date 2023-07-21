package com.assignment.TestCases;

import com.assignment.Base.SetupPage;
import com.assignment.Pages.AddToBasketPage;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class AddToBasket extends SetupPage {
    public static Logger log = Logger.getLogger(AddToBasket.class);

    @Test
    public void addToBasket() {
        AddToBasketPage addToBasketPage = new AddToBasketPage(driver);
        log.info("Adding item to Basket");
        addToBasketPage.addToCart();
        log.info("Item added to Basket");
    }
}
