package com.selenium.action.composite;

import com.selenium.CompositeAction;
import com.selenium.action.Click;
import com.selenium.action.Close;
import com.selenium.action.Wait;
import org.openqa.selenium.WebDriver;

public class LogoutAndClose extends CompositeAction {

    public LogoutAndClose() {
    }

    @Override
    public void action(WebDriver browser) {
        add(new Wait("greeting", "60"));
        add(new Click("logout"));
        add(new Wait("nogreeting", "60"));
        add(new Close());
        super.action(browser);
    }
    
}
