package hierarchy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

@PrimaryKeyJoinColumn(name = "task_id")
@Entity
@Table(name = "hometask")

public class HomeTask extends Task{
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Embedded
    private Address address;


}
