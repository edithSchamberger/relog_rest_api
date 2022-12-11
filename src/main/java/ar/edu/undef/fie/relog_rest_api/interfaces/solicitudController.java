package ar.edu.undef.fie.relog_rest_api.interfaces;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindSolicitudCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_services.SolicitudCommandService;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.SolicitudRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.SolicitudResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class solicitudController {
    private final FindSolicitudCommandQuery query;

    private final SolicitudCommandService service;

    public solicitudController(FindSolicitudCommandQuery query, SolicitudCommandService service) {
        this.query = query;
        this.service = service;
    }



    @GetMapping("/solicitudes")
    public List<SolicitudResponse> todosLasSolicitudes(){
        return query
                .findAll()
                .stream()
                .map(Solicitud::response)
                .collect(Collectors.toList());
    }

    @PostMapping("/solicitudes")
    public SolicitudResponse create(@RequestBody SolicitudRequest request){
        return service
                .create(request)
                .response();
    }



}
