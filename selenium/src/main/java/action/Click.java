package action;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Click extends ActionData{

    public Click(String target) {
        super(target);
    }

    public void action(RemoteWebDriver browser) {
        browser.findElement(By.id(getTarget())).click();
    }
    
}
