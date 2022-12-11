package ar.edu.undef.fie.relog_rest_api.interfaces.responses;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrganizacionResponse {
    private Long organizacionId;
    private String nombre;
    private Double efectivoOrganico;
    private Double latitud;
    private Double longitud;
    private List<EstadoAbastecimientoResponse> estadoAbastecimientos;

    public OrganizacionResponse(Long organizacionId, String nombre, Double efectivoOrganico, Double latitud, Double longitud, List<EstadoAbastecimientoResponse> estadoAbastecimientos) {
        this.organizacionId = organizacionId;
        this.nombre = nombre;
        this.efectivoOrganico = efectivoOrganico;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estadoAbastecimientos = estadoAbastecimientos;
    }


    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getEfectivoOrganico() {
        return efectivoOrganico;
    }

    public void setEfectivoOrganico(Double efectivoOrganico) {
        this.efectivoOrganico = efectivoOrganico;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public List<EstadoAbastecimientoResponse> getEstadoAbastecimientos() {
        return estadoAbastecimientos;
    }

    public void setEstadoAbastecimientos(List<EstadoAbastecimientoResponse> estadoAbastecimientos) {
        this.estadoAbastecimientos = estadoAbastecimientos;
    }
}
