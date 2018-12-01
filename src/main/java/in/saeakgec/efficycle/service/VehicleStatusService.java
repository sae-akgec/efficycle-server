package in.saeakgec.efficycle.service;

import in.saeakgec.efficycle.model.User;
import in.saeakgec.efficycle.model.Vehicle;
import in.saeakgec.efficycle.model.VehicleStatus;

import java.util.List;

public interface VehicleStatusService {
    VehicleStatus saveVehicleStatus(VehicleStatus VehicleStatus);
    VehicleStatus findById(long id);
    List<VehicleStatus> findAll();
    VehicleStatus findByVehicle(Vehicle vehicle);
}
