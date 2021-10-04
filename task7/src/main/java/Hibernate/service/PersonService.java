package Hibernate.service;

import Hibernate.dao.DAOPersonImpl;
import Hibernate.pojos.Address;
import Hibernate.pojos.Person;
import Hibernate.util.AddressUtil;
import Hibernate.util.HibernateUtil;
import Hibernate.util.PersonUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class PersonService {
    private DAOPersonImpl daoPerson = new DAOPersonImpl();

    public PersonService(){

    }

    public void savePerson(Person person) {
        try {
            daoPerson.save(person);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Person getByID(Serializable id){
        try {
            return daoPerson.getByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void update(Person person, Serializable id) {
        try {
            daoPerson.update(person,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Serializable id) {
        try {
            daoPerson.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> getAll() {
        try {
            return daoPerson.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void savePeople(int limit) {
        for (int i = 0; i < limit; i++){
            try {
                daoPerson.save(PersonUtil.makePerson());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void correctPersonAge(int index, int alter) throws SQLException {
        Person person = new Person();
        List<Person> addressList = daoPerson.getAll();
        int size = addressList.size();

        for (int i = size - index; i <= size; i++) {
            person = daoPerson.getByID(i);
            person.setAge(person.getAge() + alter);
            daoPerson.update(person, i);
        }
    }
}
