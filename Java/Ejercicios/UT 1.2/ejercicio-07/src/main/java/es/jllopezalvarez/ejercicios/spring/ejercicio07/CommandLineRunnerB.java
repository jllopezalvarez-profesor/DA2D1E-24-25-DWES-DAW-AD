package es.jllopezalvarez.ejercicios.spring.ejercicio07;

import es.jllopezalvarez.ejercicios.spring.ejercicio07.beans.Counter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerB implements CommandLineRunner {
    private final Counter counter;

    public CommandLineRunnerB(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().getCanonicalName());

        counter.increment();
        System.out.println(counter.getCounter());
        counter.increment();
        System.out.println(counter.getCounter());
        System.out.println(counter);

    }
}
