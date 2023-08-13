package com.vf.dev.msuniversidadnotificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vf.*")
public class MsuniversidadNotificacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsuniversidadNotificacionesApplication.class, args);
	}

}
