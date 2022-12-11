package ar.edu.undef.fie.relog_rest_api.infrastructure;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepositoty extends JpaRepository<Clase, Long> {

}
