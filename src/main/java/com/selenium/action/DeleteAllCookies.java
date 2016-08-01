package com.selenium.action;

import com.selenium.Action;
import org.openqa.selenium.WebDriver;

public class DeleteAllCookies implements Action {

    public void action(WebDriver browser) {
        browser.manage().deleteAllCookies();
    }

}
