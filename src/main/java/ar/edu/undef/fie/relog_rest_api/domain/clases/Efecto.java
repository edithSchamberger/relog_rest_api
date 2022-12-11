package ar.edu.undef.fie.relog_rest_api.domain.clases;

import ar.edu.undef.fie.relog_rest_api.interfaces.responses.EfectoResponse;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Efecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long efectoId;
    private String nombreEfecto;
   //un Efecto tiene una clase, pero un clase puede estar asociada a muchas classr
    //muchos efectos asociados a un efecto
    @ManyToOne
    private Clase clase;

    // tengo que crear un constructor, pero si tengo otra entidad, tiene que tener un metodo respose
    public EfectoResponse response(){
       return new EfectoResponse(
               efectoId,
               nombreEfecto,
               getClaseOp()
                       .map(Clase::response)
                       .orElse(null)
       );
    }

    public Optional<Clase> getClaseOp() {
        return Optional.ofNullable(clase);
    }


    // constructor
    public Efecto() {
    }

    public Efecto(String nombreEfecto) {
        this.nombreEfecto = nombreEfecto;
    }


    //gettes y setters

    public Long getEfectoId() {
        return efectoId;
    }

    public void setEfectoId(Long efectoId) {
        this.efectoId = efectoId;
    }

    public String getNombreEfecto() {
        return nombreEfecto;
    }

    public void setNombreEfecto(String nombreEfecto) {
        this.nombreEfecto = nombreEfecto;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}

