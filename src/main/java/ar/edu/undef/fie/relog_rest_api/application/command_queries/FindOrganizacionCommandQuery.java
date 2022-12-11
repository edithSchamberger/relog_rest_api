package ar.edu.undef.fie.relog_rest_api.application.command_queries;

import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.infrastructure.OrganizacionRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service

public class FindOrganizacionCommandQuery {
    private final OrganizacionRepository repository;

    public FindOrganizacionCommandQuery(OrganizacionRepository repository) {
        this.repository = repository;
    }

    public List<Organizacion> findAll(){
        return repository.findAll();
    }

   public Organizacion findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Clase No encontrada"));

    }


    public Optional<Organizacion> findByIdDos(Long id) {
        return repository.findById(id);

    }

}
