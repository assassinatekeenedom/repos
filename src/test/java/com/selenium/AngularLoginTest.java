package com.selenium;

import com.selenium.action.Click;
import com.selenium.action.Close;
import com.selenium.action.Open;
import com.selenium.action.DeleteAllCookies;
import com.selenium.action.Type;
import com.selenium.action.WaitForElement;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AngularLoginTest extends UserStory {

    @DataProvider(name = "browsers", parallel = true)
    public Object[][] createData1() throws MalformedURLException {
        return new Object[][]{
            {new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome())},
            {new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.internetExplorer())},
            {new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox())}
        };
    }

    @Test(dataProvider = "browsers", threadPoolSize = 10)
    public void userStory(WebDriver browser) {
        AngularLoginTest test = new AngularLoginTest();
        test.add(new DeleteAllCookies());
        test.add(new Open("http://localhost:8080"));
        test.add(new WaitForElement("login", "60"));
        test.add(new Click("login"));
        test.add(new WaitForElement("username", "60"));
        test.add(new Type("username", "user"));
        test.add(new Type("password", "password"));
        test.add(new Click("submit"));
        test.add(new WaitForElement("greeting", "60"));
        test.add(new Click("logout"));
        test.add(new WaitForElement("nogreeting", "60"));
        test.add(new Close());
        test.action(browser);
    }

}
