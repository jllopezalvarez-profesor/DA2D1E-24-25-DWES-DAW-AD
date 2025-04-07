# ¿Qué tiene este ejemplo?

Este ejemplo es una API básica con un único endpoint:

- GET /api/v1/tasks

Este endpoint devuelve todas las tareas del usuario con ID 1. El ID está puesto en código, "hardcoded", en el método de
servicio.

El ID del usuario, debería extraerse del contexto de seguridad, del usuario autenticado. Como en esta versión no hay
autenticación de ninguna clase, no es posible obtener los datos del usuario, y no se puede obtener el ID. Por eso se
simula que el ID del usuario es el 1.

En las posteriores versiones se irá añadiendo autenticación, y se podrá extraer el usuario del contexto.

