package com.selenium.action.composite;

import com.selenium.CompositeAction;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompositeUserStoryTest {

    public CompositeUserStoryTest() {
    }

    @DataProvider(name = "browsers", parallel = true)
    public Object[][] createData1() throws MalformedURLException {
        return new Object[][]{
            {new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome())},
            {new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.internetExplorer())},
            {new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox())}
        };
    }

    @Test(dataProvider = "browsers", threadPoolSize = 10)
    public void hello(RemoteWebDriver driver) {
        CompositeAction story = new CompositeAction();
        story.add(new MaximizeAndDeleteCookies());
        story.add(new OpenAndLogin());
        story.add(new LogoutAndClose());
        story.action(driver);
    }
}
