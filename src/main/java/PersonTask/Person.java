package PersonTask;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String name, surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "Name=" + name + '\'' +
                ", surname=" + surname + '\'' +
                ", age=" + age;
    }
    private Person(){

    }

    public static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder name(String name) {
            person.name = name;
            return this;
        }

        public Builder surname(String surname) {
            person.surname = surname;
            return this;
        }

        public Builder age(int age) {
            person.age = age;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}
