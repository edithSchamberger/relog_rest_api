package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindClaseCommandQuery;
import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindMovimientoImpCommandQuery;
import ar.edu.undef.fie.relog_rest_api.domain.clases.*;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Egreso;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Ingreso;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RelogRestApiInitCommanService implements CommandLineRunner {
    private final FindClaseCommandQuery findClase;
    private final ClaseCommandService claseCommandService;
    private final FindMovimientoImpCommandQuery findMovimientoCommandQuery;
    private final MovimientoImpCommandService movimientoCommandService;

    public RelogRestApiInitCommanService(FindClaseCommandQuery findClase, ClaseCommandService claseCommandService, FindMovimientoImpCommandQuery findMovimientoCommandQuery, MovimientoImpCommandService movimientoCommandService) {
        this.findClase = findClase;
        this.claseCommandService = claseCommandService;
        this.findMovimientoCommandQuery = findMovimientoCommandQuery;
        this.movimientoCommandService = movimientoCommandService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("ReLog");
        if(findClase.countClases() == 0){
            var clases = new ArrayList<Clase>();
            clases.add(new ClaseI());
            clases.add(new ClaseII());
            clases.add(new ClaseIII());
            clases.add(new ClaseV());
            claseCommandService.create(clases);
        }
        if(findMovimientoCommandQuery.count() == 0){
            MovimientoImp ingreso = new Ingreso("Ingreso");
            movimientoCommandService.save(ingreso);
            MovimientoImp egreso = new Egreso("Egreso");


            movimientoCommandService.save(egreso);
        }
    }
}


/*
@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creando ReLog!!!");

        this.validateEstadoRepository();
    }

    private void validateEstadoRepository() {
        if(estadoRepository.findAll().isEmpty())
            this.createEstados();
    }


    private void createEstados() {
        estadoRepository.save(EstadoPersistent.builder()
                .id(1L).descripcion("Con Stock").build());

        estadoRepository.save(EstadoPersistent.builder()
                .id(2L).descripcion("Con Faltantes").build());
    }

}*/
