package com.vf.dev.msuniversidadnotificaciones.services.usuarioNotificacion;

import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioNotificacionEntity;

import java.util.List;

public interface IUsuarioNotificacionService {

    UsuarioNotificacionEntity save(UsuarioNotificacionEntity pUsuarioNotificacionEntity);

    void saveAll(List<UsuarioNotificacionEntity> pUsuarioNotificacionEntityList);
}
