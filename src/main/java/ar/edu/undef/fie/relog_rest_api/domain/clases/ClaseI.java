package ar.edu.undef.fie.relog_rest_api.domain.clases;

import javax.persistence.Entity;

@Entity
public class ClaseI extends Clase {
    public ClaseI() {
        super("CLI", "Racionamiento", "unidad");
    }



    @Override
    public String getTipo() {
        return "Clase I";
    }

}
