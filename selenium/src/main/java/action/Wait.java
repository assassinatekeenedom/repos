package action;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends ActionData {

    public Wait(String target, String value) {
        super(target, value);
    }

    public void action(RemoteWebDriver browser) {
        WebDriverWait wait = new WebDriverWait(browser, Long.parseLong(getValue()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(getTarget())));
    }

}
