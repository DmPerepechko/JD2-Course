package Hibernate.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T>{
    void save(T t) throws SQLException;

    T getByID(Serializable id) throws SQLException;

    void update(T t, Serializable id) throws SQLException;

    void delete(Serializable id) throws SQLException;

    List<T> getAll() throws SQLException;
}
