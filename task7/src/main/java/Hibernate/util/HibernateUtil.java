package Hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory EM_FACTORY;

    static {
        EM_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    }


    public static EntityManager getEntityManager(){
        return EM_FACTORY.createEntityManager();
    }

    public static void close() {
        EM_FACTORY.close();
    }
}
