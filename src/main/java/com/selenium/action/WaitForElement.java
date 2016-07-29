
package com.selenium.action;

import com.selenium.ActionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement extends ActionData{
 
   public WaitForElement(String target, String value) {
        super(target, value);
    }

    public void action(WebDriver browser) {
        WebDriverWait wait = new WebDriverWait(browser, Long.parseLong(getValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(getTarget())));
    }
    
}
