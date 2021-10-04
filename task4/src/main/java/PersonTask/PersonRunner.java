package PersonTask;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PersonRunner {

    public static void main(String[] args) {
        //generate collection of 100 Person items, filter, sort and extract distinct values
        List<Person> personList = PersonMethods.makePerson(100);
        personList.stream()
                .filter(person -> person.getAge() < 21)
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .peek(System.out::println)
                .distinct()
                .collect(Collectors.toList());

        //write and read collection items using text file
        Writable fileWriter = new FileOps();
        fileWriter.write(personList);

        List<Person> peopleFromFile = fileWriter.read();
        System.out.println("\n"+"Here is the list of names and surnames from file:");
        List<String> namesFile = getNameSurname(peopleFromFile);
        namesFile.forEach(System.out::println);

        //write and read collection using MySQL Database
        Writable baseWriter = new DataBaseOps();
        baseWriter.write(personList);
        List<Person> peopleFromBase = baseWriter.read();
        System.out.println("\n"+"Here is the list of names and surnames from database:");
        List<String> namesBase = getNameSurname(peopleFromBase);
        namesBase.forEach(System.out::println);

        //print name and surname data using ResourceBundle
        ResourceBundle rb = ResourceBundle.getBundle("MessageBundle");
        System.out.println("\n"+"Вывод с помощью RB:");
        for (Person p : personList) {
            System.out.println(rb.getString("name") + " " + p.getName() + "; " + rb.getString("surname") + " " + p.getSurname());
        }
    }

    public static List<String> getNameSurname(List<Person> list) {
        return list.stream()
                .map(person -> "Name: "+ person.getName() + "; surname: " + person.getSurname())
                .collect(Collectors.toList());
    }



}