package ar.edu.undef.fie.relog_rest_api.interfaces.responses;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;

public class EfectoResponse {
    private Long efectoId;
    private String nombreEfecto;
    private ClaseResponse clase;

    public EfectoResponse(Long efectoId, String nombreEfecto, ClaseResponse clase) {
        this.efectoId = efectoId;
        this.nombreEfecto = nombreEfecto;
        this.clase = clase;
    }

    public Long getEfectoId() {
        return efectoId;
    }

    public void setEfectoId(Long efectoId) {
        this.efectoId = efectoId;
    }

    public String getNombreEfecto() {
        return nombreEfecto;
    }

    public void setNombreEfecto(String nombreEfecto) {
        this.nombreEfecto = nombreEfecto;
    }

    public ClaseResponse getClase() {
        return clase;
    }

    public void setClase(ClaseResponse clase) {
        this.clase = clase;
    }



}
