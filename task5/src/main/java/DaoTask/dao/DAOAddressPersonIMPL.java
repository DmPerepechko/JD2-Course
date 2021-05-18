package DaoTask.dao;

import DaoTask.AddressPerson;
import DaoTask.DatabaseService;
import DaoTask.Person;

import java.sql.*;

public class DAOAddressPersonIMPL implements DAOAddressPerson {
    Connection conn;
    PreparedStatement ps;
    Statement statement;

    static final String INSERT = "INSERT INTO address_people(id, id_address, id_person) VALUES (?,?,?)";
    static final String GET_QUERY = "SELECT * FROM address_people where id =";
    static final String UPDATE = "UPDATE address_people SET id=(?), id_address=(?), id_person=(?) where id =";
    static final String DELETE = "DELETE FROM address_people where id=";

    @Override
    public void save(AddressPerson addressPerson) throws SQLException {
        try {
            conn = DatabaseService.getDriver();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, addressPerson.getId());
            ps.setInt(2, addressPerson.getId_address());
            ps.setInt(3, addressPerson.getId_person());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
        }
    }

    @Override
    public AddressPerson getByID(int id) throws SQLException {
        AddressPerson addressPerson = null;

        try {
            conn = DatabaseService.getDriver();
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(GET_QUERY + id);
            while (set.next()) {
                addressPerson = new AddressPerson(id, set.getInt("id_address"), set.getInt("id_person"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
            statement.close();
        }
        return addressPerson;
    }

    @Override
    public void update(AddressPerson addressPerson, int id) throws SQLException {
        try {
            conn = DatabaseService.getDriver();
            ps = conn.prepareStatement(UPDATE + id);
            ps.setInt(1, addressPerson.getId());
            ps.setInt(2, addressPerson.getId_address());
            ps.setInt(3, addressPerson.getId_person());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
        }
    }

    @Override
    public int delete(int id) throws SQLException {
        try {
            conn = DatabaseService.getDriver();
            statement = conn.createStatement();
            statement.executeUpdate(DELETE + id);
            System.out.println("Address and person with id" + id + "were deleted");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conn.close();
            statement.close();
        }
        return 0;
    }
}
