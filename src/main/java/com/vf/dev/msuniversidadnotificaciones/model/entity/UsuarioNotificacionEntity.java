package com.vf.dev.msuniversidadnotificaciones.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "USAURIO_NOTIFICACION")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioNotificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO_NOTIFICACION")
    private Integer idUsuarioNotificacion;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "ID_NOTIFICACION")
    private NotificacionEntity notificacion;
}
