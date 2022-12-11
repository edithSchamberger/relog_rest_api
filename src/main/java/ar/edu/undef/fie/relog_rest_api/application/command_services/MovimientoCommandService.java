package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Egreso;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Ingreso;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Movimiento;
import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.infrastructure.*;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.MovimientoRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.MovimientoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoCommandService {
    private final MovimientoRepository repository;
    private final RequerimientoRepository requerimientoRepository;
    private final MovimientoImpRepository movimientoImpRepository;
    private final EfectoRepository efectoRepository;
    private final EstadoAbastecimientoRepository estadoAbastecimientoRepository;


    public MovimientoCommandService(MovimientoRepository repository, RequerimientoRepository requerimientoRepository, MovimientoImpRepository movimientoImpRepository, EfectoRepository efectoRepository, EstadoAbastecimientoRepository estadoAbastecimientoRepository,
                                    OrganizacionRepository organizacionRepository) {
        this.repository = repository;
        this.requerimientoRepository = requerimientoRepository;
        this.movimientoImpRepository = movimientoImpRepository;
        this.efectoRepository = efectoRepository;
        this.estadoAbastecimientoRepository = estadoAbastecimientoRepository;
    }


    private void saveEfecto(Efecto efecto) {
        efectoRepository.save(efecto);
    }

    public Movimiento generarMovimiento(MovimientoRequest request, Long idImplementacion) {
        Movimiento movimiento = repository.save(new Movimiento(request.getCantidad(),
                movimientoImpRepository.
                        findById(idImplementacion).
                        orElseThrow(()->new RuntimeException("Implementacion no encontrada"))));
        EstadoAbastecimiento estadoAbastecimiento = estadoAbastecimientoRepository.
                findById(request.getEstadoAbastecimientoId()).
                orElseThrow(()-> new RuntimeException("Estado Abastecimiento no encontrado"));
        estadoAbastecimiento.agregarMovimiento(movimiento);
        estadoAbastecimientoRepository.save(estadoAbastecimiento);
        return movimiento;
    }
}





