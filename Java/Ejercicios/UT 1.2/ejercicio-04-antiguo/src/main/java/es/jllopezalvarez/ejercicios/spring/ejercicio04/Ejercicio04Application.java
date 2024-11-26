package es.jllopezalvarez.ejercicios.spring.ejercicio04;

import es.jllopezalvarez.ejercicios.spring.ejercicio04.beans.PrimerBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Ejercicio04Application {

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio04Application.class, args);
        //new PrimerBean().hazAlgo();

    }

}
