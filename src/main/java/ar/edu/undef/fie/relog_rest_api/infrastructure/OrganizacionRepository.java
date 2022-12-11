package ar.edu.undef.fie.relog_rest_api.infrastructure;

import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
    Organizacion findByNombre(String nombre);

}

