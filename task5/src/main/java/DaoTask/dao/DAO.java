package DaoTask.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    void save(T t) throws SQLException;

    T getByID(int id) throws SQLException;

    void update(T t, int id) throws SQLException;

    int delete(int id) throws SQLException;

}
