package ar.edu.undef.fie.relog_rest_api.interfaces.request;

public class MovimientoRequest {

    private Long estadoAbastecimientoId;

    private Long efectoId;

    private Long cantidad;

    public MovimientoRequest(Long estadoAbastecimientoId, Long efectoId, Long cantidad) {
        this.estadoAbastecimientoId = estadoAbastecimientoId;
        this.efectoId = efectoId;
        this.cantidad = cantidad;
    }

    public Long getEstadoAbastecimientoId() {
        return estadoAbastecimientoId;
    }

    public void setEstadoAbastecimientoId(Long organizaionId) {
        this.estadoAbastecimientoId = organizaionId;
    }

    public Long getEfectoId() {
        return efectoId;
    }

    public void setEfectoId(Long efectoId) {
        this.efectoId = efectoId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
