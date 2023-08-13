package com.vf.dev.msuniversidadnotificaciones.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "NOTIFICACIONES")
@Entity
@Setter
public class NotificacionEntity extends GenericTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NOTIFCACION")
    private Integer idNotificacion;
    @Column(name = "LEIDA")
    private Boolean leida;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "MENSAJE")
    private String mensaje;
    @Column(name = "REDIRECCION")
    private Boolean redireccion;
    @Column(name = "URL")
    private String url;
    @OneToMany(mappedBy = "notificacion")
    private List<UsuarioNotificacionEntity> usuarioNotificacionEntityList;

}
