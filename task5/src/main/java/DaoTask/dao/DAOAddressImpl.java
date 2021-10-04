package DaoTask.dao;

import DaoTask.Address;
import DaoTask.DatabaseService;

import java.sql.*;
import java.util.List;

public class DAOAddressImpl implements DAOAddress{
    Connection conn;
    PreparedStatement ps;

    static final String INSERT = "INSERT INTO address(id, street, house) VALUES (?,?,?)";
    static final String GET_QUERY = "SELECT * FROM address where id =";
    static final String UPDATE = "UPDATE address SET id=(?), street=(?), house=(?) where id =";
    static final String DELETE = "DELETE FROM address where id=";


    @Override
    public void save(Address address) throws SQLException {
        conn = DatabaseService.getDriver();
        ps = conn.prepareStatement(INSERT);
        ps.setInt(1, address.getId());
        ps.setString(2, address.getStreet());
        ps.setInt(3, address.getHouse());
        ps.executeUpdate();
    }

    @Override
    public Address getByID(int id) throws SQLException {
        conn = DatabaseService.getDriver();
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery(GET_QUERY+id);

        Address address=null;
        while(set.next()){
            address = new Address(id, set.getString("street"), set.getInt("house"));
        }
        return address;
    }

    @Override
    public void update(Address address, int id) throws SQLException {
        conn = DatabaseService.getDriver();
        ps = conn.prepareStatement(UPDATE + id);

        ps.setInt(1, address.getId());
        ps.setString(2, address.getStreet());
        ps.setInt(3, address.getHouse());
        ps.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException {
        conn = DatabaseService.getDriver();
        Statement statement = conn.createStatement();
        statement.executeUpdate(DELETE+id);
        System.out.println("Address " + id + "was deleted");
        return 0;
    }

}
