package es.jllopezalvarez.ejercicios.spring.ejercicio07;

import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerB implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().getCanonicalName());
    }
}
