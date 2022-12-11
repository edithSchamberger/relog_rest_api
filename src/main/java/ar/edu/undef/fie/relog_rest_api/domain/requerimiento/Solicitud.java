package ar.edu.undef.fie.relog_rest_api.domain.requerimiento;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.SolicitudResponse;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long solicitudId;

    private Long cantidad;
    @OneToOne
    private Efecto efecto;

    //constructor
    public Solicitud(Long cantidad, Optional<Efecto> byId) {
    }

    public Solicitud(Long cantidad, Efecto efecto) {
        this.cantidad = cantidad;
        this.efecto = efecto;
    }

    public Solicitud() {

    }
    public Optional<Efecto> getEfectoOp() {
        return Optional.ofNullable(efecto);
    }

    public SolicitudResponse response(){
        return new SolicitudResponse(solicitudId,cantidad,efecto.response());
    }

    //getters y setters
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

    public Efecto getEfecto() {
        return efecto;
    }

    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
    }
}
