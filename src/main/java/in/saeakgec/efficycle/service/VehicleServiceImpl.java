package in.saeakgec.efficycle.service;

import in.saeakgec.efficycle.model.User;
import in.saeakgec.efficycle.model.Vehicle;
import in.saeakgec.efficycle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle fingByVehicleNo(String vehicleNo) {
        Optional<Vehicle> vehicle = vehicleRepository.findByVehicleNo(vehicleNo);
        if(vehicle.isPresent()){
         return vehicle.get();
        }
        return null;
    }

    @Override
    public List<Vehicle> findByUser(User user) {
        return null;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findById(long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isPresent()){
            return vehicle.get();
        }
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
}
