package ar.edu.undef.fie.relog_rest_api.domain.clases;

import ar.edu.undef.fie.relog_rest_api.interfaces.responses.ClaseResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claseId;
    private String abreviatura;
    private String descripcionTipo; //puede ser "Racionamiento", "vestuario y equipo" o "Combustible y lubricante" /desayuno nombre de la clases
    private String unidadMedida;  //puede ser "litros", "kilos" o "unidades"

    //constructor
    public Clase(String abreviatura, String descripcionTipo, String unidadMedida) {
        this.abreviatura = abreviatura;
        this.descripcionTipo = descripcionTipo;
        this.unidadMedida = unidadMedida;
    }

    public Clase() {

    }
    public abstract String getTipo();

    public final ClaseResponse response() {
        return new ClaseResponse(
                getClaseId(),
                getAbreviatura(),
                getDescripcionTipo(),
                getUnidadMedida()
        );
    }


    //getters y setters
    public Long getClaseId() {
        return claseId;
    }

    public void setClaseId(Long claseId) {
        this.claseId = claseId;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }



}