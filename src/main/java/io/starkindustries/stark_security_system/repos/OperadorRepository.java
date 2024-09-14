package io.starkindustries.stark_security_system.repos;

import io.starkindustries.stark_security_system.domain.Operador;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OperadorRepository extends JpaRepository<Operador, UUID> {
}
