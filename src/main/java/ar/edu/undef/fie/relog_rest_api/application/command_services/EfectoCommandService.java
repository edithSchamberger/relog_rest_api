package ar.edu.undef.fie.relog_rest_api.application.command_services;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindClaseCommandQuery;
import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.infrastructure.EfectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EfectoCommandService {
    private final EfectoRepository efectoRepositoty;
    private final FindClaseCommandQuery clase;

    public EfectoCommandService(EfectoRepository efectoRepositoty, FindClaseCommandQuery clase) {
        this.efectoRepositoty = efectoRepositoty;
        this.clase = clase;
    }

    public Efecto create(Efecto efecto){
     return efectoRepositoty.save(efecto);
    }



    public Efecto update(Long efectoId, Long claseId) {
        var efecto = efectoRepositoty.findById(efectoId)
                .orElseThrow(() -> new RuntimeException("Efecto no encontrado"));

        var clase = this.clase
                .findById(claseId)
                .orElseThrow(() -> new RuntimeException("Criticidad no encontrada"));

        efecto.setClase(clase);

        return efectoRepositoty.save(efecto);
    }

    public void deleteAll(List<Efecto> efectos) {
        efectoRepositoty.deleteAll(efectos);
    }
}
