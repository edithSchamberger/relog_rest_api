package ar.edu.undef.fie.relog_rest_api.interfaces.request;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.EstadoAbastecimiento;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Movimiento;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class EstadoAbastecimientoRequest {
    private Long cantidadNecesaria;
    private Long cantidadDisponible;


    public EstadoAbastecimientoRequest() {
    }

    public EstadoAbastecimientoRequest(Long cantidadNecesaria, Long cantidadDisponible, Long idOrg){
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Long getCantidadNecesaria() {
        return cantidadNecesaria;
    }

    public void setCantidadNecesaria(Long cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public Long getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Long cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }


}
