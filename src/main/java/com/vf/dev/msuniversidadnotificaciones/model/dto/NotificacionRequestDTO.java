package com.vf.dev.msuniversidadnotificaciones.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacionRequestDTO implements Serializable {

    @JsonProperty
    private Integer idUsuario;
    @JsonProperty
    private String topic;
    @JsonProperty
    private String titulo;
    @JsonProperty
    private String mensaje;
    @JsonProperty
    private String fecha;
    @JsonProperty
    private Boolean redireccion;
    @JsonProperty
    private String url;
}
