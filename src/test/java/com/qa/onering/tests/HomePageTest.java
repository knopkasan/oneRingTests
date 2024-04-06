package com.qa.onering.tests;

import com.qa.onering.base.BaseTest;
import com.qa.onering.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest() {
        Assert.assertEquals(scenarioPage.getScenarioPageTitle(),
                AppConstants.HOME_PAGE_TITLE,
                "The title is NOT correct");
    }

    @Test
    public void homePageURLTest() {
        Assert.assertEquals(scenarioPage.getScenarioPageURL(),
                prop.getProperty("url"),
                "The URL is NOT correct");
    }

}
