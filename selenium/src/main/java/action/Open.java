package action;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Open extends ActionData {

    @Override
    public void action(RemoteWebDriver browser) {
        browser.get(this.getTarget());
    }

    public Open(String target) {
        super(target);
    }

}
