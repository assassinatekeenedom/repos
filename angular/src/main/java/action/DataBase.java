package action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Properties;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DataBase {

    private static final String base64 = "data:image/jpeg;base64,";
    private static final SessionFactory selenium;

    static {
        Properties properties = new Properties();
        Configuration configuration = new Configuration();
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost/selenium");
        properties.put("hibernate.id.new_generator_mappings", "false");
        configuration.addAnnotatedClass(SaveAction.class);
        configuration.setProperties(properties);
        selenium = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
    }

    public static Object save(Object save) {
        Session session = selenium.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(save);
            session.flush();
            session.clear();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
        return save;
    }

    public static List getUserStories() {
        List results = null;
        Session session = selenium.openSession();
        Query query = session.createQuery("select distinct userStory from SaveAction");
        try {
            results = query.getResultList();
        } finally {
            session.close();
        }
        return results;
    }

    public static List getBrowsers(String userstory) {
        List results = null;
        Session session = selenium.openSession();
        Query query = session.createQuery("select distinct browser from SaveAction where userStory=:userstory")
                .setParameter("userstory", userstory);
        try {
            results = query.getResultList();
        } finally {
            session.close();
        }
        return results;
    }

    public static List getSessionIds(String browser, String userstory) {
        List results = null;
        Session session = selenium.openSession();
        Query query = session.createQuery("select distinct sessionId from SaveAction where browser=:browser and userStory=:userstory")
                .setParameter("browser", browser)
                .setParameter("userstory", userstory);
        try {
            results = query.getResultList();
        } finally {
            session.close();
        }
        return results;
    }

    public static List getSteps(String sessionId, String userStory) {
        List results = null;
        Session session = selenium.openSession();
        Query query = session.createQuery("select id, stepNumber, action from SaveAction where sessionId=:sessionId and userStory=:userStory")
                .setParameter("sessionId", sessionId)
                .setParameter("userStory", userStory);
        try {
            results = query.getResultList();
        } finally {
            session.close();
        }
        return results;
    }

    public static String getImage(int id) {
        List results = null;
        Session session = selenium.openSession();
        Query query = session.createQuery("select image from SaveAction where id=:id")
                .setParameter("id", id);
        try {
            results = query.getResultList();
        } finally {
            session.close();
        }
        return getJSON(base64 + results.get(0));
    }

    public static String getJSON(Object any) {
        try {
            return new ObjectMapper().writeValueAsString(any);
        } catch (JsonProcessingException ex) {
            return any.getClass().getCanonicalName();
        }
    }
}
