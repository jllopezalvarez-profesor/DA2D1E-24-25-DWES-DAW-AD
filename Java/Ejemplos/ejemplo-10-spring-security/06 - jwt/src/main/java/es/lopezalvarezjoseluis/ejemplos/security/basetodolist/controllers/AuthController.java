package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.controllers;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.LoginUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.RegisterUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.TokensDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<TokensDto> register(@RequestBody RegisterUserDto registerUserDto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/login")
    public ResponseEntity<TokensDto> login(@RequestBody LoginUserDto loginUserDto){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokensDto> refresh(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/revoque")
    public ResponseEntity<Void> revoke(){
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
