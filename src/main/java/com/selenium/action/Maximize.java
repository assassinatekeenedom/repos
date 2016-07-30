package com.selenium.action;

import com.selenium.Action;
import org.openqa.selenium.WebDriver;

public class Maximize implements Action{

    public void action(WebDriver browser) {
        browser.manage().window().maximize();
    }
    
}
