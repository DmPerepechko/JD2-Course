package BatchTask.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int id_address;
}
