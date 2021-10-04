package DaoTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static Connection con;

    private static final String USER = "miper";
    private static final String PASSWORD = "1234Sql";
    private static final String URL = "jdbc:mysql://localhost:3306/dao_task";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getDriver() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }

}
