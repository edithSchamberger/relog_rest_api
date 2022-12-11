package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindEfectoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindOrganizacionCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindRequerimientoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.relog_rest_api.infrastructure.*;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.RequerimientoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RequerimientoCommandService {
    private final RequerimientoRepository repository;
    private final FindOrganizacionCommandQuery organizacionquery;
    private final FindEfectoCommandQuery efectoquery;
    private final EfectoRepository efectoRepository;
    private final SolicitudRepository solcitudRepository;
    private final FindRequerimientoCommandQuery requerimientoquery;
    private final OrganizacionRepository organizacionRepository;
    private final EstadoAbastecimientoRepository estadoAbastecimientoRepository;


    public RequerimientoCommandService(RequerimientoRepository repository, FindOrganizacionCommandQuery organizacionquery, FindEfectoCommandQuery efectoquery, EfectoRepository efectoRepository, SolicitudRepository solcitudRepository, FindRequerimientoCommandQuery requerimientoquery, OrganizacionRepository organizacionRepository, EstadoAbastecimientoRepository estadoAbastecimientoRepository) {
        this.repository = repository;
        this.organizacionquery = organizacionquery;
        this.efectoquery = efectoquery;

        this.efectoRepository = efectoRepository;
        this.solcitudRepository =  solcitudRepository;
        this.requerimientoquery = requerimientoquery;
        this.organizacionRepository = organizacionRepository;
        this.estadoAbastecimientoRepository = estadoAbastecimientoRepository;
    }


    public Requerimiento create(RequerimientoRequest request) {
        var listaSolicitud = new ArrayList<Solicitud>();
        for (var solicitudId: request.getIdSolicitudes()) {
            listaSolicitud.add(solcitudRepository.findById(solicitudId).orElse(null));
        }
        var nuevoRequerimiento = new Requerimiento(
                organizacionquery.findById(request.getOrgId()),
                request.getFechaDeEntregaRequerida(),
                listaSolicitud);
        return repository.save(nuevoRequerimiento);
    }

    public void update(Long idRequerimiento) {
        var requerimiento = this.requerimientoquery.findById(idRequerimiento);
        requerimiento.setConfirmado(true);
        this.repository.save(requerimiento);
    }





}
