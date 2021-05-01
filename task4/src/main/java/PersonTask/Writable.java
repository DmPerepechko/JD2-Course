package PersonTask;

import java.util.List;

public interface Writable {
    void write(List<Person> list);
    List read();
}
