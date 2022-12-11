package ar.edu.undef.fie.relog_rest_api.interfaces.request;

public class ClaseRequest {

    private String abreviatura;
    private String descripcionTipo; //puede ser "Racionamiento", "vestuario y equipo" o "Combustible y lubricante" /desayuno nombre de la clases
    private String unidadMedida;

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
