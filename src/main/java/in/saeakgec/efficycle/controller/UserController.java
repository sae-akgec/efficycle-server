package in.saeakgec.efficycle.controller;

import in.saeakgec.efficycle.model.User;
import in.saeakgec.efficycle.model.Vehicle;
import in.saeakgec.efficycle.repository.UserRepository;
import in.saeakgec.efficycle.repository.UserVehicleRepository;
import in.saeakgec.efficycle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserVehicleRepository userVehicleRepository;

    @GetMapping("/vehicles")
    public List<Vehicle> getUserVehicles(){
        User user = getLoggedInUser();
        if (user == null){
            throw  new BadCredentialsException("Ivalid user");
        }
        return vehicleRepository.findAllByVehiclesUser_User(user);
    }

    public User getLoggedInUser(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isPresent()){
                return user.get();
            }
        } else {
            String username = principal.toString();
            return null;
        }
        return null;
    }
}
