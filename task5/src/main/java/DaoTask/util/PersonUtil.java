package DaoTask.util;

import DaoTask.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonUtil {
    static Random random = new Random();
    static final String[] names = {"Andrew", "John", "Paul", "Mike", "Thomas", "Mark"};
    static final String[] surnames = {"Johnson", "Jackson", "Peterson", "Twain", "Dikkens"};


    public List<Person> makePeople(int limit) {
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            int nameCount = random.nextInt(names.length);
            int surnameCount = random.nextInt(surnames.length);
            int randomAge = random.nextInt(18) + 20;
            personList.add(new Person(i, names[nameCount], surnames[surnameCount], randomAge));
        }
        return personList;
    }
}
