package com.qa.onering.components;

import com.microsoft.playwright.Page;

import java.util.function.Function;

public class Button extends Element{

    public static final Function<String, String> buildSelector =
            (buttonText) -> String.format("button:has-text('%1$s')", buttonText);

    public Button(Page page, String selector) {
        super(page, buildSelector.apply(selector));
    }

    public void click() {
        super.click(false);
    }

    public void click(boolean waitForNavigation) {
        super.click(waitForNavigation);
    }
}
