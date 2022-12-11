package ar.edu.undef.fie.relog_rest_api.interfaces.request;

import ar.edu.undef.fie.relog_rest_api.domain.organizacion.Organizacion;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Requerimiento;
import ar.edu.undef.fie.relog_rest_api.domain.requerimiento.Solicitud;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RequerimientoRequest {
    private Long orgId;
    private LocalDateTime fechaDeEntregaRequerida;
    //private List<Long> idSolicitudes;
    private List<Long> idSolicitudes;

    public RequerimientoRequest() {
        this.idSolicitudes = new ArrayList<>();
    }



    public RequerimientoRequest(Long orgId, LocalDateTime fechaDeEntregaRequerida, List<Long> idSolicitudes) {
        this.orgId = orgId;
        this.fechaDeEntregaRequerida = fechaDeEntregaRequerida;
        this.idSolicitudes = idSolicitudes;
    }


    public Long getOrgId() {
        return orgId;
    }

    public LocalDateTime getFechaDeEntregaRequerida() {
        return fechaDeEntregaRequerida;
    }


    public List<Long> getIdSolicitudes() {
        return idSolicitudes;
    }
}
