package es.jllopezalvarez.ejercicios.spring.ejercicio04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Comparator;

@Configuration

public class Configuracion {
    @Bean
    @Primary
    public Comparator<String> getComparadorPorLongitud() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
    }

    @Bean
    public Comparator<String> getComparadorInverso() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compare(o2, o1);
            }
        };
    }




}

