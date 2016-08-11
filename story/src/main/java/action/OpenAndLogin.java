package action;

import org.openqa.selenium.remote.RemoteWebDriver;

public class OpenAndLogin extends CompositeAction {

    public OpenAndLogin() {
    }

    @Override
    public void action(RemoteWebDriver browser) {
        add(new Open("http://localhost:8080"));
        add(new Wait("login", "60"));
        add(new Click("login"));
        add(new Wait("username", "60"));
        add(new Type("username", "user"));
        add(new Type("password", "password"));
        add(new Click("submit"));
        super.action(browser);
    }
    
}
