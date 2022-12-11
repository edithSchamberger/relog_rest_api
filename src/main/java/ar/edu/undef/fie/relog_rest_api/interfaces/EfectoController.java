package ar.edu.undef.fie.relog_rest_api.interfaces;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindClaseCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindEfectoCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_services.EfectoCommandService;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.EfectoRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.EfectoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EfectoController {
    private  final FindEfectoCommandQuery query;
    private final EfectoCommandService service;
    private  final FindClaseCommandQuery claseQuery;


    public EfectoController(FindEfectoCommandQuery findEfectoCommandQuery, EfectoCommandService efectoCommandService, FindClaseCommandQuery claseQuery) {
        this.query = findEfectoCommandQuery;
        this.service = efectoCommandService;
        this.claseQuery = claseQuery;
    }

    @GetMapping("/efectos")
    public List<EfectoResponse> findAllEfectos(){
        return query
                .findAll()
                .stream()
                .map(Efecto::response)
                .collect(Collectors.toList());
    }
    @PostMapping("/efectos/{claseId}")
    public EfectoResponse create(@RequestBody EfectoRequest request,@PathVariable Long claseId) {
        Efecto efecto = new Efecto(request.getNombreEfecto());
        Clase clase =  claseQuery.findById(claseId).orElseThrow(()->new RuntimeException("Clase No encontrada"));;
                efecto.setClase(clase);
        return service
                .create(efecto)
                .response();
    }

    @PatchMapping("/archivos/{archivoId}")
    public EfectoResponse patch(@PathVariable Long efectoId, @RequestParam Long claseId) {
        return service
                .update(efectoId, claseId)
                .response();
    }

    @GetMapping("/clases/{claseId}/efectos")
    public List<EfectoResponse> findAllByClase(@PathVariable Long claseId) {
        return query
                .findByClase(claseId)
                .stream()
                .map(Efecto::response)
                .collect(Collectors.toList());
    }

}
