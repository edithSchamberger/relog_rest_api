package ar.edu.undef.fie.relog_rest_api.domain.requerimiento;

import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.RequerimientoResponse;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
public class Requerimiento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long requerimientoId;

    @ManyToOne
    private Organizacion organizacion;
    private LocalDateTime fechaDeEntregaRequerida;

    @OneToMany
    private List<Solicitud> solicitudes; // = new ArrayList<>();

    private Boolean confirmado;


   //constructor
    public Requerimiento(Organizacion organizacion, LocalDateTime fechaDeEntregaRequerida, List<Solicitud> solicitudes ) {
        this.organizacion = organizacion;
        this.fechaDeEntregaRequerida = fechaDeEntregaRequerida;
        this.solicitudes = solicitudes;
        this.confirmado = false;
    }

    public Requerimiento() {
        this.solicitudes = new ArrayList<>();
    }


    public RequerimientoResponse response(){
        return new RequerimientoResponse(requerimientoId,
                getOrganizacionOp().map(Organizacion::response).orElse(null),
                fechaDeEntregaRequerida,
                solicitudes.stream().map(Solicitud::response).collect(Collectors.toList()),
                confirmado);
    }


    //getters y setters
    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Long getRequerimientoId() {
        return requerimientoId;
    }

    public void setRequerimientoId(Long requerimientoId) {
        this.requerimientoId = requerimientoId;
    }

    public LocalDateTime getFechaDeEntregaRequerida() {
        return fechaDeEntregaRequerida;
    }

    public void setFechaDeEntregaRequerida(LocalDateTime fechaDeEntregaRequerida) {
        this.fechaDeEntregaRequerida = fechaDeEntregaRequerida;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }
    public Optional<Organizacion> getOrganizacionOp() {
        return Optional.ofNullable(organizacion);
    }



}
