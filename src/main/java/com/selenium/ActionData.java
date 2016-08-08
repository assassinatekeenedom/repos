package com.selenium;

public abstract class ActionData implements Action {

    public String getTarget() {
        return target;
    }

    public String getValue() {
        return value;
    }

    public ActionData(String target) {
        this.target = target;
    }

    public ActionData(String target, String value) {
        this.target = target;
        this.value = value;
    }
    
    private String target;
    private String value;

}
