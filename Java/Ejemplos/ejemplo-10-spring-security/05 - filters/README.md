# ¿Qué tiene este ejemplo?

Este ejemplo deriva de la versión base, la "01 - base-to-do-list". Es la misma API, pero:

- Se ha añadido la dependencia del starter de Spring Security en el POM.xml.
- Aunque por defecto Spring protege todo, en este caso se ha permitido el acceso anónimo a todas la aplicación, para
  poder probar filtros básicos.
- En el @Bean SecurityFilterChain se han añadido varios filtros para probar cuándo se "disparan".

Uno de los filtros no hace nada relacionado con la seguridad, simplemente se limita a monitorizar las peticiones que se
reciben, y muestra en consola el tiempo que tardan en procesarse. No es un tiempo exacto. Es el tiempo que tardan en
procesarse los filtros que están después de él en la cadena, más el tiempo de proceso en el controlador.

El otro sí es un filtro de autorización, algo "rústico". Comprueba si el path de la petición debe ser protegido, y si lo
es, verifica si la petición incluye una cabecera "X-Custom-Header" con un valor concreto. El nombre de la cabecera puede
ser el que quiera. Las cabeceras que empiezan con X- se consideran cabeceras personalizadas, de cada sistema.

Este filtro tiene que mirar si aplica o no según la ruta, porque los filtros se disparan siempre, para todas las
peticiones. No hay una forma de decir "este filtro es solo para tal ruta". Se dispara para todas, y el propio filtro es
el responsable de averiguar si debe aplicarse.



