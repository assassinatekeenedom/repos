package com.selenium.action;

import com.selenium.ActionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Click extends ActionData{

    public Click(String target) {
        super(target);
    }

    public void action(WebDriver browser) {
        browser.findElement(By.id(getTarget())).click();
    }
    
}
