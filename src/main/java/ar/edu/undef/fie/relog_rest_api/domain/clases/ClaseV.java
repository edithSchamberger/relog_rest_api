package ar.edu.undef.fie.relog_rest_api.domain.clases;

import javax.persistence.Entity;

@Entity
public  class ClaseV extends Clase {

    public ClaseV() {
        super("CLV", "Municion", "unidad");
    }

    @Override
    public String getTipo() {
        return "Clase V";
    }
}