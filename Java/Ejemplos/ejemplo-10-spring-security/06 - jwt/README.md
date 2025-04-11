# ¿Qué tiene este ejemplo?

Este ejemplo es una API básica con un único endpoint:

- GET /api/v1/tasks

Además, hay un controlador web MVC (@Controller) con un método para una página home con plantilla thymeleaf.

El objetivo es proteger la API usando JWT, y dejar el resto (la web MVC desprotegida, con acceso anónimo0)

Se parte del proyecto inicial, el "01 - base-to-do-list", al que se le añade el controlador para la home MVC
y se siguen los siguientes pasos:

### Añadir dependencias

Añadir al proyecto las dependencias:

- Starter de Spring Security
- io.jsonwebtoken.jjwt. ES una dependencia que agrupa estas tres: jjwt-api, jjwt-impl,jjwt-jackson, de io.jsonwebtoken.

### Verificar que ya no se puede acceder al endpoint ni a la página home

Al añadir Spring Security, no debería poderse hacer un GET de forma anónima a http://localhost:8080/api/v1/tasks
Ni acceder a la página home http://localhost:8080

### Crear servicios y beans necesarios

- UserDetailsService personalizado que busque por email/username (AppUserDetailsService). Este servicio:
    - Implementa UserDetailsService
    - En concreto, el método *UserDetails loadUserByUsername(String userName)*, que tiene que buscar el usuario en la
      BD, y devolver un objeto UserDetails con nombre de usuario, contraseña y, opcionalmente, roles.
    - Para hacerlo se puede devolver un objeto de la clase "User" de "org.springframework.security.core.userdetails".
    - Se puede crear como @Bean en @Configuration, o como una clase independiente anotada con @Service.
- PasswordEncoder
    - Se pueden usar varios algoritmos de hash para claves. Uno de los más usados es BCrypt, que está implementado en la
      clase BCryptPasswordEncoder.
    - Lo más habitual es crear este componente como un @Bean en configuración, por la simplicidad del método.
- AuthenticationManager y AuthenticationProvider (puede haber más de un AuthenticationProvider)
    - Los AuthenticationProvider se encargan de autenticar al usuario de distintas formas (OAuth2, usuario y contraseña,
      MSIL, etc.)
    - En este caso habrá un AuthenticationProvider, de tipo DaoAuthenticationProvider. Este tipo de provider necesita
      dos cosas:
        - Una forma de obtener los datos del usuario (el servicio UserDetailsService)
        - Saber cómo se codifican contraseñas (el servicio PasswordEncoder)
    - El AuthenticationManager se crea usando la clase "ProviderManager", que admite en un constructor uno o varios
      managers.

### Crear un controlador para autenticación

Crear un controlador "AuthController", con los métodos (de momento vacíos)

- Register. Este método necesita:
    - DTO para recibir datos (usuario y contraseña, y otros datos necesarios para la clase de usuario definida). Este
      DTO se puede anotar con atributos de validación, para que no se admitan peticiones a las que les falten datos.
    - DTO para responder (con token de acceso y token de refresco)
- Login. Este método necesita:
    - DTO para recibir datos (usuario y contraseña)
    - DTO para responder (con token de acceso y token de refresco)
- Refresh. Este método necesita:
    - DTO para responder, con un nuevo token de acceso (y opcionalmente puede añadirse de refresco)
    - No necesita DTO de entrada.
- Puede que sea interesante implementar un método revoque(). No recibiría nada, pero revocaría el token recibido.

### Crear dos SecurityFilterChain separadas, una para la API y otra para la web "normal"

En el proyecto conviven dos cosas muy diferentes:

- Una aplicación web MVC + Thymeleaf, que de momento solo tiene una página home. Se debe poder acceder sin autenticar.
- Una serie de servicios (API), divididos en dos grupos:
    - Servicios relacionados con autenticación: register, login, etc. Estos servicios tampoco necesitan autenticación.
    - Servicios de datos: servicio para consultar las tareas del usuario. Estos servicios son autenticados.

Hay que configurar la seguridad de los dos por separado, y dentro de los servicios diferencias entre los que necesitan
autenticación y los que no. Para esto se crean dos clases anotadas con @Configuration, y cada una de ellas con un @Bean
de tipo SecurityFilterChain:

- ApiSecurityConfig - Creará la cadena de filtros para la API. Para que esta cadena de filtros aplique solo en la API.
  En esta cadena de filtros:
    - Se usa el método "securityMatcher", que hace que la cadena generada solo aplique en cierta ruta.
    - Se usa el método "authorizeHttpRequests" para diferenciar los dos tipos de servicios, los de autorización (no
      autenticados) y los de tareas (autenticados).
    - Desactiva ciertas características que no son necesarias en API: CSRF, autenticación básica, autenticación por
      formularios.
    - Establece sesiones sin estado, también habitual en API.
    - Añade el filtro de autorización que procesará las cabeceras de las peticiones para buscar el token JWT y
      validarlo.
- WebSecurityConfig - Creará la cadena de filtros por defecto, para que se aplique solo cuando no aplique la anterior.
  Esta cadena de filtros:
    - Mantiene los filtros por defecto en Spring.
    - Habilita el acceso anónimo a todas las rutas en las que aplique.

Cuando hay más de una configuración es una buena práctica ordenarlas con @Order, para que Spring las evalúe y procese en
un orden específico. Normalmente, a la clase que contiene la cadena "final", por defecto, se le da el orden más alto,
para que sea la que más tarde interviene.

### Crear servicio JwtService

En varios puntos de la aplicación hay que crear tokens JWT. Para esto, crear el servicio JwtService. Este servicio
necesita una serie de parámetros que se pueden poner en config:

- security.jwt.signing-key-secret: cualquier palabra. Se usa para crear una clave para firmar los
  tokens.
- security.jwt.access-token-ttl: 15 minutos en ms.
- security.jwt.refresh-token-ttl: 7 días en ms.

Los valores de config se pueden "inyectar" en el servicio con @Value. Por ejemplo:

*@Value("${security.jwt.signing-key-secret}")*.

Esta anotación se coloca antes de un atributo de la clase.

Para firmar los tokens es necesaria un algoritmo y una clave para este algoritmo:

- Como algoritmo se puede usar HMAC-SHAXXX (HMAC-SHA256, HMAC-SHA512). Es un algoritmo que combina HASH SHA con una
  clave secreta pra la firma.
- La clave para la firma se puede obtener con *SecretKey key = Keys.hmacShaKeyFor(signingKeySecret.getBytes())*. Esto
  genera una clave del tamaño adecuado, en función del "secret" utilizado.

Hay que hacer estos métodos:

- Método para crear accessToken, que reciba un usuario y genere el token (claim type=access).
- Método para crear refreshToken, que reciba un usuario y genere el token (claim type=refresh).
- Para estos dos, se puede crear un método privado "buildToken", con los claims habituales: subject (username),
  nombre y apellidos, issuedAt (System.currentTimeMillis()), expiration = (issuedAt + duración). Que firme el token
  con el método signWith. Para este método se usa la clave mencionada anteriormente.
- Método para validar un token, que diga si el token es o no válido. Mejor un método para access token y otro para
  refresh token.
- Método para obtener el nombre de usuario del token

### Crear un servicio AuthRequest y su método register y login

Para todo lo relacionado con autenticación / autorización se crea un servicio "AuthService" Dentro de este servicio, el
método "register", que, usando una transacción (@Transactional):

- Recibe la petición (RegisterUserDto) con los datos del usuario que hay que crear.
- Usando el servicio AppUserService (no AppUserDetailsService), con su método register(RegisterUserDto), para crear un
  usuario. En este proceso de crear usuario:
    - Se verificará que no haya ya un usuario con el mismo nombre de usuario (email). Si lo hay, lanzará excepción que
      se podrá controlar con RestControllerAdvice o directamente con @ExceptionHandler en el controlador.
    - Opcionalmente, podría comprobar la fortaleza de la contraseña. Longitud mínima, caracteres especiales, etc.
      Igualmente, si no fuera adecuada
    - Tiene que usar el PasswordEncoder para guardar la contraseña como un hash.
    - Devuelve el usuario creado, que se usará para generar los tokens
- Con el usuario ya creado, se generan los dos tokens y se devuelve un objeto JwtTokensDto, que se devuelve.

El método login:

- Usar AuthenticationManager.authenticate(...) con UsernamePasswordAuthenticationToken
- Si todo va bien, buscar el usuario en la BD con AppUserService.findByEmail.

Si existe el usuario, usar los métodos de JwtService para crear los tokens y:

- Si se va a hacer revocación, guardar el refresh token.
- Devolver access token y refresh token.

El controlador llamará a estos métodos desde register y login

### Crear JwtAuthenticationFilter

Este filtro:

- Extiende de OncePerRequestFilter
- Debe anotarse como @Component para poder usarlo en otros componentes, y para poder inyectar dependencias en él.
- Sólo debe aplicarse a la ruta / rutas que queramos proteger
- Extrae el token JWT del header Authorization: Bearer ...
- Si no hay header 'Authorization', o no es "Bearer", se rechaza la petición.
- Se valida el token. Si no es válido (mal formado o ha expirado) se rechaza la petición.
- Extrae el nombre de usuario del token. Si ya se valida el token en este paso, el anterior puede obviarse. Si durante
  la extracción de usuario falla algo, se rechaza la petición.
- Se obtienen los detalles del usuario con UserDetailsService. Si falla algo, se rechaza la petición.
- Si todo ha ido bien, se crea un objeto UsernamePasswordAuthenticationToken, y se fija en el contexto de seguridad. (
  SecurityContextHolder.getContext().setAuthentication(...))
- En este punto, al devolver errores se puede usar ProblemDetails, pero como esto no es un @ExceptionHandler, hay que
  trabajar directamente con response, lo que implica trabajar a más bajo nivel. Una opción es crear un objeto
  ProblemDetail, y escribirlo en la salida usando ObjectMapper, que es parte del serializador Jackson

### Configurar la seguridad

Modificar el @Bean SecurityFilterChain de la API para añadir el filtro JWT antes de
UsernamePasswordAuthenticationFilter.

### Modificar TaskService para que extraiga el usuario del contexto de seguridad

Esto se ha hecho en otros ejemplos, obteniendo el usuario, a partir de este el id, y con este las tareas.
El usuario se obtiene a través del SecurityContextHolder.

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