package in.saeakgec.efficycle.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;

//    user_vehicle

}
