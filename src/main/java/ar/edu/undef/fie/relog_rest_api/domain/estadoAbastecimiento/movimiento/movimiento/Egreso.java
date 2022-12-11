package ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;

import javax.persistence.Entity;

@Entity
public class Egreso extends MovimientoImp {


    public Egreso(String descripcion) {
        super(descripcion);
    }
    public Egreso() {
    }

    @Override
    public void ejecutar(EstadoAbastecimiento estadoAbastecimiento, Long cantidad) {
        estadoAbastecimiento.setCantidadDisponible(estadoAbastecimiento.getCantidadDisponible()-cantidad);

    }

    @Override
    public String getTipo() {
        return "Egreso";
    }


}
