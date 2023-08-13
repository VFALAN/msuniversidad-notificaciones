package com.vf.dev.msuniversidadnotificaciones.controller;

import com.vf.dev.msuniversidadnotificaciones.model.dto.NotificacionDTO;
import com.vf.dev.msuniversidadnotificaciones.model.dto.NotificacionRequestDTO;
import com.vf.dev.msuniversidadnotificaciones.services.notification.IServiceNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*")
@Slf4j
public class NotificacionController {
    @Autowired
    private IServiceNotification iServiceNotification;

    @PostMapping("/notificarUsuario")
    public void notificarAltaUsuario(@RequestBody NotificacionRequestDTO pNotificacion) throws Exception {
        this.iServiceNotification.notificarUsuario(pNotificacion);
    }

    @MessageMapping("/classNotification")
    @SendTo("topic/classNotification/{idClass}")
    public String messageToClass(@PathVariable("idClass") Integer idClass, String message) {
        return message;
    }

    @GetMapping("/getNotifications")
    public ResponseEntity<?> obtenerNotiifcaciones(@RequestParam("idUsuario") Integer pIdUsuario) throws Exception {
        List<NotificacionDTO> mStringList = this.iServiceNotification.obtenerNotificaciones(pIdUsuario);
        return new ResponseEntity<List<NotificacionDTO>>(mStringList, HttpStatus.OK);
    }

    @PutMapping("/changeState/{idNotificacion}")
    public ResponseEntity<?> changeState(@PathVariable Integer idNotificacion) {
        return null;
    }

}
