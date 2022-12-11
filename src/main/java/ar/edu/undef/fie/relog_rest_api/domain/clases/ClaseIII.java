package ar.edu.undef.fie.relog_rest_api.domain.clases;

import javax.persistence.Entity;

@Entity
public class ClaseIII extends Clase {


    public ClaseIII() {
        super("CLIII", "Combustible y Lubricantes", "lts/kg");
    }

    @Override
    public String getTipo() {
        return "Clase III";
    }
}