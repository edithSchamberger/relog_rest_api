package ar.edu.undef.fie.relog_rest_api.interfaces;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindMovimientoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_services.MovimientoCommandService;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.MovimientoRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.MovimientoResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovimientoController {
    private final FindMovimientoCommandQuery query;
    private final MovimientoCommandService service;

    public MovimientoController(FindMovimientoCommandQuery query, MovimientoCommandService service) {
        this.query = query;
        this.service = service;
    }

    @PostMapping("movimientos/implementacion/{idImplementacion}")
    public MovimientoResponse createMovimientoInEstadoAbastecimiento(@RequestBody MovimientoRequest request,
                                                                     @PathVariable Long idImplementacion){
        return service.generarMovimiento(request, idImplementacion).response();
    }


}
