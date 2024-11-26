package es.jllopezalvarez.ejercicios.spring.ejercicio05;

import es.jllopezalvarez.ejercicios.spring.ejercicio05.commandlinerunners.services.MessageService;
import es.jllopezalvarez.ejercicios.spring.ejercicio05.commandlinerunners.services.SystemOutMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }

}
