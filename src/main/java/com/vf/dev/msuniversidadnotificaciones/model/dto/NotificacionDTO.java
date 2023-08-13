package com.vf.dev.msuniversidadnotificaciones.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificacionDTO implements Serializable {
    @JsonProperty
    private Integer idNotificacion;
    @JsonProperty
    private Boolean leida;
    @JsonProperty
    private String titulo;
    @JsonProperty
    private String mensaje;
    @JsonProperty
    private Boolean redireccion;
    @JsonProperty
    private String url;
    @JsonProperty
    private Date fechaAlta;
}
