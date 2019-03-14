package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactory instance;

    static {
            instance = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    public static SessionFactory getSessionFact(){
        return instance;
    }
}
