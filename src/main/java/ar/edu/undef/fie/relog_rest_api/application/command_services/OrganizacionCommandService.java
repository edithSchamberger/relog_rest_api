package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindOrganizacionCommandQuery;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.relog_rest_api.exception.GenericAlreadyExistsExeption;
import ar.edu.undef.fie.relog_rest_api.infrastructure.EfectoRepository;
import ar.edu.undef.fie.relog_rest_api.infrastructure.EstadoAbastecimientoRepository;
import ar.edu.undef.fie.relog_rest_api.infrastructure.OrganizacionRepository;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.OrganizacionRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.SolicitudRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.OrganizacionResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OrganizacionCommandService {
    private final OrganizacionRepository repository;
    private final FindOrganizacionCommandQuery query;

    private final EfectoRepository efectoRepository;
    private final EstadoAbastecimientoRepository estadoAbastecimientoRepository;


    public OrganizacionCommandService(OrganizacionRepository repository, FindOrganizacionCommandQuery query, EfectoRepository efectoRepository, EstadoAbastecimientoRepository estadoAbastecimientoRepository) {
        this.repository = repository;
        this.query = query;
        this.efectoRepository = efectoRepository;
        this.estadoAbastecimientoRepository = estadoAbastecimientoRepository;
    }

    public Organizacion create(OrganizacionRequest request) {

        var nuevaOrganizacion = new Organizacion(request.getNombre(), request.getEfectivoOrganico(), request.getLatitud(), request.getLongitud());
        return repository.save(nuevaOrganizacion);
    }

    public List<Organizacion> findAll() {
        return repository.findAll();
    }

    public Optional<Organizacion> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Organizacion organizacion){
        repository.delete(organizacion);}





}
