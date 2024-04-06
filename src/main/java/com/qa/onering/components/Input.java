package com.qa.onering.components;

import com.microsoft.playwright.Page;

import java.util.Objects;

public class Input extends Element {
    public Input(Page page, String selector) {
        super(page, selector);
    }

    public void setText(String text, boolean append) {
        if (append) clearText();
        getLocator().fill(text);
    }

    public void clearText() {
        getLocator().selectText();
        pressKey("Delete");
    }

    public String inputValue() {
        return Objects.nonNull(getLocator().inputValue()) ?
                getLocator().inputValue() :
                getText();
    }

    public void pressKey(String key) {
        getLocator().press(key);
    }
}
