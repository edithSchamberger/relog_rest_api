package ar.edu.undef.fie.relog_rest_api.interfaces;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindEfectoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindEstadoAbastecimientoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_services.EfectoCommandService;
import ar.edu.undef.fie.relog_rest_api.application.command_services.EstadoAbastecimientoCommandService;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.exception.NotFoundException;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.EstadoAbastecimientoRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.EstadoAbastecimientoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EstadoAbastecimientoController {
    private final FindEstadoAbastecimientoCommandQuery query;
    private final EstadoAbastecimientoCommandService service;
    private final EfectoCommandService efectoService;
    private final FindEfectoCommandQuery efectoQuery;

    public EstadoAbastecimientoController(FindEstadoAbastecimientoCommandQuery query, EstadoAbastecimientoCommandService service,
                                            EfectoCommandService efectoService, FindEfectoCommandQuery efectoQuery) {
        this.query = query;
        this.service = service;
        this.efectoService = efectoService;
        this.efectoQuery = efectoQuery;
    }

    @GetMapping("/estadoAbastecimentos")
    public List<EstadoAbastecimientoResponse> todosLosEstAb() {
        return query
                .findAll()
                .stream()
                .map(EstadoAbastecimiento::response)
                .collect(Collectors.toList());
    }


    @DeleteMapping(value = "estadoAbastecimiento/{id}")
    public ResponseEntity<String> eliminarEstAb(@PathVariable Long id)  throws NotFoundException {
        service.eliminar(query.findById(id));

        return new ResponseEntity<>(
                "Estado Abastecimiento eliminado con éxito",
                HttpStatus.OK);
    }
    @GetMapping(value = "estadoAbastecimientos/{id}")
    public EstadoAbastecimientoResponse getEstadoAbastecimiento(@PathVariable Long id)  throws NotFoundException {
        return query.findById(id).response();
    }

    @PostMapping("/estadoAbastecimientos/organizaciones/{idOrganizacion}/efectos/{efectoId}")
    public EstadoAbastecimientoResponse addEstadoAbastecimientoToOrganizacion(@RequestBody EstadoAbastecimientoRequest request,
                                                                                @PathVariable Long idOrganizacion,
                                                                                @PathVariable Long efectoId){
        return service.save(request, idOrganizacion, efectoId).response();
    }

}
