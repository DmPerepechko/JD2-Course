package DaoTask.util;

import DaoTask.Address;
import DaoTask.AddressPerson;
import DaoTask.Person;

import java.util.List;

public class AddressPersonUtil {
    private static int getAddress(List<Address> addresses) {
        int[] addressSize = new int[addresses.size()];
        int count = 0;
        for (Address address : addresses) {
            addressSize[count] = address.getId();
            count++;
        }
        return addressSize[(int) (Math.random() * addressSize.length)];
    }

    private static int getPerson(List<Person> people) {
        int[] personSize = new int[people.size()];
        int count = 0;
        for (Person person : people) {
            personSize[count] = person.getId();
            count++;
        }
        return personSize[(int) (Math.random() * personSize.length)];
    }

    public static AddressPerson getAddressPerson(Address address, Person person) {
        return AddressPerson.builder()
                .id_address(address.getId())
                .id_person(person.getId())
                .build();
    }
}
