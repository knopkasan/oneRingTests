package com.qa.onering.pages;

import com.microsoft.playwright.Page;
import com.qa.onering.components.Button;
import com.qa.onering.components.Input;

public class ScenarionPage {
    Page page;


    public ScenarionPage(Page page) {

        this.page = page;
    }

    //3. page actions/methods
    public String getScenarioPageTitle() {
        return page.title();
    }

    public String getScenarioPageURL() {
        return page.url();
    }

}
