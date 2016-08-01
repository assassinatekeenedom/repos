package com.selenium.action;

import com.selenium.ActionData;
import org.openqa.selenium.WebDriver;

public class Open extends ActionData {

    @Override
    public void action(WebDriver browser) {
        browser.get(this.getTarget());
    }

    public Open(String target) {
        super(target);
    }

}
