package com.selenium.action;

import com.selenium.ActionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Type extends ActionData{

    public Type(String target, String value) {
        super(target, value);
    }

    public void action(WebDriver browser) {
        browser.findElement(By.id(getTarget())).sendKeys(getValue());
    }
    
}
