package PersonTask;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Person implements Serializable {
    private int id;
    private String name, surname;
    private int age;
    private double salary;
    private String passport;
    private String address;
    private Date dateOfBirthday;
    private Timestamp dateTimeCreate;
    private Timestamp timeToLunch;
    private String letter;

    public Person(){

    }

    public Person(int id, String name, String surname, int age, double salary, String passport, String address, Date dateOfBirthday, Timestamp dateTimeCreate, Timestamp timeToLunch, String letter) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.passport = passport;
        this.address = address;
        this.dateOfBirthday = dateOfBirthday;
        this.dateTimeCreate = dateTimeCreate;
        this.timeToLunch = timeToLunch;
        this.letter = letter;
    }

    public int getId() {
        return id;
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

    public double getSalary() {
        return salary;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public Timestamp getDateTimeCreate() {
        return dateTimeCreate;
    }

    public Timestamp getTimeToLunch() {
        return timeToLunch;
    }

    public String getLetter() {
        return letter;
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
        return "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", dateTimeCreate=" + dateTimeCreate +
                ", timeToLunch=" + timeToLunch +
                ", letter='" + letter;
    }

    public static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder setId(int id){
            person.id = id;
            return this;
        }

        public Builder setName(String name) {
            person.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            person.surname = surname;
            return this;
        }

        public Builder setAge(int age) {
            person.age = age;
            return this;
        }

        public Builder setSalary(double salary) {
            person.salary = salary;
            return this;
        }

        public Builder setPassport(String passport) {
            person.passport = passport;
            return this;
        }

        public Builder setAddress(String address) {
            person.address = address;
            return this;
        }

        public Builder setDateOfBirthday(Date dateOfBirthday) {
            person.dateOfBirthday = dateOfBirthday;
            return this;
        }

        public Builder setDateTimeCreate(Timestamp dateTimeCreate) {
            person.dateTimeCreate = dateTimeCreate;
            return this;
        }

        public Builder setTimeToLunch(Timestamp timeToLunch) {
            person.timeToLunch = timeToLunch;
            return this;
        }

        public Builder setLetter(String letter) {
            person.letter = letter;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}
