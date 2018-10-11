package in.saeakgec.efficycle.model;

import javax.persistence.*;

@Entity
@Table(name = "user_vehicle")
public class UserVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean isAdmin;

//    @ManyToOne
//    @JoinColumn(name ="user_id")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name ="vehicle_id")
//    private Vehicle vehicleModel;
//    history
}
