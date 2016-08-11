package action;

import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginAndLogoutUserStory extends CompositeAction {

    public LoginAndLogoutUserStory() {
    }

    @Override
    public void action(RemoteWebDriver browser) {
        add(new Maximize());
        add(new DeleteAllCookies());
        add(new Open("http://localhost:8080"));
        add(new Wait("login", "60"));
        add(new Click("login"));
        add(new Wait("username", "60"));
        add(new Type("username", "user"));
        add(new Type("password", "password"));
        add(new Click("submit"));
        add(new Wait("greeting", "60"));
        add(new Click("logout"));
        add(new Wait("nogreeting", "60"));
        add(new Close());
        super.action(browser);
    }
    
}
