package in.saeakgec.efficycle.controller;

import in.saeakgec.efficycle.model.Vehicle;
import in.saeakgec.efficycle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping({"/", ""})
    public Vehicle addVehicle(@Valid @RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @GetMapping({"/", ""})
    public List<Vehicle> getVehicles(){
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable long id){
        return vehicleService.findById(id);
    }
}
