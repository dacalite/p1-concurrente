package io.starkindustries.stark_security_system.repos;

import io.starkindustries.stark_security_system.domain.Administrador;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdministradorRepository extends JpaRepository<Administrador, UUID> {
}
