package PersonTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PersonMethods {
    static String[] names = new String[]{"John", "Ruben", "Matthew", "Peter", "Harry", "Ronald", "Kenneth", "Andrew"};
    static String[] surnames = new String[]{"Smith", "Jackson", "Kane", "McNeal", "Johnson", "Parker", "Stones", "Carry"};


    public static Person makePerson() {
        int nameCount = new Random().nextInt(names.length);
        int surnameCount = new Random().nextInt(surnames.length);
        int age = new Random().nextInt(15) + 15;
        return new Person.Builder().name(names[nameCount]).surname(surnames[surnameCount]).age(age).build();
    }
}
