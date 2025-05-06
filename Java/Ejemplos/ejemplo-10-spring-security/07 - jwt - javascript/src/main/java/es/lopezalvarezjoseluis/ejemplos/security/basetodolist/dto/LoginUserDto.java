package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO (Data Transfer Object) que representa la información necesaria para iniciar sesión de un usuario.
 * <p>
 * Esta clase es utilizada para recibir los datos de inicio de sesión desde una solicitud de autenticación,
 * generalmente a través de una petición POST que contiene las credenciales del usuario.
 * </p>
 *
 * <p>Los atributos de esta clase son:</p>
 * <ul>
 *     <li>{@code email}: La dirección de correo electrónico del usuario, utilizada para identificar al usuario en el sistema.</li>
 *     <li>{@code password}: La contraseña del usuario, que será validada durante el proceso de autenticación.</li>
 * </ul>
 */
@Getter
@Setter
public class LoginUserDto {
    private String email;
    private String password;
}
