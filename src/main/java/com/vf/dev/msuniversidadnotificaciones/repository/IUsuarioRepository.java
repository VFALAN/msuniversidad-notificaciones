package com.vf.dev.msuniversidadnotificaciones.repository;

import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity , Integer> {
}
