package DaoTask.dao;

import DaoTask.DatabaseService;
import DaoTask.Person;

import java.sql.*;
import java.util.List;

public class DAOPeopleImpl implements DAOPeople {
    Connection conn;
    PreparedStatement ps;

    static final String INSERT = "INSERT INTO people(id, name, surname, age) VALUES (?,?,?,?)";
    static final String GET_QUERY = "SELECT * FROM people where id =";
    static final String UPDATE = "UPDATE people SET id=(?), name=(?), surname=(?), age=(?) where id =";
    static final String DELETE = "DELETE FROM people where id=";

    @Override
    public void save(Person person) throws SQLException {
        conn = DatabaseService.getDriver();
        ps = conn.prepareStatement(INSERT);
        ps.setInt(1, person.getId());
        ps.setString(2, person.getName());
        ps.setString(3, person.getSurname());
        ps.setInt(4, person.getAge());
        ps.executeUpdate();
    }

    @Override
    public Person getByID(int id) throws SQLException {
        conn = DatabaseService.getDriver();
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery(GET_QUERY + id);

        Person person = null;
        while (set.next()) {
            person = new Person(id, set.getString("name"), set.getString("surname"), set.getInt("age"));
        }
        return person;
    }

    @Override
    public void update(Person person, int id) throws SQLException {
        conn = DatabaseService.getDriver();
        ps = conn.prepareStatement(UPDATE + id);

        ps.setInt(1, person.getId());
        ps.setString(2, person.getName());
        ps.setString(3, person.getSurname());
        ps.setInt(4, person.getAge());
        ps.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException {
        conn = DatabaseService.getDriver();
        Statement statement = conn.createStatement();
        statement.executeUpdate(DELETE+id);
        System.out.println("Man " + id + "was deleted");
        return 0;
    }

}
