package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.controllers;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.JwtTokensDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.LoginUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.RegisterUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.AppUserService;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.AuthService;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AppUserService appUserService, JwtService jwtService, AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtTokensDto> register(@RequestBody RegisterUserDto registerUserDto) {
        return ResponseEntity.ok(authService.register(registerUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokensDto> login(@RequestBody LoginUserDto loginUserDto) {
        return ResponseEntity.ok(authService.login(loginUserDto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtTokensDto> refresh(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        return ResponseEntity.ok(authService.refresh(authHeader));
    }

    @PostMapping("/revoque")
    public ResponseEntity<Void> revoke() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
