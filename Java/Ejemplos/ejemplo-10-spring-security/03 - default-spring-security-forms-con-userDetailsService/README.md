# ¿Qué tiene este ejemplo?

Este ejemplo deriva de la versión "02 - default-spring-security-forms".

En esta versión, los usuarios ya no están en el fichero de configuración. Esto permite logarse a más de un usuario, sin
tener que hacer cambios en el fichero application.yml.

La clave para esto es la creación de dos componentes:

- Servicio "AppUserDetailsService". Este servicio implementa "UserDetailsService", que tiene un método que permite a
  Spring buscar un usuario por su nombre de usuario (username)
- Servicio (creado con @Bean en @Configuration) que define un PasswordEncoder. Este componente permite a Spring saber
  cómo están guardadas las contraseñas en los usuarios. Spring, tras recuperar el usuario y contraseña almacenada usando
  el componente que implemente UserDetailsService, usa el encoder para codificar la contraseña introducida, y comparar
  la contraseña introducida con la previamente almacenada.

Se está usando NoOpPasswordEncoder. Este encoder no debería usarse NUNCA en producción. Es un encoder que en realidad no
codifica las contraseñas, así que si se filtra la BD, se filtrarían contraseñas en abierto. En nuestro caso es válido
para hacer pruebas.

El resto del proceso es el mismo que en el ejemplo 2. El usuario logado se guarda en sesión, y se usa
SecurityContextHolder para obtener el nombre de usuario (que en esta aplicación es el email), y con esto usar el
repositorio de usuarios para conseguir el ID, y así poder buscar las tareas del usuario.

Respecto a la configuración de seguridad más avanzada, no es necesario hacer un @Bean que devuelva SecurityFilterChain
porque no se está personalizando nada. Todo se deja exáctamente igual que en la configuración por defecto de Spring
Security. Esto es:

- Se protegen TODAS las rutas de la aplicación.
- Se usa por defecto autenticación basada en forms (formulario de login)

En realidad, aunque solo se han definido dos servicios (UserDetailsService y PasswordEncoder), hay otros dos servicios
implicados, que Spring Boot crea por defecto:

- AuthenticationManager. Componente central de Spring Security que se encarga de autenticar al usuario. Cuando alguien
  intenta iniciar sesión (por formulario, OAuth, etc.), Spring llama al AuthenticationManager y le dice: "Oye, aquí
  tienes este usuario con estas credenciales. ¿Puedes decirme si es válido?"
  El AuthenticationManager no hace la autenticación directamente: delegará esa tarea a uno o más
  AuthenticationProviders.
- AuthenticationProvider. componente que sabe autenticar un tipo concreto de usuario o de mecanismo de autenticación.
  Por ejemplo:
    - DaoAuthenticationProvider --> Usuarios locales (via UserDetailsService)
    - LdapAuthenticationProvider --> Usuarios de un servidor LDAP
    - OAuth2LoginAuthenticationProvider --> Usuarios que hacen login vía Google, GitHub, etc.
    - JwtAuthenticationProvider --> Usuarios con tokens JWT

El authenticationManager elige el authentication provider para autenticar cada tipo de usuario.

En la versión 4 se declararán estos componentes de forma explícita (no dejando que Spring los cree como quiera). En una
futura demo, se usarán distintos providers, para integrar el login de Google en la aplicación.  