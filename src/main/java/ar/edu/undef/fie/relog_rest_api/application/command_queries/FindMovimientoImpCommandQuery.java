package ar.edu.undef.fie.relog_rest_api.application.command_queries;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import ar.edu.undef.fie.relog_rest_api.infrastructure.ClaseRepositoty;
import ar.edu.undef.fie.relog_rest_api.infrastructure.MovimientoImpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindMovimientoImpCommandQuery {
    private final MovimientoImpRepository repository;

    public FindMovimientoImpCommandQuery(MovimientoImpRepository repository) {
        this.repository = repository;
    }
    public Long count(){
        return repository.count();
    }


    public List<MovimientoImp> findAll() {
        return repository.findAll();
    }

    public Optional<MovimientoImp> findById(Long movimientoImpId) {
        return repository.findById(movimientoImpId);
    }
}
