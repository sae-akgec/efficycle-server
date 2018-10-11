package in.saeakgec.efficycle.service;

import in.saeakgec.efficycle.model.User;
import in.saeakgec.efficycle.model.Vehicle;
import in.saeakgec.efficycle.model.VehicleStatus;
import in.saeakgec.efficycle.repository.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("VehicleStatusService")
public class VehicleStatusServiceImpl implements VehicleStatusService{

    @Autowired
    VehicleStatusRepository VehicleStatusRepository;

    @Override
    public VehicleStatus saveVehicleStatus(VehicleStatus VehicleStatus) {
        return VehicleStatusRepository.save(VehicleStatus);
    }

    @Override
    public VehicleStatus findById(long id) {
        Optional<VehicleStatus> VehicleStatus = VehicleStatusRepository.findById(id);
        if(VehicleStatus.isPresent()){
            return VehicleStatus.get();
        }
        return null;
    }

    @Override
    public List<VehicleStatus> findAll() {
        return VehicleStatusRepository.findAll();
    }

    @Override
    public VehicleStatus findByVehicle(Vehicle vehicle) {
        Optional<VehicleStatus> VehicleStatus = VehicleStatusRepository.findByVehicle(vehicle);
        if(VehicleStatus.isPresent()){
            return VehicleStatus.get();
        }
        return null;
    }
}
