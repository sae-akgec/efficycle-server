package in.saeakgec.efficycle.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "vehicles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "vehicleNo"
        })
})
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 15)


    private String vehicleNo;

    @NotBlank
    @Size(max = 20)
    private String title;

    @NotBlank
    private String password;

    @NotBlank
    private float gfLat;

    @NotBlank
    private float gfLon;

    @NotBlank
    private float gfRadius;

    @NotBlank
    private int speedLimit;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicles", fetch = FetchType.EAGER)
//    private List<UserVehicle> vehiclesUser;

//    status
//
}
