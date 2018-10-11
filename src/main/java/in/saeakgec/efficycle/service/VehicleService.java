package in.saeakgec.efficycle.service;

import in.saeakgec.efficycle.model.User;
import in.saeakgec.efficycle.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle fingByVehicleNo(String vehicleNo);
    List<Vehicle> findByUser(User user);
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle findById(long id);
    List<Vehicle> findAll();
}
