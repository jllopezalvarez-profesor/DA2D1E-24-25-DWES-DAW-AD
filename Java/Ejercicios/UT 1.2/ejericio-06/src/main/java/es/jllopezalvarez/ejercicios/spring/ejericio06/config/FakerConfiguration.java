package es.jllopezalvarez.ejercicios.spring.ejericio06.config;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerConfiguration {
    @Bean
    public Faker getDataFaker() {
        return new Faker();
    }
}
