package BatchTask.dao;

import java.sql.SQLException;

public interface DAO<T> {
    void save(T t) throws SQLException;

    T getByID(int id) throws SQLException;

    void update(T t, int id) throws SQLException;

    int delete(int id) throws SQLException;
}
