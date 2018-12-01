package in.saeakgec.efficycle.repository;

import in.saeakgec.efficycle.model.Vehicle;
import in.saeakgec.efficycle.model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {
    Optional<VehicleStatus> findByVehicle(Vehicle vehicle);
}
