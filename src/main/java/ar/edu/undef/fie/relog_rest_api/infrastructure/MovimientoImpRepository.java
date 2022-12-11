package ar.edu.undef.fie.relog_rest_api.infrastructure;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoImpRepository extends JpaRepository<MovimientoImp, Long> {
}

