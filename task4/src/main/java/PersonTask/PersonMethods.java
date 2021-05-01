package PersonTask;

import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PersonMethods {
    private static Random random = new Random();
    static String[] names = new String[]{"John", "Ruben", "Matthew", "Peter", "Harry", "Ronald", "Kenneth", "Andrew"};
    static String[] surnames = new String[]{"Smith", "Jackson", "Kane", "McNeal", "Johnson", "Parker", "Stones", "Carry"};
    static String[] addresses = new String[]{"Skryganova", "Pushkina", "Kolasa", "Mavra", "Odintsova", "Lobanka", "Gikalo", "Beruta"};
    static String[] letterData = new String[]{"musician", "artist", "waiter", "programmer", "builder", "driver"};

    private static String generatePassport() {
        StringBuilder passport = new StringBuilder("MP");
        for (int i = 0; i < 7; i++) {
            passport.append(new Random().nextInt(10));
        }
        return new String(passport);
    }

    public static List<Person> makePerson(int limit) {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            int id = i + 1;
            int nameCount = random.nextInt(names.length);
            int surnameCount = random.nextInt(surnames.length);
            int age = random.nextInt(15) + 15;
            double salary = random.nextInt(4001) + 800;
            String passport = generatePassport();
            int addressCount = random.nextInt(addresses.length);
            Date birthday = Date.valueOf(LocalDate.ofEpochDay(new Random().nextInt(10000) + 5000));
            Timestamp dateTimeCreate = new Timestamp(Date.valueOf(LocalDate.now()).getTime());
            Timestamp timeToLunch = new Timestamp(Date.valueOf(LocalDate.now()).getTime() + i);
            int letterCount = random.nextInt(letterData.length);

            Person person = new Person.Builder().setId(id)
                    .setName(names[nameCount])
                    .setSurname(surnames[surnameCount])
                    .setAge(age)
                    .setSalary(salary)
                    .setPassport(passport)
                    .setAddress(addresses[addressCount])
                    .setDateOfBirthday(birthday)
                    .setDateTimeCreate(dateTimeCreate)
                    .setTimeToLunch(timeToLunch)
                    .setLetter(letterData[letterCount])
                    .build();

            people.add(person);
        }
        return people;
    }
}
