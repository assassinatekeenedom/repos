package action;

import org.openqa.selenium.remote.RemoteWebDriver;

public class MaximizeAndDeleteCookies extends CompositeAction {

    public MaximizeAndDeleteCookies() {
    }

    @Override
    public void action(RemoteWebDriver browser) {
        add(new Maximize());
        add(new DeleteAllCookies());
        super.action(browser);
    }
    
}
