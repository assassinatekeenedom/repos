package com.angular.story;

import com.selenium.UserStory;
import com.selenium.action.Click;
import com.selenium.action.Close;
import com.selenium.action.DeleteAllCookies;
import com.selenium.action.Open;
import com.selenium.action.Type;
import com.selenium.action.Wait;
import org.openqa.selenium.WebDriver;

public class LoginUserStory extends UserStory {

    public LoginUserStory() {
    }

    @Override
    public void action(WebDriver browser) {
        add(new DeleteAllCookies());
        add(new Open("http://localhost:8080"));
        add(new Wait("login", "60"));
        add(new Click("login"));
        add(new Wait("username", "60"));
        add(new Type("username", "user"));
        add(new Type("password", "password"));
        add(new Click("submit"));
        add(new Wait("greeting", "60"));
        add(new Click("logout"));
        add(new Wait("nogreeting", "60"));
        add(new Close());
        super.action(browser);
    }
    
}
