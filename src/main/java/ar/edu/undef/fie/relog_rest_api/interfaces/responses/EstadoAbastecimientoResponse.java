package ar.edu.undef.fie.relog_rest_api.interfaces.responses;

import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;

public class EstadoAbastecimientoResponse {

    private Long estadoAbastecimentoId;

    private EfectoResponse efecto;

    private Long cantidadNecesaria;
    private Long cantidadDisponible;

    public Float porcentajeAbastecimiento;
    private OrganizacionResponse organizacion;


    public EstadoAbastecimientoResponse(Long estadoAbastecimentoId, EfectoResponse efecto, Long cantidadNecesaria, Long cantidadDisponible, Float porcentajeAbastecimiento, OrganizacionResponse organizacion) {
        this.estadoAbastecimentoId = estadoAbastecimentoId;
        this.efecto = efecto;
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadDisponible = cantidadDisponible;
        this.porcentajeAbastecimiento = porcentajeAbastecimiento;
        this.organizacion = organizacion;
    }

    public Long getEstadoAbastecimentoId() {
        return estadoAbastecimentoId;
    }

    public void setEstadoAbastecimentoId(Long estadoAbastecimentoId) {
        this.estadoAbastecimentoId = estadoAbastecimentoId;
    }

    public EfectoResponse getEfecto() {
        return efecto;
    }

    public void setEfecto(EfectoResponse efecto) {
        this.efecto = efecto;
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
        this.porcentajeAbastecimiento =Float.valueOf(cantidadDisponible*100/cantidadNecesaria);
    }

    public void setPorcentajeAbastecimiento(Float porcentajeAbastecimiento) {
        this.porcentajeAbastecimiento = porcentajeAbastecimiento;
    }

    public OrganizacionResponse getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionResponse organizacion) {
        this.organizacion = organizacion;
    }

}
