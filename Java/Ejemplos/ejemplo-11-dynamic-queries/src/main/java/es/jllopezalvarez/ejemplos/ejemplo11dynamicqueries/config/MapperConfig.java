package es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        // TODO: Configurar el mapeo de Product -> ProductDto, convirtiendo las categorías en nombre de categorías
        return new ModelMapper();
    }
}
