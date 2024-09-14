package io.starkindustries.stark_security_system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Operadors")
@Getter
@Setter
public class Operador extends Usuario {
}
