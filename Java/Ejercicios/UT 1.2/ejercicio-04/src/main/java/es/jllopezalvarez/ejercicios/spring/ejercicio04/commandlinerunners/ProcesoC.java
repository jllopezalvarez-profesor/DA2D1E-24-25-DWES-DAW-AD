package es.jllopezalvarez.ejercicios.spring.ejercicio04.commandlinerunners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ProcesoC implements CommandLineRunner, Ordered {
    @Override
    public void run(String[] args) throws Exception {
        System.out.println(this.getClass().getCanonicalName());
    }

    @Override
    public int getOrder() {
        return 200;
    }
}
