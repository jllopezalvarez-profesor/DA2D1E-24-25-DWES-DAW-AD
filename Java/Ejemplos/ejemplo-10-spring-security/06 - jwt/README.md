# ¿Qué tiene este ejemplo?

Este ejemplo es una API básica con un único endpoint:

- GET /api/v1/tasks

Que se protege con JWT para evitar accesos de usuarios no autenticados. Se parte del proyecto inicial, el "01 -
base-to-do-list", y se siguen los siguientes pasos:

### Añadir dependencias

Añadir al proyecto las dependencias:

- Starter de Spring Security
- io.jsonwebtoken.jjwt. ES una dependencia que agrupa estas tres: jjwt-api, jjwt-impl,jjwt-jackson, de io.jsonwebtoken.

### Verificar que ya no se puede acceder al endpoint

Al añadir Spring Security, no debería poderse hacer un GET de forma anónima a http://localhost:8080/api/v1/tasks

### Crear servicios y beans necesarios

- UserDetailsService personalizado que busque por email/username (AppUserDetailsService)
- PasswordEncoder (por ejemplo, BCrypt)
- AuthenticationManager (usualmente expuesto como @Bean)
- AuthenticationProvider (usa DaoAuthenticationProvider), usualmente se crea a la vez que el AuthenticationManager

### Crear un controlador para autenticación

Crear un controlador "AuthController", con los métodos (de momento vacíos)

- Register. Este método necesita:
    - DTO para recibir datos (usuario y contraseña, y otros datos necesarios para la clase de usuario definida)
    - DTO para responder (con token de acceso y token de refresco)
- Login. Este método necesita:
    - DTO para recibir datos (usuario y contraseña)
    - DTO para responder (con token de acceso y token de refresco)
- RefreshToken. Este método necesita:
    - DTO para responder, con un nuevo token de acceso (y opcionalmente puede añadirse de refresco)
    - No necesita DTO de entrada.
- Puede que sea interesante implementar un método revoque(). No recibiría nada, pero revocaría el token recibido.

### Implementar register

- Implementar la parte relacionada con guardar el usuario en la BD.
    - Crear AppUserService (si no existe ya). No confundirlo con el AppUserDetailsService.
    - Crear método register() en el servicio. Este método tiene que usar el PasswordEncoder para guardar la contraseña
      como un hash.
- Si el registro tiene éxito, hay que crear los tokens JWT. Para esto:
    - Crear JwtService. Este servicio necesita una serie de parámetros que se pueden poner en config:
        - application.security.jwt.signing-key-secret: cualquier palabra. Se usa para crear una clave para firmar los
          tokens.
        - application.security.jwt.access-token-expiration: 15 minutos en ms.
        - application.security.jwt.refresh-token-expiration: 7 días en ms.
    - Método para crear accessToken, que reciba un usuario y genere el token (claim type=access).
    - Método para crear refreshToken, que reciba un usuario y genere el token (claim type=refresh).
    - Para estos dos, se puede crear un método privado "buildToken", con los claims habituales: subject (username),
      nombre y apellidos, issuedAt (System.currentTimeMillis()), expiration = (issuedAt + duración). Que firme el token
      con el método signWith. Para este método hace falta una clave en binario, que se puede obtener a partir de la
      clave en texto que hay en la configuración.

### Configurar la seguridad

Crear clase SecurityConfiguration y anotar con @Configuration. En esta clase, crear el Bean SecurityFilterChain para:

- Desactivar:
    - CSRF
    - Basic auth
    - Form login
- Activar:
    - SessionManagement como stateless
    - Permitir /auth/** como pública
    - Añadir filtro JWT antes de UsernamePasswordAuthenticationFilter. Este filtro se crea vacío inicialmente. Se
      termina en el siguiente paso.

### Crear JwtAuthenticationFilter

Este filtro:

- Extiende de OncePerRequestFilter
- Extrae token del header Authorization: Bearer ...
- Valida el token con JwtService. Puede validar la firma, pero también la expiración o el tipo de token.
- Si es válido, extrae del token el nombre de usuario, crea un UsernamePasswordAuthenticationToken y lo guarda en
  SecurityContextHolder

### Modificar TaskService para que extraiga el usuario del contexto de seguridad

Esto se ha hecho en otros ejemplos, obteniendo el usuario, a partir de este el id, y con este las tareas.

### Implementar método login en AuthController

Puede hacerse:

- Usar AuthenticationManager.authenticate(...) con UsernamePasswordAuthenticationToken
- Si la autenticación funciona, generar los dos tokens
- Guardar refresh token (si se va a hacer revocación)
- Devolver access token y refresh token. Para web, el refresh token debería devolverse como cookie segura httponly

### Implementar refreshToken en AuthController

Puede hacerse:

- Leer el refresh token desde cabecera y validarlo. Esto se puede hacer directamente en el filtro jwt, si se quiere, de
  forma que no se admitan peticiones a /api/v1/auth/refresh si no se está recibiendo un token de refresco válido.
- Si es válido, generar y devolver un nuevo access token (y si se quiere un refresh token)

### Revocación de tokens (si se quiere hacer)

Para hacer revocación de tokens es necesario, por ejemplo:

- Modificar la tabla de usuarios para que se guarde la fecha del último logout / revocación.
- Opcional: modificar el login para que, cuando haya un login con éxito, se borre la fecha de logout / revocación. Según
  como se codifique el filtro, puede no hacer falta.
- Modificar el filtro JWT para que, si hay fecha de logout y llegan tokens anteriores al logout, se rechace la
  petición.

Esta estrategia es simple, pero tiene desventajas:

- No se puede tener sesiones diferenciadas por navegador/dispositivo.
- Por tanto, no se puede revocar solo uno de varios tokens activos.
- No se puede revocar un token específico sin invalidarlos todos.

Para una estrategia más compleja, habría que guardar los tokens en una tabla en la BD, y quizá cachearlos en memoria
para evitar accesos innecesarios a la BD