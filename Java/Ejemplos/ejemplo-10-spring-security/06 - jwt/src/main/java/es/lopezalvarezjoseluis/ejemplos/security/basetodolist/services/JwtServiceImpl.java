package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * Implementación del servicio de gestión de JWT (JSON Web Tokens).
 * <p>
 * Este servicio se encarga de generar, validar y extraer información de los tokens JWT utilizados
 * en el sistema para la autenticación de los usuarios. Los tokens generados incluyen tokens de acceso
 * (access token) y tokens de refresco (refresh token).
 * </p>
 *
 * <p>
 * Los tokens generados se firman usando una clave secreta configurada en la aplicación. El tipo de token
 * (acceso o refresco) se indica mediante un claim y cada tipo tiene un tiempo de expiración diferente.
 * </p>
 */
@Service
public class JwtServiceImpl implements JwtService {

    // Palabra clave secreta usada para generar la clave para la firma de tokens.
    // Debe ser lo bastante grande para obtener al menos 256 bits.
    @Value("${security.jwt.signing-key-secret}")
    private String signingKeySecret;

    // Tiempo que tarda en caducar el token de acceso, en milisegundos
    @Value("${security.jwt.access-token-ttl}")
    private long accessTokenTtl;

    // Tiempo que tarda en caducar el token de refresco, en milisegundos
    @Value("${security.jwt.refresh-token-ttl}")
    private long refreshTokenTtl;

    /**
     * Genera un token de acceso (Access Token) para un usuario.
     * <p>
     * Este token se firma con la clave secreta y contiene información como el correo, el nombre
     * y el apellido del usuario. El token tiene un tiempo de vida limitado, determinado por la
     * configuración de la aplicación.
     * </p>
     *
     * @param user El usuario para el que se generará el token.
     * @return El token de acceso generado.
     */
    @Override
    public String generateAccessToken(AppUser user) {
        return generateToken(user, JwtTokenType.ACCESS, accessTokenTtl);
    }

    /**
     * Genera un token de refresco (Refresh Token) para un usuario.
     * <p>
     * El token de refresco tiene un tiempo de vida más largo que el token de acceso y se utiliza
     * para obtener un nuevo token de acceso una vez que ha expirado el original.
     * </p>
     *
     * @param user El usuario para el que se generará el token.
     * @return El token de refresco generado.
     */
    @Override
    public String generateRefreshToken(AppUser user) {
        return generateToken(user, JwtTokenType.REFRESH, refreshTokenTtl);
    }

    /**
     * Genera un token JWT para un usuario con el tipo de token especificado y el tiempo de expiración proporcionado.
     * <p>
     * Función auxiliar para crear tanto tokens de acceso como de refresco
     * </p>
     *
     * @param user      El usuario para el que se generará el token.
     * @param tokenType El tipo de token que se generará (por ejemplo, acceso o refresco).
     * @param tokenTtl  El tiempo de vida del token en milisegundos.
     * @return El token JWT generado como una cadena.
     */
    private String generateToken(AppUser user, JwtTokenType tokenType, long tokenTtl) {
        SecretKey key = Keys.hmacShaKeyFor(signingKeySecret.getBytes());
        return Jwts.builder()
                .claim("type", tokenType)
                .subject(user.getEmail())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + tokenTtl))
                .signWith(key)
                .compact();
    }

    /**
     * Valida un token de acceso (Access Token).
     * <p>
     * Extrae los "claims" del token, verifica que el tipo de token sea un token de acceso
     * y lanza una excepción si el tipo no es válido.
     * </p>
     *
     * @param token El token de acceso que se desea validar.
     * @throws JwtException si el tipo de token no es válido o si el token es inválido.
     */
    @Override
    public void validateAccessToken(String token) {
        validateToken(token, JwtTokenType.ACCESS);
    }

    /**
     * Valida un token de refresco (Refresh Token).
     * <p>
     * Extrae los "claims" del token, verifica que el tipo de token sea un token de refresco
     * y lanza una excepción si el tipo no es válido.
     * </p>
     *
     * @param token El token de refresco que se desea validar.
     * @throws JwtException si el tipo de token no es válido o si el token es inválido.
     */
    @Override
    public void validateRefreshToken(String token) {
        validateToken(token, JwtTokenType.REFRESH);
    }

    /**
     * Valida un token, comprobando además que es del tipo indicado.
     * <p>
     * Extrae los "claims" del token, lo que implica validar el token.
     * Si el token es válido, verifica que el tipo de token sea el adecuado.
     * </p>
     *
     * @param token     El token de acceso que se desea validar.
     * @param tokenType El tipo de token que se espera.
     * @throws JwtException si el token no es válido (firma, expiración) o si el tipo de token no es válido.
     */
    private void validateToken(String token, JwtTokenType tokenType) {
        Claims claims = getTokenClaims(token);
        JwtTokenType type = JwtTokenType.valueOf(claims.get("type").toString());
        if (type != tokenType) {
            throw new JwtException("El tipo de token no es valido");
        }
    }

    /**
     * Extrae el nombre de usuario (correo electrónico) del token.
     * <p>
     * Permite obtener el correo electrónico del usuario desde el token,
     * que se almacena como el "subject" del token.
     * </p>
     *
     * @param token El token del cual se extraerá el nombre de usuario.
     * @return El nombre de usuario (correo electrónico) almacenado en el token.
     */
    @Override
    public String extractUsername(String token) {
        Claims claims = getTokenClaims(token);
        return claims.getSubject();
    }

    /**
     * Obtiene los "claims" (información del token) de un token JWT.
     * <p>
     * Utiliza la clave secreta para verificar la firma del token y obtener su información.
     * </p>
     *
     * @param token El token JWT del cual se extraerán los "claims".
     * @return Los "claims" del token, que contienen la información del mismo.
     * @throws JwtException si el token es inválido o ha caducado.
     */
    private Claims getTokenClaims(String token) {
        // Crear clave para la verificación de la firma.
        SecretKey key = Keys.hmacShaKeyFor(signingKeySecret.getBytes());
        // Crear un parser para verificar e interpretar el token JWT
        JwtParser parser = Jwts.parser().verifyWith(key).build();
        // Obtener los claims. Si esto falla, se lanzará una excepción
        // Puede fallar por múltiples motivos, como que haya caducado el token
        return parser.parseSignedClaims(token).getPayload();
    }

}
