package hierarchy.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "task")

public class Task implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@Column(name = "name")
private String name;

@Column(name = "description")
private String description;

}
