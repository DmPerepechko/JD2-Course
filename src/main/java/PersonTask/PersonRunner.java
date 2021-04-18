package PersonTask;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PersonRunner {
    static List<Person> peopleFromFile = new ArrayList<>();
    public static final String TASK_TEST_TXT = "TaskTest.txt";

    public static void main(String[] args) {
        Collection<Person> personList = Stream.generate(PersonMethods::makePerson)
                .limit(100)
                .filter(person -> person.getAge() < 21)
                .peek(System.out::println)
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .peek(System.out::println)
                .distinct()
                .collect(Collectors.toList());

        writePeople(personList, TASK_TEST_TXT);
        readPeople(TASK_TEST_TXT);
        ResourceBundle rb = ResourceBundle.getBundle("MessageBundle");

        System.out.println("Вывод с помощью RB:");
        for (Person p : peopleFromFile) {
            System.out.println(rb.getString("name") + " " + p.getName() + "; " + rb.getString("surname") + " " + p.getSurname());
        }

    }

    public static void writePeople(Collection<Person> list, String file) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Person person : list) {
                output.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPeople(String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (fileInputStream.available() > 0) {
                Person person = (Person) input.readObject();
                peopleFromFile.add(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}