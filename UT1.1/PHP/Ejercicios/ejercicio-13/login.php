<?php
session_start();

include "users.php";

$errorMsg = [];
$userName = "";
$password = "";

if ($_SERVER['REQUEST_METHOD'] ==  "GET") {
    // Es get, tenemos que ver si redirigir a app
    if (isset($_SESSION['username'])) {
        // Hay un usuario identificado, hay que redirigir. 
        header("Location: app.php"); // Genera una respuesta 302 - Encontrado
        // Podría hacerse una respuesta con otro código con
        // header("Location: app.php", true, 307); // Genera una respuesta 307 - Movido permanentemente

        // Finalizamos la página porque no necesitamos generar cuerpo
        die();
    }
} else {
    // Hay otros métodos posibles (PUT / DELETE)
    // Pero asumimos que es un POST si no es GET
    if (empty($_POST['user'])) {
        // Esto es igual que hacer un array_push
        $errorMsg[] = "Error, no ha llegado el valor del campo 'usuario'";
    } else {
        $userName = $_POST['user'];
    }

    if (empty($_POST['password'])) {
        $errorMsg[] = "Error, no ha llegado el valor del campo 'password'";
    } else {
        $password = $_POST['password'];
    }

    if (count($errorMsg) == 0) {
        // Se podría usar isset en lugar de array
        if (array_key_exists($userName, $usersPasswords) && ($usersPasswords[$userName] == $password)) {
            // Punto crítico de la aplicación. Regeneramos el id de sesión
            $_SESSION['username'] = $userName;
            session_regenerate_id();
            // Aquí también redirijo
            header("Location: app.php"); // Genera una respuesta 302 - Encontrado
            die();
        } else {
            $errorMsg[] = "No existe el usuario $userName o la contraseña no es correcta.";
        }
    }
}





?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
    <h1>Login</h1>

    <?php if (count($errorMsg) > 0): ?>
        <ul>
            <?php foreach ($errorMsg as $msg) : ?>
                <li><?= $msg ?></li>
            <?php endforeach; ?>
        </ul>
    <?php endif; ?>

    <form method="post">

        <p>
            <label> Usuario:
                <input type="text" name="user" value="<?= $userName ?>">
            </label>
        </p>
        <p>
            <label> Contraseña:
                <input type="password" name="password">
            </label>
        </p>
        <p><button type="submit">Aceptar</button></p>
    </form>
</body>

</html>