package ar.edu.undef.fie.relog_rest_api.domain.organizacion;

import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.OrganizacionResponse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Entity
public class Organizacion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long organizacionId;

    private String nombre;

    private Double efectivoOrganico;
    private Double latitud;
    private Double longitud;

    @OneToMany
    private List<EstadoAbastecimiento> estadoAbastecimientos;

    public Organizacion() {
        this.estadoAbastecimientos = new ArrayList<>();
    }


//constructor


    public Organizacion(String nombre, Double efectivoOrganico, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.efectivoOrganico = efectivoOrganico;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estadoAbastecimientos = new ArrayList<EstadoAbastecimiento>();
    }

    public OrganizacionResponse response(){
        return new OrganizacionResponse(organizacionId,nombre,efectivoOrganico,latitud,longitud, estadoAbastecimientos.stream().map(EstadoAbastecimiento::response).collect(Collectors.toList()));
    }





//setters y gettes


    public Long getOrganizacionId() {
        return organizacionId;
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

    public List<EstadoAbastecimiento> getEstadoAbastecimientos() {
        return estadoAbastecimientos;
    }

    public void setEstadoAbastecimientos(List<EstadoAbastecimiento> estadoAbastecimientos) {
        this.estadoAbastecimientos = estadoAbastecimientos;
    }

}

