package es.jllopezalvarez.ejemplos.springbootbasics.config;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
