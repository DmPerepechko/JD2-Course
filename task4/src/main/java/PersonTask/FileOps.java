package PersonTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOps implements Writable {
    static final String FILE = "TaskTest.txt";

    @Override
    public void write(List<Person> list) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILE))) {
            for (Person person : list) {
                output.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List read() {
        List<Person> list = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FILE);
             ObjectInputStream input = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                Person person = (Person) input.readObject();
                list.add(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}

