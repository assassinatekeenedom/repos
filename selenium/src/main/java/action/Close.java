package action;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Close implements Action {

    @Override
    public void action(RemoteWebDriver browser) {
        browser.close();
        browser.quit();
    }

    public Close() {
        super();
    }

}
