package ar.edu.undef.fie.relog_rest_api.interfaces.responses;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.MovimientoImp;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.MovimientoRequest;

import javax.persistence.OneToOne;

public class MovimientoResponse {
    private Long movimientoId;
    private Long cantidad;
    private MovimientoImpResponse movimientoImpResponse;

    public MovimientoResponse(Long movimientoId, Long cantidad, MovimientoImpResponse movimientoImpResponse) {
        this.movimientoId = movimientoId;
        this.cantidad = cantidad;
        this.movimientoImpResponse = movimientoImpResponse;
    }

    public Long getMovimientoId() {
        return movimientoId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public MovimientoImpResponse getMovimientoImpResponse() {
        return movimientoImpResponse;
    }
}
