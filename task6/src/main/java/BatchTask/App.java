package BatchTask;

import BatchTask.dao.DAOAddress;
import BatchTask.dao.DAOAddressImpl;
import BatchTask.dao.DAOPeople;
import BatchTask.dao.DAOPeopleImpl;
import BatchTask.entity.Address;
import BatchTask.entity.Person;
import BatchTask.util.AddressUtil;
import BatchTask.util.Connector;
import BatchTask.util.PersonUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws SQLException {
        DAOAddress daoAddress = new DAOAddressImpl();
        DAOPeople daoPeople = new DAOPeopleImpl();

        AddressUtil addressUtil = new AddressUtil();
        PersonUtil peopleUtil = new PersonUtil();


        //Создаем 5 адресов и 5 человек

        List<Address> addressList = addressUtil.makeAddress(5);
        List<Person> peopleList = peopleUtil.makePeople(5, addressList);


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

        //Вызов процедуры и batch запросов
        Connection connection = Connector.getConnection();
        String SQL_UPDATE = "{call changeAddress(?,?,?)}";
        CallableStatement cs = connection.prepareCall(SQL_UPDATE);
        cs.setInt(1, 2);
        cs.setString(2, "Glebki");
        cs.setInt(3, 15);
        cs.addBatch();

        cs.setInt(1, 4);
        cs.setString(2, "Voronova");
        cs.setInt(3, 21);
        cs.addBatch();

        cs.executeBatch();
        connection.close();
        cs.close();
    }
}
