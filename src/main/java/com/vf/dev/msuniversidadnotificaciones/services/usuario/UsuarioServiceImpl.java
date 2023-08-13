package com.vf.dev.msuniversidadnotificaciones.services.usuario;

import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioEntity;
import com.vf.dev.msuniversidadnotificaciones.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public UsuarioEntity findById(Integer pIdUsuario) throws Exception {
        Optional<UsuarioEntity> mUsuarioEntityOptional = this.iUsuarioRepository.findById(pIdUsuario);
        if (mUsuarioEntityOptional.isPresent()) {
            return mUsuarioEntityOptional.get();
        } else {
            throw new Exception("No se enocontro el usaurio con el id: " + pIdUsuario);
        }
    }
}
