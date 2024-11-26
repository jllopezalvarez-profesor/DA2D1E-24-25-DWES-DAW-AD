package es.jllopezalvarez.ejercicios.spring.ejericio06;

import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejericio06Application {

    public static void main(String[] args) {
        SpringApplication.run(Ejericio06Application.class, args);
    }

    @Bean
    public Faker getDataFaker(){
        return new Faker();
    }

}
