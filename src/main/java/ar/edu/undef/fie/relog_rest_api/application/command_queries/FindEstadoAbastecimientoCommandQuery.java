package ar.edu.undef.fie.relog_rest_api.application.command_queries;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.infrastructure.EstadoAbastecimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindEstadoAbastecimientoCommandQuery {
    private final EstadoAbastecimientoRepository repository;

    public FindEstadoAbastecimientoCommandQuery(EstadoAbastecimientoRepository repository) {
        this.repository = repository;
    }


    public List<EstadoAbastecimiento> findAll() {
        return repository.findAll();
    }


    public EstadoAbastecimiento findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Estado Abastecimiento no encontrada"));
    }

}
