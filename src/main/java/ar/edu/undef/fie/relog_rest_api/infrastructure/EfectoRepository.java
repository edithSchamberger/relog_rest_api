package ar.edu.undef.fie.relog_rest_api.infrastructure;


import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EfectoRepository extends JpaRepository<Efecto, Long> {

    List<Efecto> findAllByClase_ClaseId(Long efectoId);


}
