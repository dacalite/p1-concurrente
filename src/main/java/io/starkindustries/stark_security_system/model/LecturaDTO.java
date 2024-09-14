package io.starkindustries.stark_security_system.model;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LecturaDTO {

    private Long id;

    @Size(max = 255)
    private String valor;

    private LocalDateTime fecha;

    private UUID sensor;

}
