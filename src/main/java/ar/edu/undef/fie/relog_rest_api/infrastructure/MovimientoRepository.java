package ar.edu.undef.fie.relog_rest_api.infrastructure;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository <Movimiento, Long> {
}
