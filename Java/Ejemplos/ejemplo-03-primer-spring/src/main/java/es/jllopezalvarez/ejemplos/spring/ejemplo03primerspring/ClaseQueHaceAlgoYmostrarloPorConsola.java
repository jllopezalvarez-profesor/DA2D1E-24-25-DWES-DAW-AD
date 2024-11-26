package es.jllopezalvarez.ejemplos.spring.ejemplo03primerspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClaseQueHaceAlgoYmostrarloPorConsola implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Estoy en el engendro de clase que ha creado JL");
    }
}
