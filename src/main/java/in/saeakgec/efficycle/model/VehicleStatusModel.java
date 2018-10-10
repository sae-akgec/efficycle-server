package in.saeakgec.efficycle.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "vehicle_status")
public class VehicleStatusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean lockStatus;

    @NotBlank
    private float lat;

    @NotBlank
    private float lon;

    @NotBlank
    private float speed;

    private boolean emergency;

    @NotBlank
    private float batteryPercent;

}
