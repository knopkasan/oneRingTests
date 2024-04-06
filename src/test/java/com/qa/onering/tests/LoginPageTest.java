package com.qa.onering.tests;

import com.qa.onering.base.BaseTest;
import com.qa.onering.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void forgottenPasswordLinkExistTest() {
        //loginPage = homePage.navigateToLoginPage();
        Assert.assertTrue(loginPage.isForgottenPasswordLinkExist());
    }

    @Test(priority = 2)
    public void appLoginTest() {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("username"),
                prop.getProperty("password")));
    }

}
