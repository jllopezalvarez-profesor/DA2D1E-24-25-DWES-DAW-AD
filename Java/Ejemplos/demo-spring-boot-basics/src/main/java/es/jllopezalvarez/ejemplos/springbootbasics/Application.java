package es.jllopezalvarez.ejemplos.springbootbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("Aplicación para ejemplos Spring Boot");
        SpringApplication.run(Application.class, args);

    }

}
