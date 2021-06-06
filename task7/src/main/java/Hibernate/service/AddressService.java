package Hibernate.service;

import Hibernate.dao.DAOAddressImpl;
import Hibernate.dao.DAOPersonImpl;
import Hibernate.pojos.Address;
import Hibernate.pojos.Person;
import Hibernate.util.AddressUtil;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class AddressService {
    private DAOAddressImpl daoAddress = new DAOAddressImpl();

    public AddressService() {

    }

    public void saveAddress(Address address) {
        try {
            daoAddress.save(address);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Address getByID(Serializable id) {
        try {
            return daoAddress.getByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void update(Address address, Serializable id) {
        try {
            daoAddress.update(address, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Serializable id) {
        try {
            daoAddress.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Address> getAll() {
        try {
            return daoAddress.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void saveAddresses(int limit) {
        for (int i = 0; i < limit; i++){
            try {
                daoAddress.save(AddressUtil.makeAddress());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void correctAddressHouse(int index, int alter) throws SQLException {
        Address address = new Address();
        List<Address> addressList = daoAddress.getAll();
        int size = addressList.size();

        for (int i = size - index; i <= size; i++) {
            try {
                address = daoAddress.getByID(i);
                address.setHouse(address.getHouse() + alter);
                daoAddress.update(address, i);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
