package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO (Data Transfer Object) que representa la información necesaria para registrar un nuevo usuario en el sistema.
 * <p>
 * Esta clase es utilizada para recibir los datos de registro desde una solicitud de creación de usuario,
 * generalmente a través de una petición POST que contiene los detalles del nuevo usuario.
 * </p>
 *
 * <p>Los atributos de esta clase son:</p>
 * <ul>
 *     <li>{@code firstName}: El primer nombre del usuario.</li>
 *     <li>{@code lastName}: El apellido del usuario.</li>
 *     <li>{@code email}: La dirección de correo electrónico del usuario, que será utilizada para la autenticación.</li>
 *     <li>{@code password}: La contraseña del usuario, que se almacenará de forma segura después de ser cifrada.</li>
 * </ul>
 */
@Getter
@Setter
@Builder
public class RegisterUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
