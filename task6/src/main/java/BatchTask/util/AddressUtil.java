package BatchTask.util;

import BatchTask.entity.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressUtil {
    static Random random = new Random();
    static final String[] streets = {"Skryganova", "Odintsova", "Pushkina", "Lobanka", "Mazurova"};

    public List<Address> makeAddress(int limit) {
        List<Address> addressList = new ArrayList<>();
        for (int i = 1; i <= limit ; i++) {
            int streetCount = random.nextInt(streets.length);
            int houseCount = random.nextInt(100);
            addressList.add(new Address(i, streets[streetCount], houseCount));
        }
        return addressList;
    }
}
