package com.qa.onering.pages;

import com.microsoft.playwright.Page;
import com.qa.onering.components.Button;
import com.qa.onering.components.Input;

public class LoginPage {

    public Page page;

    //1. String locator - OR
    Input email;
    Input password;
    Button loginButton;
    Button forgottenPasswordLink;
    Button signUpLink;
    Button logOut;

    //2. Constructor
    public LoginPage (Page page) {
        this.page = page;
        loginButton = new Button(page, "//button[@type='submit']");
        email = new Input(page, "input[type='email']");
        password = new Input(page, "input[type='password']");
        forgottenPasswordLink = new Button(page, "//a[contains(text(),'Forgot your password?')]");
        signUpLink = new Button(page, "//a[contains(text(),'Sign up')]");
        logOut = new Button(page, "//a[contains(text(),'Log Out')]");
    }

    //3. Methods
    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgottenPasswordLinkExist(){
        return forgottenPasswordLink.isVisible();
    }

    public boolean doLogin(String appUserName, String appPassword) {
        System.out.println("App creds: " + appUserName + ":" + appPassword);
        email.setText(appUserName, false);
        password.setText(appPassword, false);
        loginButton.click();
        return logOut.isVisible();
    }
}
