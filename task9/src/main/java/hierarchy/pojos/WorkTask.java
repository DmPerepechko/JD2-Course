package hierarchy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@PrimaryKeyJoinColumn(name = "task_id")
@Entity
@Table(name = "worktask")

public class WorkTask extends Task{
@Column(name = "cost")
    private String cost;
}
