/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angular.story;

import com.selenium.Save;
import java.util.List;
import org.testng.annotations.Test;

public class StoryResultsTest {

    public StoryResultsTest() {
    }

    @Test
    public void getBrowsers() {
        System.out.println(Save.getJSON(Save.getBrowsers()));
    }

    @Test
    public void getUserStories() {
        System.out.println(Save.getJSON(Save.getUserStories()));
    }

    @Test
    public void getSessionIds() {
        List<String> browsers = Save.getBrowsers();
        List<String> stories = Save.getUserStories();
        for (String story : stories) {
            System.out.println("\t" + story);
            for (String browser : browsers) {
                System.out.println("\t\t" + browser);
                System.out.println(Save.getJSON(Save.getSessionIds(browser, story)));
            }
        }
    }

    @Test
    public void getStepNumbers() {
        List<String> browsers = Save.getBrowsers();
        List<String> stories = Save.getUserStories();
        for (String story : stories) {
            for (String browser : browsers) {
                List<String> sessions = Save.getSessionIds(browser, story);
                for (String session : sessions) {
                    System.out.println(Save.getJSON(Save.getSteps(session)));
                }
            }
        }
    }

    @Test
    public void getImages() {
        List<String> browsers = Save.getBrowsers();
        List<String> stories = Save.getUserStories();
        for (String story : stories) {
            for (String browser : browsers) {
                List<String> sessions = Save.getSessionIds(browser, story);
                for (String session : sessions) {
                    List<Object[][]> steps = Save.getSteps(session);
                    for (Object[] step : steps) {
                        System.out.println("\t===" + step[0]);
                        System.out.println(Save.getJSON(Save.getImage((Integer) step[0])));
                    }
                }
            }
        }
    }

}
