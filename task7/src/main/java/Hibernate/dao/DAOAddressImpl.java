package Hibernate.dao;

import Hibernate.pojos.Address;
import Hibernate.pojos.Person;
import Hibernate.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class DAOAddressImpl implements DAOAddress{
    @Override
    public void save(Address address) throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
    }

    @Override
    public Address getByID(Serializable id) throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Address address = em.find(Address.class, id);
        em.getTransaction().commit();
        return address;
    }

    @Override
    public void update(Address address, Serializable id) throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(address);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Serializable id) throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Address address = em.find(Address.class, id);
        if (address != null) {
            em.remove(address);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Address> getAll() throws SQLException {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        List<Address> addressList =
                em.createNativeQuery("SELECT * FROM dao_task.address", Address.class).getResultList();
        em.getTransaction().commit();
        return addressList;
    }


}
