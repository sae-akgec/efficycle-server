package in.saeakgec.efficycle.controller;


import in.saeakgec.efficycle.exception.ResourceNotFoundException;
import in.saeakgec.efficycle.model.Vehicle;
import in.saeakgec.efficycle.model.VehicleStatus;

import in.saeakgec.efficycle.repository.UserRepository;
import in.saeakgec.efficycle.repository.VehicleRepository;
import in.saeakgec.efficycle.service.VehicleService;
import in.saeakgec.efficycle.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class VehicleStatusController {
    @Autowired
    VehicleStatusService vehicleStatusService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VehicleService vehicleService;

    @PostMapping({"/", ""})
    public VehicleStatus addVehicleStatus(@RequestBody VehicleStatus vehicleStatus) {
        vehicleStatus.setVehicle(vehicleService.findById(1));
        return vehicleStatusService.saveVehicleStatus(vehicleStatus);
    }

    @GetMapping({"/", ""})
    public List<VehicleStatus> getVehicleStatuss(){
        return vehicleStatusService.findAll();
    }

    @GetMapping("/{id}")
    public VehicleStatus getVehicleStatus(@PathVariable long id){
        return vehicleStatusService.findById(id);
    }
    
    @GetMapping("/vehicle/{id}")
    public  VehicleStatus getVehicleStatusByVehicleNo(@PathVariable String id){
        Vehicle vehicle = vehicleService.fingByVehicleNo(id);
        if (vehicle == null){
            throw new ResourceNotFoundException("dsd", "Dsds", "dsd");
        }
        return vehicleStatusService.findByVehicle(vehicle);
    }
}
