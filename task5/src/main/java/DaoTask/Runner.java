package DaoTask;

import DaoTask.dao.DAOAddress;
import DaoTask.dao.DAOAddressImpl;
import DaoTask.dao.DAOPeople;
import DaoTask.dao.DAOPeopleImpl;
import DaoTask.util.AddressUtil;
import DaoTask.util.PersonUtil;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DAOAddress daoAddress = new DAOAddressImpl();
        DAOPeople daoPeople = new DAOPeopleImpl();

        AddressUtil addressUtil = new AddressUtil();
        PersonUtil peopleUtil = new PersonUtil();


        //Создаем 5 адресов и 5 человек

        List<Address> addressList = addressUtil.makeAddress(5);
        List<Person> peopleList = peopleUtil.makePeople(5);


        for (Address address : addressList) {
            daoAddress.save(address);
        }

        for (Person person : peopleList) {
            daoPeople.save(person);
        }

        //Увеличиваем дома 2 последних адресов на 1, возраст 2 последних людей на 2
        Address address = new Address();
        int countAddress = addressList.size();
        for (int i = countAddress - 2; i <= countAddress; i++) {
            address = daoAddress.getByID(i);
            address.setHouse(address.getHouse() + 1);
            daoAddress.update(address, i);
        }

        Person person = new Person();
        int countPerson = peopleList.size();
        for (int i = countPerson - 2; i <= countPerson; i++) {
            person = daoPeople.getByID(i);
            person.setAge(person.getAge() + 2);
            daoPeople.update(person, i);
        }

        //Удаляем первый адрес и первого человека
        daoAddress.delete(1);
        daoPeople.delete(1);
    }
}