package ar.edu.undef.fie.relog_rest_api.infrastructure;

import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    public List<Solicitud> findAllBySolicitudIdIn(List<Long> ids);


}

