package in.saeakgec.efficycle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.saeakgec.efficycle.repository.UserVehicleRepository;

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


    private float gfLat;


    private float gfLon;


    private float gfRadius;

    private int speedLimit;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", fetch = FetchType.EAGER)
    private List<UserVehicle> vehiclesUser;

    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "vehicle")
    private VehicleStatus vehicleStatus;


    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getGfLat() {
        return gfLat;
    }

    public void setGfLat(float gfLat) {
        this.gfLat = gfLat;
    }

    public float getGfLon() {
        return gfLon;
    }

    public void setGfLon(float gfLon) {
        this.gfLon = gfLon;
    }

    public float getGfRadius() {
        return gfRadius;
    }

    public void setGfRadius(float gfRadius) {
        this.gfRadius = gfRadius;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public List<UserVehicle> getVehiclesUser() {
        return vehiclesUser;
    }

    public void setVehiclesUser(List<UserVehicle> vehiclesUser) {
        this.vehiclesUser = vehiclesUser;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
