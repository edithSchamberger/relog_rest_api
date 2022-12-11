package ar.edu.undef.fie.relog_rest_api.interfaces.responses;

public class MovimientoImpResponse {
    private Long movimientoId;
    private String descripcion;

    public MovimientoImpResponse(Long movimientoId, String descripcion) {
        this.movimientoId = movimientoId;
        this.descripcion = descripcion;
    }

    public Long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
