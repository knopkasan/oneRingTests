package com.qa.onering.tests;

import com.qa.onering.base.BaseTest;
import com.qa.onering.constants.AppConstants;
import org.testng.Assert;
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

    @Test(priority = 1)
    public void createScenarioTest() {
        //Arrange
        String scenarioName = "Scenario 1";
        loginPage.doLogin(prop.getProperty("username"),
                prop.getProperty("password"));
        //Act
        homePage.scenarioName.setText(scenarioName, false);
        homePage.addButton.click();
        //Assert
        Assert.assertTrue(homePage.getScenario(scenarioName).isVisible());
    }

    @Test
    public void verifyPublisherLinkTest() {
        //Arrange
        loginPage.doLogin(prop.getProperty("username"),
                prop.getProperty("password"));
        //Assert
        Assert.assertEquals(homePage.publisherLink.getAttribute("href"),
                AppConstants.PUBLISHER_URL,
                "The publisher URL is not correct");
    }

    @Test
    public void verifyGameLinkTest() {
        //Arrange
        loginPage.doLogin(prop.getProperty("username"),
                prop.getProperty("password"));
        //Assert
        Assert.assertEquals(homePage.gameLink.getAttribute("href"),
                AppConstants.GAME_URL,
                "The game URL is not correct");
    }

    @Test
    public void verifyDeveloperLinkTest() {
        //Arrange
        loginPage.doLogin(prop.getProperty("username"),
                prop.getProperty("password"));
        //Assert
        Assert.assertEquals(homePage.devLink.getAttribute("href"),
                AppConstants.DEV_URL,
                "The developer URL is not correct");
    }

}
