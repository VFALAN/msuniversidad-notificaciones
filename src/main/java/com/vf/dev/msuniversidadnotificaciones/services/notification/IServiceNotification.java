package com.vf.dev.msuniversidadnotificaciones.services.notification;

import com.vf.dev.msuniversidadnotificaciones.model.dto.NotificacionDTO;
import com.vf.dev.msuniversidadnotificaciones.model.dto.NotificacionRequestDTO;
import org.apache.hc.client5.http.entity.mime.StringBody;

import java.util.List;

public interface IServiceNotification {

    void notificarUsuario(NotificacionRequestDTO pNotificacionRequestDTO) throws Exception;

    void notificarAllUsuarios(String topic, List<Integer> idUsuariosList, String body);

    void notificacionGeneral(String topic, String body);

    List<NotificacionDTO> obtenerNotificaciones(Integer idUsuario) throws Exception;
}
