package com.selenium;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;
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
        properties.put("hibernate.show_sql", "true");
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

    public static String getJSON(Object any) {
        try {
            return new ObjectMapper().writeValueAsString(any);
        } catch (JsonProcessingException ex) {
            return any.getClass().getCanonicalName();
        }
    }
}
