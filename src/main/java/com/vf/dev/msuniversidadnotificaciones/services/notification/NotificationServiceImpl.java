package com.vf.dev.msuniversidadnotificaciones.services.notification;

import com.vf.dev.msuniversidadnotificaciones.model.dto.NotificacionDTO;
import com.vf.dev.msuniversidadnotificaciones.model.dto.NotificacionRequestDTO;
import com.vf.dev.msuniversidadnotificaciones.model.entity.NotificacionEntity;
import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioEntity;
import com.vf.dev.msuniversidadnotificaciones.model.entity.UsuarioNotificacionEntity;
import com.vf.dev.msuniversidadnotificaciones.repository.INotificacionRepository;
import com.vf.dev.msuniversidadnotificaciones.services.usuario.IUsuarioService;
import com.vf.dev.msuniversidadnotificaciones.services.usuarioNotificacion.IUsuarioNotificacionService;
import com.vf.dev.msuniversidadnotificaciones.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class NotificationServiceImpl implements IServiceNotification {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private final String URL_BASE = "/topic";

    @Autowired
    private IUsuarioNotificacionService iUsuarioNotificacionService;
    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private INotificacionRepository iNotificacionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void notificarUsuario(NotificacionRequestDTO pNotificacionRequestDTO) throws Exception {
        String mStrTopic = URL_BASE + "/" + pNotificacionRequestDTO.getTopic() + "/" + pNotificacionRequestDTO.getIdUsuario().toString();
        log.info("Notificando el topico {}", mStrTopic);
        NotificacionDTO mNotificacionDTO = this.almacenarNotificacion(pNotificacionRequestDTO);
        this.simpMessagingTemplate.convertAndSend(mStrTopic, mNotificacionDTO);
    }

    @Override
    public void notificarAllUsuarios(String topic, List<Integer> idUsuariosList, String body) {
        if (idUsuariosList != null && !idUsuariosList.isEmpty()) {
            idUsuariosList.forEach(u -> {
                try {
                    //         this.notificarUsuario(topic, u, body);
                } catch (Exception e) {
                    log.info(e.getMessage());
                }
            });
        }
    }

    @Override
    public void notificacionGeneral(String topic, String body) {
        String mStrTopic = URL_BASE + "/" + topic;
        this.simpMessagingTemplate.convertAndSend(mStrTopic, body);
    }

    @Override
    public List<NotificacionDTO> obtenerNotificaciones(Integer idUsuario) throws Exception {
        List<NotificacionDTO> mNotificationBodyList = new ArrayList<>();
        UsuarioEntity mUsuarioEntity = this.iUsuarioService.findById(idUsuario);
        List<NotificacionEntity> mNotificacionEntityList = this.iNotificacionRepository.obtenerNoptificaciones(mUsuarioEntity);
        if (mNotificacionEntityList != null && !mNotificacionEntityList.isEmpty()) {
            mNotificacionEntityList.forEach(n -> {
                mNotificationBodyList.add(NotificacionDTO.builder()
                        .idNotificacion(n.getIdNotificacion())
                        .titulo(n.getTitulo())
                        .mensaje(n.getMensaje())
                        .fechaAlta(n.getFechaAlta())
                        .redireccion(n.getRedireccion())
                        .url(n.getUrl())
                        .leida(n.getLeida())
                        .build());
            });
        }
        return mNotificationBodyList;
    }


    private NotificacionDTO almacenarNotificacion(NotificacionRequestDTO pNotificacionRequestDTO) throws Exception {
        UsuarioEntity mUsuarioEntity = this.iUsuarioService.findById(pNotificacionRequestDTO.getIdUsuario());
        NotificacionEntity mNotificacionEntity = this.modelMapper.map(pNotificacionRequestDTO, NotificacionEntity.class);
        mNotificacionEntity.setIdNotificacion(null);
        mNotificacionEntity.setFechaAlta(new Date());
        mNotificacionEntity.setIndActivo(true);
        mNotificacionEntity = this.iNotificacionRepository.save(mNotificacionEntity);
        UsuarioNotificacionEntity mUsuarioNotificacionEntity = UsuarioNotificacionEntity
                .builder().
                usuario(mUsuarioEntity).
                notificacion(mNotificacionEntity).
                build();
        mUsuarioNotificacionEntity = this.iUsuarioNotificacionService.save(mUsuarioNotificacionEntity);
        NotificacionDTO m = this.modelMapper.map(mNotificacionEntity, NotificacionDTO.class);

        return m;
    }
}
