package io.starkindustries.stark_security_system.repos;

import io.starkindustries.stark_security_system.domain.Sensor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SensorRepository extends JpaRepository<Sensor, UUID> {
}
