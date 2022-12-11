package ar.edu.undef.fie.relog_rest_api.interfaces.responses;

import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RequerimientoResponse {

    private Long requerimientoId;
    private OrganizacionResponse organizacion;
    private LocalDateTime fechaDeEntregaRequerida;
    private List<SolicitudResponse> solicitudes; // = new ArrayList<>();
    private Boolean confirmado;

    public RequerimientoResponse(Long requerimientoId, OrganizacionResponse organizacion, LocalDateTime fechaDeEntregaRequerida, List<SolicitudResponse> solicitudes, Boolean confirmado) {
        this.requerimientoId = requerimientoId;
        this.organizacion = organizacion;
        this.fechaDeEntregaRequerida = fechaDeEntregaRequerida;
        var solicitudesResponse = new ArrayList<SolicitudResponse>();
        for (var solicitud : solicitudes) {
            solicitudesResponse.add(solicitud.response());
        }
        this.solicitudes = solicitudesResponse;
        this.confirmado = confirmado;
    }

    public Long getRequerimientoId() {
        return requerimientoId;
    }

    public void setRequerimientoId(Long requerimientoId) {
        this.requerimientoId = requerimientoId;
    }

    public OrganizacionResponse getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionResponse organizacion) {
        this.organizacion = organizacion;
    }

    public LocalDateTime getFechaDeEntregaRequerida() {
        return fechaDeEntregaRequerida;
    }

    public void setFechaDeEntregaRequerida(LocalDateTime fechaDeEntregaRequerida) {
        this.fechaDeEntregaRequerida = fechaDeEntregaRequerida;
    }

    public List<SolicitudResponse> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<SolicitudResponse> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }
}