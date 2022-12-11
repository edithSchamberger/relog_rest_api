package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import ar.edu.undef.fie.relog_rest_api.infrastructure.MovimientoImpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoImpCommandService {
    private final MovimientoImpRepository repository;

    public MovimientoImpCommandService(MovimientoImpRepository repository) {
        this.repository = repository;
    }
    public MovimientoImp save(MovimientoImp movimientoImp){
        return repository.save(movimientoImp);
    }
}
