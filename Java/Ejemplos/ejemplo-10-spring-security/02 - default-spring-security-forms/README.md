# ¿Qué tiene este ejemplo?

Este ejemplo deriva de la versión base, la "01 - base-to-do-list". Es la misma API, pero está protegida. Para hacerlo:

- Se ha añadido la dependencia del starter de Spring Security en el POM.xml.
- Se ha configurado un usuario y contraseña en application.yml.

El nombre de usuario elegido es "billgates@taskapp.com", que corresponde con el usuario con ID "1". La contraseña de
este usuario es "password".

Si, usando el cliente HTTP de IntelliJ, se hace una petición GET /api/v1/tasks, fallará por defecto con un código HTTP
401, que es "Not authorized", pero que en realidad significa "No autenticado".

Si se hace esta petición en un navegador, aparece un formulario HTML para introducir las credenciales del usuario. Si se
usan las credenciales indicadas (billgates@taskapp.com / password), se puede acceder al endpoint, y se muestran los
datos.

Spring usa una sesión para almacenar el usuario conectado. Si se elimina la cookie de sesión, se vuelve a obtener el
código HTTP 401, y vuelve a saltar el formulario de autenticación.

En el servicio, se usa el repositorio de usuarios para obtener el ID de usuario, y obtener así sus tareas. Si se cambia
el email / contraseña en application.yml, se podrá acceder a las tareas del usuario con ID 2 (elonmusk@taskapp.com).

En la siguiente iteración usaremos un servicio específico para poder logar usuarios de la tabla de usuarios, sin tener
que poner nada del usuario en el fichero de configuración.