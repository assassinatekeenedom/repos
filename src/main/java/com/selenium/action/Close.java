package com.selenium.action;

import com.selenium.Action;
import org.openqa.selenium.WebDriver;

public class Close implements Action {

    @Override
    public void action(WebDriver browser) {
        browser.close();
        browser.quit();
    }

    public Close() {
        super();
    }

}
