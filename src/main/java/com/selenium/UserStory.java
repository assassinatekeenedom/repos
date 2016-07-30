package com.selenium;

import com.selenium.action.Close;
import java.util.LinkedList;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserStory extends LinkedList<Action> implements Action {

    public void action(WebDriver browser) {
        for (Action action : this) {
            action.action(browser);
            if (action.getClass() != Close.class) {
                RemoteWebDriver driver = (RemoteWebDriver) browser;
                System.out.println(Save.save(new SaveAction(action.getClass().getCanonicalName(), this.getClass().getCanonicalName(), driver.getCapabilities().getBrowserName(), driver.getScreenshotAs(OutputType.BASE64), driver.getSessionId().toString())));
            }
        }
    }

}
