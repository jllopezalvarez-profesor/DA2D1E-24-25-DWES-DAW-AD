package es.jllopezalvarez.ejercicios.spring.ejercicio04.commandlinerunners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class ProcesoB implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().getCanonicalName());
    }
}
