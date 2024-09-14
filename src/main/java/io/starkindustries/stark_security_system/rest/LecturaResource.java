package io.starkindustries.stark_security_system.rest;

import io.starkindustries.stark_security_system.model.LecturaDTO;
import io.starkindustries.stark_security_system.service.LecturaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/lecturas", produces = MediaType.APPLICATION_JSON_VALUE)
public class LecturaResource {

    private final LecturaService lecturaService;

    public LecturaResource(final LecturaService lecturaService) {
        this.lecturaService = lecturaService;
    }

    @GetMapping
    public ResponseEntity<List<LecturaDTO>> getAllLecturas() {
        return ResponseEntity.ok(lecturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LecturaDTO> getLectura(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(lecturaService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createLectura(@RequestBody @Valid final LecturaDTO lecturaDTO) {
        final Long createdId = lecturaService.create(lecturaDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateLectura(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final LecturaDTO lecturaDTO) {
        lecturaService.update(id, lecturaDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteLectura(@PathVariable(name = "id") final Long id) {
        lecturaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
