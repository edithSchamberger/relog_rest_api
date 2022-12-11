package ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;
import ar.edu.undef.fie.relog_rest_api.interfaces.request.MovimientoRequest;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.EstadoAbastecimientoResponse;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.MovimientoImpResponse;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.MovimientoResponse;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.RequerimientoResponse;

import javax.persistence.*;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long movimientoId;
    private Long cantidad;

    @OneToOne
    private MovimientoImp movimientoImp;

    //constructor

    public Movimiento() {
    }


    public Movimiento(Long cantidad, MovimientoImp movimientoImp) {
        this.cantidad = cantidad;
        this.movimientoImp = movimientoImp;
    }
    public MovimientoResponse response(){
        return new MovimientoResponse(movimientoId,
                cantidad,
                getMovimientoImpOp().map(MovimientoImp::response).orElse(null));
    }

    public void ejecutar(EstadoAbastecimiento estadoAbastecimiento)
    {
        this.movimientoImp.ejecutar(estadoAbastecimiento, this.cantidad);
    }

    //getters y setters
    public Long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public MovimientoImp getMovimientoImp() {
        return movimientoImp;
    }

    public void setMovimientoImp(MovimientoImp movimientoImp) {
        this.movimientoImp = movimientoImp;
    }

    public Optional<MovimientoImp> getMovimientoImpOp() {
        return Optional.ofNullable(movimientoImp);
    }
}
