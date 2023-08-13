package com.vf.dev.msuniversidadnotificaciones.repository;

import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioNotificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioNotificacionRepository extends JpaRepository<UsuarioNotificacionEntity, Integer> {
}
