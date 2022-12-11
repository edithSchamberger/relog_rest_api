package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindEfectoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.relog_rest_api.infrastructure.ClaseRepositoty;
import ar.edu.undef.fie.relog_rest_api.infrastructure.SolicitudRepository;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.SolicitudRequest;
import org.springframework.stereotype.Service;

@Service
public class SolicitudCommandService {
    private final SolicitudRepository repositoty;
    private final FindEfectoCommandQuery efectoQuery;
    private final ClaseRepositoty claseRepositoty;

    public SolicitudCommandService(SolicitudRepository repositoty, FindEfectoCommandQuery efectoQuery, ClaseRepositoty claseRepositoty) {
        this.repositoty = repositoty;
        this.efectoQuery = efectoQuery;
        this.claseRepositoty = claseRepositoty;
    }


    public Solicitud create(SolicitudRequest request) {

        var nuevaSolicitud = new Solicitud(request.getCantidad(),efectoQuery.findById(request.getEfectoId()));
        return repositoty.save(nuevaSolicitud);
    }
}


