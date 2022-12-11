package ar.edu.undef.fie.relog_rest_api.interfaces.request;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;

import javax.persistence.OneToOne;
import java.util.stream.Collectors;

public class SolicitudRequest {

    private Long cantidad;
    private Long efectoId;


    public Long getCantidad() {
        return cantidad;
    }



    public Long getEfectoId() {
        return efectoId;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public void setEfectoId(Long efectoId) {
        this.efectoId = efectoId;
    }

}
