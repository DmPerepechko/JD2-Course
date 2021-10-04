package Hibernate.dao;

import Hibernate.pojos.Address;
import Hibernate.pojos.Person;
import Hibernate.util.HibernateUtil;
import Hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class DAOPersonImpl implements DAOPerson{

    @Override
    public void save(Person person) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(person);
        session.getTransaction().commit();
    }

    @Override
    public Person getByID(Serializable id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Person person = session.get(Person.class, id);
        session.getTransaction().commit();
        return person;
    }

    @Override
    public void update(Person person, Serializable id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.update(person);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Serializable id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Person person = session.get(Person.class, id);
        if (person != null) {
            session.delete(person);
        }
        session.getTransaction().commit();
    }

    @Override
    public List<Person> getAll() throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<Person> personList =
                session.createNativeQuery("SELECT * FROM dao_task.person", Person.class).getResultList();
        session.getTransaction().commit();
        return personList;
    }
}
