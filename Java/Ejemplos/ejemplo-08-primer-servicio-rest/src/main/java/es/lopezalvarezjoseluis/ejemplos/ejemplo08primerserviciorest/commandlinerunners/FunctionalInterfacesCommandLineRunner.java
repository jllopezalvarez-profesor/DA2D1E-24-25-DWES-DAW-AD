package es.lopezalvarezjoseluis.ejemplos.ejemplo08primerserviciorest.commandlinerunners;

import es.lopezalvarezjoseluis.ejemplos.ejemplo08primerserviciorest.utils.CustomLongComparator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

@Component
public class FunctionalInterfacesCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        List<Long> numeros = new ArrayList<>(LongStream.generate(() -> random.nextLong(0, 1000)).limit(10).boxed().toList());
//        List<Long> numeros = new ArrayList<>(LongStream.generate(random::nextLong).limit(10).boxed().toList());
        System.out.println(numeros);

        numeros.sort(new CustomLongComparator());

        System.out.println(numeros);

        numeros.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o1 % 10, o2 % 10);
            }
        });

        System.out.println(numeros);

        numeros.sort((o1, o2) -> {
            return Long.compare(o2 % 10, o1 % 10);
        });

        System.out.println(numeros);

        numeros.sort((o1, o2) -> Long.compare(o1 % 10, o2 % 10));

        System.out.println(numeros);

        numeros.forEach(numero -> System.out.println(numero));
        System.out.println("----");
        numeros.forEach(System.out::println);

        numeros.stream().map(num -> num % 10).forEach(System.out::println);
        System.out.println(numeros);

    }
}
