package com.selenium;

import java.util.LinkedList;
import org.openqa.selenium.WebDriver;

public class UserStory extends LinkedList<Action> implements Action{

    public void action(WebDriver browser) {
        for(Action action:this){
            action.action(browser);            
        }
    }
    
}
