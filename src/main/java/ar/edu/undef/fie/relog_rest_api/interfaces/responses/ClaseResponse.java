package ar.edu.undef.fie.relog_rest_api.interfaces.responses;

public class ClaseResponse {
    private Long claseId;
    private String abreviatura;
    private String descripcionTipo;
    private String unidadMedida;

    public ClaseResponse(Long claseId, String abreviatura, String descripcionTipo, String unidadMedida) {
        this.claseId = claseId;
        this.abreviatura = abreviatura;
        this.descripcionTipo = descripcionTipo;
        this.unidadMedida = unidadMedida;
    }

    public Long getClaseId() {
        return claseId;
    }

    public void setClaseId(Long claseId) {
        this.claseId = claseId;
    }

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
