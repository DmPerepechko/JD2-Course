package BatchTask.util;

import BatchTask.entity.Address;
import BatchTask.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonUtil {
    static Random random = new Random();
    static final String[] names = {"Andrew", "John", "Paul", "Mike", "Thomas", "Mark"};
    static final String[] surnames = {"Johnson", "Jackson", "Peterson", "Twain", "Dikkens"};

    private static int getAddress(List<Address> addresses) {
        int[] addressSize = new int[addresses.size()];
        int count = 0;
        for (Address address : addresses) {
            addressSize[count] = address.getId();
            count++;
        }
        return addressSize[(int) (Math.random() * addressSize.length)];
    }

    public List<Person> makePeople(int limit, List<Address> addresses) {
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            int nameCount = random.nextInt(names.length);
            int surnameCount = random.nextInt(surnames.length);
            int randomAge = random.nextInt(18) + 20;
            int addressCount = getAddress(addresses);
            personList.add(new Person(i, names[nameCount], surnames[surnameCount], randomAge, addressCount));
        }
        return personList;
    }
}
