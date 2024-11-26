package es.jllopezalvarez.ejercicios.spring.ejercicio04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication

// Esto se puede hacer si hay que añadir paquetes que no están en el mismo paquete de la app
// @ComponentScans({ @ComponentScan( "es.jllopezalvarez.ejercicios.spring.commandlinerunners")})
public class App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);


	}

}
