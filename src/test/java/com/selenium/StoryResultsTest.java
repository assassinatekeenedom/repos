/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selenium;

import com.selenium.DataBase;
import java.util.List;
import org.testng.annotations.Test;

public class StoryResultsTest {

    public StoryResultsTest() {
    }

    @Test
    public void getUserStories() {
        System.out.println(DataBase.getJSON(DataBase.getUserStories()));
    }

    @Test
    public void getBrowsers() {
        List<String> stories = DataBase.getUserStories();
        for (String story : stories) {
            System.out.println(DataBase.getJSON(DataBase.getBrowsers(story)));
        }
    }

    @Test
    public void getSessionIds() {
        List<String> stories = DataBase.getUserStories();
        for (String story : stories) {
            List<String> browsers = DataBase.getBrowsers(story);
            System.out.println("\t" + story);
            for (String browser : browsers) {
                System.out.println("\t\t" + browser);
                System.out.println(DataBase.getJSON(DataBase.getSessionIds(browser, story)));
            }
        }
    }

    @Test
    public void getStepNumbers() {
        List<String> stories = DataBase.getUserStories();
        for (String story : stories) {
            List<String> browsers = DataBase.getBrowsers(story);
            for (String browser : browsers) {
                List<String> sessions = DataBase.getSessionIds(browser, story);
                for (String session : sessions) {
                    System.out.println(DataBase.getJSON(DataBase.getSteps(session, story)));
                }
            }
        }
    }

    @Test
    public void getImages() {
        List<String> stories = DataBase.getUserStories();
        for (String story : stories) {
            List<String> browsers = DataBase.getBrowsers(story);
            for (String browser : browsers) {
                List<String> sessions = DataBase.getSessionIds(browser, story);
                for (String session : sessions) {
                    List<Object[][]> steps = DataBase.getSteps(session, story);
                    for (Object[] step : steps) {
                        System.out.println(DataBase.getJSON(DataBase.getImage((Integer) step[0])));
                    }
                }
            }
        }
    }

}
