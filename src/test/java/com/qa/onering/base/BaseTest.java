package com.qa.onering.base;

import com.microsoft.playwright.Page;
import com.qa.onering.factory.PlaywrightFactory;
import com.qa.onering.pages.ScenarionPage;
import com.qa.onering.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected ScenarionPage scenarioPage;
    protected LoginPage loginPage;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        scenarioPage = new ScenarionPage(page);
        loginPage = new LoginPage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
