package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokensDto {
    private String accessToken;
    private String refreshToken;
}
