package Hibernate;

import Hibernate.service.AddressService;
import Hibernate.service.PersonService;

import java.sql.SQLException;


public class App 
{
    public static void main( String[] args ) throws SQLException {
        AddressService addressService = new AddressService();
        PersonService personService = new PersonService();

        addressService.saveAddresses(5);
        personService.savePeople(5);

        addressService.correctAddressHouse(2, 1);
        personService.correctPersonAge(2,2);

        addressService.delete(1);
        personService.delete(1);
    }
}
