package hierarchy.util;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionUtil {
    @Getter
    private static SessionFactory sessionFactory;

    public SessionUtil() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable e){
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        if (SessionUtil.getSessionFactory() == null) {
            new SessionUtil();
        }
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
