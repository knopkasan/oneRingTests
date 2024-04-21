package com.qa.onering.pages;

import com.microsoft.playwright.Page;
import com.qa.onering.components.Button;
import com.qa.onering.components.Input;
import com.qa.onering.components.Label;

public class HomePage {
    Page page;
    public Button logOut;
    public Button deleteScenario;
    public Input scenarioName;
    public Button addButton;
    public Label appDescription;
    public Button publisherLink;
    public Button gameLink;
    public Button devLink;


    public HomePage(Page page) {
        this.page = page;
        scenarioName = new Input(page, "input[placeholder='Insert adventure title']");
        addButton = new Button(page, "//button[normalize-space()='Add']");
        deleteScenario = new Button(page, "button[test-data-id='delete-icon']");
        logOut = new Button(page, "//a[contains(text(),'Log Out')]");
        appDescription = new Label(page,
                "//span[text()='One Ring Logger is a web application that helps Loremasters run games and helps players save character data.']");
        publisherLink = new Button(page, "//a[normalize-space()='Free League Publishing']");
        gameLink = new Button(page, "//a[normalize-space()='The One Ring']");
        devLink = new Button(page, "//a[normalize-space()='brightsdays']");

    }

    //3. page actions/methods

    public Button getScenario(String name) {
        return new Button(page, "//a[normalize-space()='" + name + "']");
    }

    public Button deleteScenario(String name) {
        return new Button(page, getScenario(name).getLocator() + "/.." + addButton.getLocator());
    }

    public void createScenario(String name) {
        scenarioName.setText(name, false);
        addButton.click();
    }

    public String getHomePageTitle() {
        return page.title();
    }

    public String getHomePageURL() {
        return page.url();
    }
}
