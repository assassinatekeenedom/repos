package action;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Type extends ActionData{

    public Type(String target, String value) {
        super(target, value);
    }

    public void action(RemoteWebDriver browser) {
        browser.findElement(By.id(getTarget())).sendKeys(getValue());
    }
    
}
