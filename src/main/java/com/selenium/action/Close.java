package com.selenium.action;

import com.selenium.ActionData;
import org.openqa.selenium.WebDriver;

public class Close extends ActionData {

    @Override
    public void action(WebDriver browser) {
        browser.close();
        browser.quit();
    }

    public Close() {
        super();
    }

}
