package action;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DeleteAllCookies implements Action {

    public void action(RemoteWebDriver browser) {
        browser.manage().deleteAllCookies();
    }

}
