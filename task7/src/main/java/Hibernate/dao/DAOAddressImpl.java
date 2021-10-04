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

public class DAOAddressImpl implements DAOAddress{

    @Override
    public void save(Address address) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(address);
        session.getTransaction().commit();
    }

    @Override
    public Address getByID(Serializable id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Address address = session.get(Address.class, id);
        session.getTransaction().commit();
        return address;
    }

    @Override
    public void update(Address address, Serializable id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.update(address);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Serializable id) throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Address address = session.get(Address.class, id);
        if (address != null) {
            session.delete(address);
        }
        session.getTransaction().commit();
    }

    @Override
    public List<Address> getAll() throws SQLException {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        List<Address> addressList =
                session.createNativeQuery("SELECT * FROM dao_task.address", Address.class).getResultList();
        session.getTransaction().commit();
        return addressList;
    }


}
