package ar.edu.undef.fie.relog_rest_api.application.command_queries;



import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.infrastructure.EfectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindEfectoCommandQuery {
    private final EfectoRepository repository;

    public FindEfectoCommandQuery(EfectoRepository repository) {
        this.repository = repository;
    }


    public List<Efecto> findAll(){
        return repository.findAll();
    }

    public List<Efecto> findByClase(Long claseId) {
        return repository.findAllByClase_ClaseId(claseId);
    }

    public Efecto findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la efecto con id: " + id));
    }



}
