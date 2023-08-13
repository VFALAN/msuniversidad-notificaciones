package com.vf.dev.msuniversidadnotificaciones.services.usuario;

import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioEntity;

public interface IUsuarioService {
    UsuarioEntity findById(Integer pIdUsuario) throws Exception;
}
