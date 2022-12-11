package ar.edu.undef.fie.relog_rest_api.interfaces;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindEstadoAbastecimientoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindOrganizacionCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_services.EstadoAbastecimientoCommandService;
import ar.edu.undef.fie.relog_rest_api.application.command_services.OrganizacionCommandService;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.OrganizacionRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.EstadoAbastecimientoResponse;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.OrganizacionResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrganizacionController {
    private final FindOrganizacionCommandQuery query;
    private final OrganizacionCommandService service;
    private final EstadoAbastecimientoCommandService estadoAbastecimientoService;
    private final FindEstadoAbastecimientoCommandQuery esatdoAbastecimientoQuery;

    public OrganizacionController(FindOrganizacionCommandQuery query, OrganizacionCommandService service, EstadoAbastecimientoCommandService estadoAbastecimientoService, FindEstadoAbastecimientoCommandQuery esatdoAbastecimientoQuery) {
        this.query = query;
        this.service = service;
        this.estadoAbastecimientoService = estadoAbastecimientoService;
        this.esatdoAbastecimientoQuery = esatdoAbastecimientoQuery;
    }


    //organ Estado Abas
    @GetMapping("/organizaciones")
    public List<OrganizacionResponse> todosLasOrganizaciones(){
        return query
                .findAll()
                .stream()
                .map(Organizacion::response)
                .collect(Collectors.toList());
    }


    @GetMapping("/organizaciones/{id}")
    public OrganizacionResponse alta(@PathVariable Long id){
        return query.findById(id).response();
    }

    @GetMapping("/organizaciones/nombres/{id}")
    public String nombre(@PathVariable Long id) {
        return  query
                .findById(id)
                .getNombre();
    }

    @PostMapping("/organizaciones")
    public OrganizacionResponse create(@RequestBody OrganizacionRequest request){
        return service
                .create(request)
                .response();
    }



    @GetMapping(value = "/organizaciones/{id}/estadoAbastecimientos")
    public List<EstadoAbastecimientoResponse> getEstAbDeOrganizacion(@PathVariable Long id) {
        //funcion que devuelve las personas de una organizacion
        return query.findById(id)
                .getEstadoAbastecimientos().stream().map(EstadoAbastecimiento::response).collect(Collectors.toList());

    }



}
