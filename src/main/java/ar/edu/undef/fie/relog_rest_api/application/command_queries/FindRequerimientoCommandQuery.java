package ar.edu.undef.fie.relog_rest_api.application.command_queries;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.relog_rest_api.infrastructure.RequerimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FindRequerimientoCommandQuery {

    private final RequerimientoRepository repository;


    public FindRequerimientoCommandQuery(RequerimientoRepository repository) {
        this.repository = repository;
    }

    public List<Requerimiento> findAll(){
        return repository.findAll();
    }
    public Requerimiento findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Requerimiento no encontrado"));
    }




}
