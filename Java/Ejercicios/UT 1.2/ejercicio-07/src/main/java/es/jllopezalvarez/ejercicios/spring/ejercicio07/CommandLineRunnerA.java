package es.jllopezalvarez.ejercicios.spring.ejercicio07;

import es.jllopezalvarez.ejercicios.spring.ejercicio07.beans.Counter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerA implements CommandLineRunner {
    private final Counter counter;

    public CommandLineRunnerA(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().getCanonicalName());

        for (int i = 0; i <10; i++) {
            counter.increment();

        }
        System.out.println(counter.getCounter());
        System.out.println(counter);

    }
}
