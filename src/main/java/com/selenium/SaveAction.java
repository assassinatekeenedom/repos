/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selenium;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SaveAction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int id;

    @Column(length = Integer.MAX_VALUE)
    private String action;

    @Column(length = Integer.MAX_VALUE)
    private String userStory;
    
    @Column(length = Integer.MAX_VALUE)
    private String browser;
    
    @Column(length = Integer.MAX_VALUE)
    private String image;
    
    @Column(length = Integer.MAX_VALUE)
    private String sessionId;
    
    @Column(length = Integer.MAX_VALUE)
    private int stepNumber;

    public SaveAction(String action, String userStory, String browser, String image, String sessionId, int index) {
        this.action = action;
        this.userStory = userStory;
        this.browser = browser;
        this.image = image;
        this.sessionId = sessionId;
        this.stepNumber = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserStory() {
        return userStory;
    }

    public void setUserStory(String userStory) {
        this.userStory = userStory;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getIndex() {
        return stepNumber;
    }

    public void setIndex(int index) {
        this.stepNumber = index;
    }

    @Override
    public String toString() {
        return Save.getJSON(this);
    }

}
