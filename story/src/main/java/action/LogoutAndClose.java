package action;

import org.openqa.selenium.remote.RemoteWebDriver;

public class LogoutAndClose extends CompositeAction {

    public LogoutAndClose() {
    }

    @Override
    public void action(RemoteWebDriver browser) {
        add(new Wait("greeting", "60"));
        add(new Click("logout"));
        add(new Wait("nogreeting", "60"));
        add(new Close());
        super.action(browser);
    }
    
}
