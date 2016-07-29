/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.selenium.action;

import com.selenium.Action;
import org.openqa.selenium.WebDriver;

public class DeleteAllCookies implements Action{

    public void action(WebDriver browser) {
        browser.manage().deleteAllCookies();
    }
    
}
