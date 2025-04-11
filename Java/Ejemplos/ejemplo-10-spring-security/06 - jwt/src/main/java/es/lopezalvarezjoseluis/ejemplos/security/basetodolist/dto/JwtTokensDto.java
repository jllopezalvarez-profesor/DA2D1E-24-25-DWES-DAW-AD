package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * DTO (Data Transfer Object) que encapsula los tokens JWT emitidos durante el proceso de autenticación.
 * <p>
 * Esta clase se utiliza para enviar tanto el token de acceso como el token de refresco al cliente.
 * Los tokens son cadenas codificadas que representan la identidad del usuario y sus permisos,
 * y se utilizan para autorizar peticiones a la API sin necesidad de mantener una sesión en el servidor.
 * </p>
 *
 * <p>Los atributos de esta clase son:</p>
 * <ul>
 *     <li>{@code accessToken}: Token JWT de acceso, con validez limitada, usado para autenticar peticiones.</li>
 *     <li>{@code refreshToken}: Token JWT de refresco, utilizado para obtener un nuevo token de acceso cuando este expira.</li>
 * </ul>
 */
@Getter
@Setter
@Builder
public class JwtTokensDto {
    private String accessToken;
    private String refreshToken;
}
