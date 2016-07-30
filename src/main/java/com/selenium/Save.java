package com.selenium;

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

public class Save {

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

    public Object call() {
        Transaction tx = session.beginTransaction();
        session.save(save);
        session.flush();
        session.clear();
        tx.commit();
        session.close();
        return save;
    }
    private Session session;
    private Object save;

    public Save(Session session, Object save) {
        this.session = session;
        this.save = save;
    }

    public static Object save(Object save) {
        return new Save(selenium.openSession(), save).call();
    }

    public static List getBrowsers() {
        Session session = selenium.openSession();
        Query query = session.createQuery("select distinct browser from SaveAction");
        List results = query.getResultList();
        session.close();
        return results;
    }

    public static List getUserStories() {
        Session session = selenium.openSession();
        Query query = session.createQuery("select distinct userStory from SaveAction");
        List results = query.getResultList();
        session.close();
        return results;
    }

    public static List getSessionIds(String browser, String userstory) {
        Session session = selenium.openSession();
        Query query = session.createQuery("select distinct sessionId from SaveAction where browser=:browser and userStory=:userstory")
                .setParameter("browser", browser)
                .setParameter("userstory", userstory);
        List results = query.getResultList();
        session.close();
        return results;
    }
    
    public static List getImage(int id) {
        Session session = selenium.openSession();
        Query query = session.createQuery("select image from SaveAction where id=:id")
                .setParameter("id", id);
        List results = query.getResultList();
        session.close();
        return results;
    }
    
    public static List getSteps(String sessionId) {
        Session session = selenium.openSession();
        Query query = session.createQuery("select id, stepNumber, action from SaveAction where sessionId=:sessionId")
                .setParameter("sessionId", sessionId);
        List results = query.getResultList();
        session.close();
        return results;
    }

    public static String getJSON(Object any) {
        try {
            return new ObjectMapper().writeValueAsString(any);
        } catch (JsonProcessingException ex) {
            return any.getClass().getCanonicalName();
        }
    }
}
