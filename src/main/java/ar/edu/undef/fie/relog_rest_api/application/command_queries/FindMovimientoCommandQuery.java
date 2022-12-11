package ar.edu.undef.fie.relog_rest_api.application.command_queries;

import ar.edu.undef.fie.relog_rest_api.infrastructure.MovimientoRepository;
import org.springframework.stereotype.Service;

@Service
public class FindMovimientoCommandQuery {
    private final MovimientoRepository repository;

    public FindMovimientoCommandQuery(MovimientoRepository repository) {
        this.repository = repository;
    }
    public Long count(){
        return repository.count();
    }
}
