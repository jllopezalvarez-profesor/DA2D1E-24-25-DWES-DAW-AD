package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Configuración de los mappers de objetos en la aplicación.
 * <p>
 * Esta clase define un {@link ModelMapper} como un bean que se puede utilizar
 * en cualquier parte de la aplicación para mapear objetos de un tipo a otro.
 * {@link ModelMapper} es una librería que facilita la conversión de datos entre
 * distintos objetos, comúnmente utilizada para transformar entidades de base de datos
 * en objetos de negocio o DTOs, y viceversa.
 * </p>
 *
 * <p>El bean definido en esta clase se registra en el contexto global de Spring,
 * por lo que está disponible para cualquier componente que lo necesite.</p>
 */
@Configuration
@Order(1)
public class MapperConfig {
    /**
     * Crea y devuelve una instancia de {@link ModelMapper}.
     *
     * @return una instancia de {@link ModelMapper}.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
