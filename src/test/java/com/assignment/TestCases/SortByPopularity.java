package com.assignment.TestCases;

import com.assignment.Base.SetupPage;
import com.assignment.Pages.SortByPopularityPage;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.assignment.Utilities.Listeners.class)
public class SortByPopularity extends SetupPage {
    public static Logger log = Logger.getLogger(SortByPopularity.class);

    @Test
    public void sortByPopularity() throws InterruptedException {
        SortByPopularityPage sp = new SortByPopularityPage(driver);
        log.info("Sort items by popularity");
        sp.doSort();
        log.info("Items are sorted by popularity");
    }
}
