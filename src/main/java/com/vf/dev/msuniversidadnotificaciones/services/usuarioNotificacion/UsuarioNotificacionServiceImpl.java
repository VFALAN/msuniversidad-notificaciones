package com.vf.dev.msuniversidadnotificaciones.services.usuarioNotificacion;

import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioNotificacionEntity;
import com.vf.dev.msuniversidadnotificaciones.repository.IUsuarioNotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioNotificacionServiceImpl implements IUsuarioNotificacionService {
    @Autowired
    private IUsuarioNotificacionRepository iUsuarioNotificacionRepository;

    @Override
    public UsuarioNotificacionEntity save(UsuarioNotificacionEntity pUsuarioNotificacionEntity) {
        return this.iUsuarioNotificacionRepository.save(pUsuarioNotificacionEntity);
    }

    @Override
    public void saveAll(List<UsuarioNotificacionEntity> pUsuarioNotificacionEntityList) {
        this.iUsuarioNotificacionRepository.saveAll(pUsuarioNotificacionEntityList);
    }
}
