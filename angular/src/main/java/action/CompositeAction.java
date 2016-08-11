package action;

import java.util.LinkedList;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class CompositeAction extends LinkedList<Action> implements Action {

    public void action(RemoteWebDriver browser) {
        for (Action action : this) {
            action.action(browser);
            SessionId sid = browser.getSessionId();
            if (sid != null) {
                System.out.println(DataBase.save(new SaveAction(action.getClass().getSimpleName(), this.getClass().getSimpleName(), browser.getCapabilities().getBrowserName(), browser.getScreenshotAs(OutputType.BASE64), sid.toString(), this.indexOf(action))));
            }
        }
    }

}
