package com.qa.onering.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import org.awaitility.Awaitility;

import java.time.Duration;
import java.util.concurrent.Callable;

public class Element {
    protected final Page page;
    protected final String selector;

    public Element (Page page, String selector) {
        this.page = page;
        this.selector = selector;
    }

    public void click (boolean waitForNavigation) {
        if (waitForNavigation) {
            page.waitForNavigation(() -> getLocator().click());
        } else {
            getLocator().click();
        }
    }

    public String getText() {
        return getLocator().textContent();
    }

    public String getAttribute(String attribute) {
        return getLocator().getAttribute(attribute);
    }

    public String getInputValue() {
        return getLocator().inputValue();
    }

    public boolean isDisabled() {
        return getLocator().isDisabled();
    }

    public boolean isEditable() {
        return getLocator().isEditable();
    }

    public boolean isHidden() {
        return getLocator().isHidden();
    }

    public boolean isVisible() {
        return getLocator().isVisible();
    }

    public void scrollIntoView() {
        getLocator().scrollIntoViewIfNeeded();
    }

    public void waitUntilPresent(Duration duration) {
        waitUntil(() -> getLocator().count() > 0, duration);
    }

    public void waitUntilVisible(Duration duration) {
        waitUntil(() -> getLocator().isVisible(), duration);
    }

    public void waitUntilInvisible(Duration duration) {
        waitUntil(() -> !getLocator().isVisible(), duration);
    }

    public void waitUntil(Callable<Boolean> condition, Duration duration) {
        Awaitility.await().atMost(duration).ignoreExceptions().until(condition);
    }

    protected Locator getLocator() {
        return page.locator(selector).first();
    }
}
