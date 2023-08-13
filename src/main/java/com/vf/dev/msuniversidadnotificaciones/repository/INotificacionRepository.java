package com.vf.dev.msuniversidadnotificaciones.repository;

import com.vf.dev.msuniversidadnotificaciones.model.entity.NotificacionEntity;
import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<NotificacionEntity, Integer> {

@Query("SELECT n FROM NotificacionEntity n JOIN n.usuarioNotificacionEntityList u where u.usuario = :idUsuario order by n.fechaAlta desc")
    List<NotificacionEntity> obtenerNoptificaciones(@Param("idUsuario") UsuarioEntity pUsuario);
}
