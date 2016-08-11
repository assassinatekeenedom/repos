package action;

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

    public String getAction() {
        return action;
    }

    public String getUserStory() {
        return userStory;
    }

    public String getBrowser() {
        return browser;
    }

    public String getImage() {
        return image;
    }

    public String getSessionId() {
        return sessionId;
    }

    public int getIndex() {
        return stepNumber;
    }

    @Override
    public String toString() {
        return DataBase.getJSON(this);
    }

}
