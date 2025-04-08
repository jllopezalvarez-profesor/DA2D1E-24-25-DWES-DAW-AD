package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
