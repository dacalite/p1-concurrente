package io.starkindustries.stark_security_system.service;

import io.starkindustries.stark_security_system.domain.Lectura;
import io.starkindustries.stark_security_system.domain.Sensor;
import io.starkindustries.stark_security_system.model.LecturaDTO;
import io.starkindustries.stark_security_system.repos.LecturaRepository;
import io.starkindustries.stark_security_system.repos.SensorRepository;
import io.starkindustries.stark_security_system.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class LecturaService {

    private final LecturaRepository lecturaRepository;
    private final SensorRepository sensorRepository;

    public LecturaService(final LecturaRepository lecturaRepository,
            final SensorRepository sensorRepository) {
        this.lecturaRepository = lecturaRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<LecturaDTO> findAll() {
        final List<Lectura> lecturas = lecturaRepository.findAll(Sort.by("id"));
        return lecturas.stream()
                .map(lectura -> mapToDTO(lectura, new LecturaDTO()))
                .toList();
    }

    public LecturaDTO get(final Long id) {
        return lecturaRepository.findById(id)
                .map(lectura -> mapToDTO(lectura, new LecturaDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final LecturaDTO lecturaDTO) {
        final Lectura lectura = new Lectura();
        mapToEntity(lecturaDTO, lectura);
        return lecturaRepository.save(lectura).getId();
    }

    public void update(final Long id, final LecturaDTO lecturaDTO) {
        final Lectura lectura = lecturaRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(lecturaDTO, lectura);
        lecturaRepository.save(lectura);
    }

    public void delete(final Long id) {
        lecturaRepository.deleteById(id);
    }

    private LecturaDTO mapToDTO(final Lectura lectura, final LecturaDTO lecturaDTO) {
        lecturaDTO.setId(lectura.getId());
        lecturaDTO.setValor(lectura.getValor());
        lecturaDTO.setFecha(lectura.getFecha());
        lecturaDTO.setSensor(lectura.getSensor() == null ? null : lectura.getSensor().getId());
        return lecturaDTO;
    }

    private Lectura mapToEntity(final LecturaDTO lecturaDTO, final Lectura lectura) {
        lectura.setValor(lecturaDTO.getValor());
        lectura.setFecha(lecturaDTO.getFecha());
        final Sensor sensor = lecturaDTO.getSensor() == null ? null : sensorRepository.findById(lecturaDTO.getSensor())
                .orElseThrow(() -> new NotFoundException("sensor not found"));
        lectura.setSensor(sensor);
        return lectura;
    }

}
