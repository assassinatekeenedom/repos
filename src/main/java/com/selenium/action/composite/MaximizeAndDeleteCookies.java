package com.selenium.action.composite;

import com.selenium.UserStory;
import com.selenium.action.DeleteAllCookies;
import com.selenium.action.Maximize;
import org.openqa.selenium.WebDriver;

public class MaximizeAndDeleteCookies extends UserStory {

    public MaximizeAndDeleteCookies() {
    }

    @Override
    public void action(WebDriver browser) {
        add(new Maximize());
        add(new DeleteAllCookies());
        super.action(browser);
    }
    
}
