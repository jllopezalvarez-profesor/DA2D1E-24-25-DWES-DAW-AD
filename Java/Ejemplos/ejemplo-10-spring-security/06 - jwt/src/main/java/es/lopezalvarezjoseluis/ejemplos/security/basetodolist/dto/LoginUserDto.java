package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserDto {
    private String email;
    private String password;
}
