package com.qa.onering.components;

import com.microsoft.playwright.Page;

public class Label extends Element{
    public Label(Page page, String selector) {
        super(page, selector);
    }
}
