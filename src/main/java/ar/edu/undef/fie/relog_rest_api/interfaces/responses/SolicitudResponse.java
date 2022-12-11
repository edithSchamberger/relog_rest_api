package ar.edu.undef.fie.relog_rest_api.interfaces.responses;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;

import javax.persistence.OneToOne;

public class SolicitudResponse {
    private Long solicitudId;
    private Long cantidad;

    //private Long requerimientoId;
    private EfectoResponse efecto;


    public SolicitudResponse(Long solicitudId, Long cantidad, EfectoResponse efecto) {
        this.solicitudId = solicitudId;
        this.cantidad = cantidad;
        this.efecto = efecto;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public EfectoResponse getEfecto() {
        return efecto;
    }

    public void setEfecto(EfectoResponse efecto) {
        this.efecto = efecto;
    }

    public SolicitudResponse response() {
        return new SolicitudResponse(
                solicitudId,
                cantidad,
                efecto);
    }

}

