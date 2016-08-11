package action;

public abstract class ActionData implements Action {

    public String getTarget() {
        return target;
    }

    public String getValue() {
        return value;
    }

    public ActionData(String target) {
        this.target = target;
        this.value = null;
    }

    public ActionData(String target, String value) {
        this.target = target;
        this.value = value;
    }
    
    private final String target;
    private final String value;

}
