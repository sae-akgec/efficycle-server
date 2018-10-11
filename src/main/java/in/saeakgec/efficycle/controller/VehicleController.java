package in.saeakgec.efficycle.controller;

import in.saeakgec.efficycle.exception.ResourceNotFoundException;
import in.saeakgec.efficycle.json.AddVehicleRequest;
import in.saeakgec.efficycle.model.User;
import in.saeakgec.efficycle.model.UserVehicle;
import in.saeakgec.efficycle.model.Vehicle;
import in.saeakgec.efficycle.repository.UserRepository;
import in.saeakgec.efficycle.repository.UserVehicleRepository;
import in.saeakgec.efficycle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserVehicleRepository userVehicleRepository;

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

    @PostMapping("/share")
    public UserVehicle addShare(@Valid @RequestBody AddVehicleRequest addVehicleRequest){
        Optional<User> user = userRepository.findByUsernameOrEmail(addVehicleRequest.getUser_id(), addVehicleRequest.getUser_id());
        if (!user.isPresent()){
            throw new ResourceNotFoundException("user", "user_id", "null");
        }

        Vehicle vehicle = vehicleService.findById(addVehicleRequest.getVehicle_id());
        if (vehicle == null){
            throw new ResourceNotFoundException("vehicle", "vehicle_id", "null");
        }
        UserVehicle userVehicle = new UserVehicle();
        userVehicle.setUser(user.get());
        userVehicle.setVehicle(vehicle);
        userVehicle.setAdmin(addVehicleRequest.isAdmin());
        return userVehicleRepository.save(userVehicle);
    }
}
