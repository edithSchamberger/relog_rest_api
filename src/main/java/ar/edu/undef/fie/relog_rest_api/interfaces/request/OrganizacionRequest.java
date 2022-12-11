package ar.edu.undef.fie.relog_rest_api.interfaces.request;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizacionRequest {
    private String nombre;
    private Double efectivoOrganico;
    private Double latitud;
    private Double longitud;


    public OrganizacionRequest(String nombre, Double efectivoOrganico, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.efectivoOrganico = efectivoOrganico;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getEfectivoOrganico() {
        return efectivoOrganico;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }



}
