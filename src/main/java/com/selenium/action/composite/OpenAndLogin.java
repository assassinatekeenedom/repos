package com.selenium.action.composite;

import com.selenium.CompositeAction;
import com.selenium.action.Click;
import com.selenium.action.Open;
import com.selenium.action.Type;
import com.selenium.action.Wait;
import org.openqa.selenium.WebDriver;

public class OpenAndLogin extends CompositeAction {

    public OpenAndLogin() {
    }

    @Override
    public void action(WebDriver browser) {
        add(new Open("http://localhost:8080"));
        add(new Wait("login", "60"));
        add(new Click("login"));
        add(new Wait("username", "60"));
        add(new Type("username", "user"));
        add(new Type("password", "password"));
        add(new Click("submit"));
        super.action(browser);
    }
    
}
