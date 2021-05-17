package DaoTask;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int id_address;

   public Person(){

   }

    public Person(int id, String name, String surname, int age, int id_address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id_address = id_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && id_address == person.id_address && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, id_address);
    }

    @Override
    public String toString() {
        return "Person " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", id_address=" + id_address;
    }
}
