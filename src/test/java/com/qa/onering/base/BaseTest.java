package com.qa.onering.base;

import com.microsoft.playwright.Page;
import com.qa.onering.factory.PlaywrightFactory;
import com.qa.onering.pages.HomePage;
import com.qa.onering.pages.ScenarioPage;
import com.qa.onering.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected ScenarioPage scenarioPage;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        scenarioPage = new ScenarioPage(page);
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
