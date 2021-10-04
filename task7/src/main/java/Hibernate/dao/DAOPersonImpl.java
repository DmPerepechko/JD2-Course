package Hibernate.dao;

import Hibernate.pojos.Address;
import Hibernate.pojos.Person;
import Hibernate.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class DAOPersonImpl implements DAOPerson{
    @Override
    public void save(Person person) throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    @Override
    public Person getByID(Serializable id) throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.getTransaction().commit();
        return person;
    }

    @Override
    public void update(Person person, Serializable id) throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Serializable id) throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Person> getAll() throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        List<Person> personList =
                em.createNativeQuery("SELECT * FROM dao_task.person", Person.class).getResultList();
        em.getTransaction().commit();
        return personList;
    }
}
