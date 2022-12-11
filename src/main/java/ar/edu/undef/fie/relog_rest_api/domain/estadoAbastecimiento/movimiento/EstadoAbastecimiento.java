package ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import ar.edu.undef.fie.relog_rest_api.domain.clases.Efecto;
import ar.edu.undef.fie.relog_rest_api.domain.estadoAbastecimiento.movimiento.movimiento.Movimiento;
import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.EfectoResponse;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.EstadoAbastecimientoResponse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class EstadoAbastecimiento {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long estadoAbastecimentoId;
    @ManyToOne
    private Efecto efecto;
    @OneToMany
    private List<Movimiento> movimientos;

    private Long cantidadNecesaria;
    private Long cantidadDisponible;

    public Float porcentajeAbastecimiento;
    @ManyToOne
    private Organizacion organizacion;

  /*  public EstadoAbastecimientoResponse response(){
        return new EstadoAbastecimientoResponse(
                estadoAbastecimentoId,
                efecto,
                movimientos,
                cantidadNecesaria,
                cantidadDisponible,
                porcentajeAbastecimiento,
                organizacion);
    }
*/
  public EstadoAbastecimiento(Efecto efecto, Long cantidadNecesaria, Long cantidadDisponible, Organizacion organizacion) {
      this.efecto = efecto;
      this.movimientos = new ArrayList<>();
      this.cantidadNecesaria = cantidadNecesaria;
      this.cantidadDisponible = cantidadDisponible;
      this.porcentajeAbastecimiento = Float.valueOf(cantidadDisponible*100/cantidadNecesaria);
      this.organizacion = organizacion;
  }
    public EstadoAbastecimiento() {
        this.movimientos = new ArrayList<>();
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }


    //constructor









    public void agregarMovimiento(Movimiento movimiento)
    {
        movimiento.ejecutar(this);
        this.movimientos.add(movimiento);

    }

    public EstadoAbastecimientoResponse response(){
        return new EstadoAbastecimientoResponse (estadoAbastecimentoId,getEfectoOp().map(Efecto:: response).orElse(null),cantidadNecesaria,cantidadDisponible,porcentajeAbastecimiento, getOrganizacionOp().map(Organizacion::response).orElse(null));
    }

    private Optional<Organizacion> getOrganizacionOp() {
        return Optional.ofNullable(this.organizacion);
    }

    public Optional<Efecto> getEfectoOp(){
        return Optional.ofNullable(this.efecto);

    }

    //gettes y setters


    public Long getEstadoAbastecimentoId() {
        return estadoAbastecimentoId;
    }

    public void setEstadoAbastecimentoId(Long estadoAbastecimentoId) {
        this.estadoAbastecimentoId = estadoAbastecimentoId;
    }

    public Efecto getEfecto() {
        return efecto;
    }

    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
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

    public Float getPorcentajeAbastecimiento() {
        return porcentajeAbastecimiento;
    }

    public void setPorcentajeAbastecimiento() {
        this.porcentajeAbastecimiento = Float.valueOf(cantidadDisponible*100 /cantidadNecesaria);
    }



}
