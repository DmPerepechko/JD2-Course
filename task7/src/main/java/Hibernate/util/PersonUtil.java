package Hibernate.util;

import Hibernate.pojos.Person;

import java.util.Random;

public class PersonUtil {
    static Random random = new Random();
    static final String[] names =
            {"Andrew", "John", "Paul", "Mike", "Thomas", "Mark", "Michael", "Steven"};
    static final String[] surnames =
            {"Johnson", "Jackson", "Peterson", "Twain", "Dikkens", "Robinson", "Smith"};

    public static Person makePerson() {
        int nameCount = random.nextInt(names.length);
        int surnameCount = random.nextInt(surnames.length);
        int randomAge = random.nextInt(18) + 20;
        return Person.builder()
                .name(names[nameCount])
                .surname(surnames[surnameCount])
                .age(randomAge)
                .build();
    }
}
