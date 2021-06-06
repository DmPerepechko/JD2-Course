package Hibernate.util;

import Hibernate.pojos.Address;

import java.util.Random;

public class AddressUtil {
    static String[] streets =
            {"Skryganova", "Odintsova", "Pushkina", "Lobanka", "Mazurova", "Timoshenko",
            "Gagarina", "Nezavisimosti", "Lesnaya"};

    static Random random = new Random();

    public static Address makeAddress() {
        int streetCount = random.nextInt(streets.length);
        int houseCount = random.nextInt(100)+1;
        return Address.builder()
                .street(streets[streetCount])
                .house(houseCount)
                .build();
    }
}
