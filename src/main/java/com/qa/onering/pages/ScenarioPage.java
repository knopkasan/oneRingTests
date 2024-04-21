package com.qa.onering.pages;

import com.microsoft.playwright.Page;
import com.qa.onering.components.Button;
import com.qa.onering.components.Input;

public class ScenarioPage {
    Page page;
    public Input yearField;
    public Input journeyFromField;
    public Input destinationField;
    public Input daysOfTravelField;
    public Input playerNameField;
    public Input playerRoleField;
    public Button addPlayerButton;
    public Button addAnimalButton;
    public Button addItemButton;
    public Button backToHomeButton;

    public ScenarioPage(Page page) {
        this.page = page;
        addPlayerButton = new Button(page, "//button[contains(text(),'Add player')]");
        addAnimalButton = new Button(page, "//button[contains(text(),'Add animal')]");
        addItemButton = new Button(page, "//button[contains(text(),'Add item')]");
        backToHomeButton = new Button(page, "//a[href='/one-ring-log/']");
    }

    //3. page actions/methods
    public String getScenarioPageTitle() {
        return page.title();
    }

    public String getScenarioPageURL() {
        return page.url();
    }

    public void returnToHomePage() {
        backToHomeButton.click();
    }
}
