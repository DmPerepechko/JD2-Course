package DaoTask;

import java.util.Objects;

public class Address {
    private int id;
    private String street;
    private int house;

    public Address(int id, String street, int house) {
        this.id = id;
        this.street = street;
        this.house = house;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && house == address.house && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, house);
    }

    @Override
    public String toString() {
        return "Address:" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", house=" + house;
    }
}
