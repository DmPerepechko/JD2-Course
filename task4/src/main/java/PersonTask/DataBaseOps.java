package PersonTask;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseOps implements Writable{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/people?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USER = "miper";
    private static final String PASSWORD = "1234Sql";

    Connection conn = null;
    Statement statement = null;

    public void launchDatabase(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = conn.createStatement();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void write(List<Person> list) {
        launchDatabase();

        String insert = "INSERT INTO table_person(name, surname, age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            for (Person person : list) {
                ps.setString(1, person.getName());
                ps.setString(2, person.getSurname());
                ps.setInt(3, person.getAge());
                ps.setDouble(4, person.getSalary());
                ps.setString(5, person.getPassport());
                ps.setString(6, person.getAddress());
                ps.setDate(7, (Date) person.getDateOfBirthday());
                ps.setTimestamp(8, person.getDateTimeCreate());
                ps.setTimestamp(9, person.getTimeToLunch());
                ps.setString(10, person.getLetter());
                ps.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    @Override
    public List read() {
        launchDatabase();

        List<Person> result = new ArrayList<>();
        ResultSet set = null;

        try {
            String sql = "SELECT * FROM table_person";
            set = statement.executeQuery(sql);
            while (set.next()) {
                Person person = new Person(
                        set.getInt("id"),
                        set.getString("name"),
                        set.getString("surname"),
                        set.getInt("age"),
                        set.getDouble("salary"),
                        set.getString("passport"),
                        set.getString("address"),
                        set.getDate("dateOfBirthday"),
                        set.getTimestamp("dateTimeCreate"),
                        set.getTimestamp("timeToLunch"),
                        set.getString("letter")
                );
                result.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return result;
    }

}
