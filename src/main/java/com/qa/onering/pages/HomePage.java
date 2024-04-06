package com.qa.onering.pages;

import com.microsoft.playwright.Page;
import com.qa.onering.components.Button;
import com.qa.onering.components.Input;

public class HomePage {
    Page page;
    Button logOut;
    Button deleteScenario;
    Input scenarioName;
    Button addButton;



    public HomePage(Page page) {
        this.page = page;
        scenarioName = new Input(page, "input[placeholder='Insert adventure title']");
        addButton = new Button(page, "Add");
    }

    //3. page actions/methods
    public String getHomePageTitle() {
        return page.title();
    }

    public String getHomePageURL() {
        return page.url();
    }
}
