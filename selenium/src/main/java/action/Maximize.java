package action;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Maximize implements Action {

    public void action(RemoteWebDriver browser) {
        browser.manage().window().maximize();
    }

}
