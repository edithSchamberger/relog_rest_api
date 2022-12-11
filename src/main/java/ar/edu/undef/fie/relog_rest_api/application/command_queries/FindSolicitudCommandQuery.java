package ar.edu.undef.fie.relog_rest_api.application.command_queries;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.relog_rest_api.infrastructure.RequerimientoRepository;
import ar.edu.undef.fie.relog_rest_api.infrastructure.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FindSolicitudCommandQuery {

    private final SolicitudRepository repository;

    public FindSolicitudCommandQuery(SolicitudRepository repository) {
        this.repository = repository;
    }

    public List<Solicitud> findAll(){
        return repository.findAll();
    }

    public Solicitud findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }



}
