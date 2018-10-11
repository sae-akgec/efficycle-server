package in.saeakgec.efficycle.repository;

import in.saeakgec.efficycle.model.User;
import in.saeakgec.efficycle.model.UserVehicle;
import in.saeakgec.efficycle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserVehicleRepository extends JpaRepository<UserVehicle, Long> {
    List<UserVehicle> findByUser(User user);
}
