package es.jllopezalvarez.ejemplos.springbootbasics.dto.sessions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterUserDto {
    private String email;
    private String password;
    private String name;
    private String lastName;
    private Boolean userAcceptsTermsOfUse;
}
