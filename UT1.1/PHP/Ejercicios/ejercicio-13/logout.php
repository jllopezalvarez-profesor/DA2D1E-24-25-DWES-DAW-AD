<?php
session_start();

if (!isset($_SESSION['username'])) {
    // No hay un usuario identificado, hay que redirigir a login. 
    header("Location: login.php"); // Genera una respuesta 302 - Encontrado
    // Finalizamos la página porque no necesitamos generar cuerpo
    die();
}


include "users.php";

$userName = $_SESSION['username'];
$fullName = $usersDetails[$userName];

// Eliminar la sesión del usuario
session_destroy();

// Regenerar el id porque es un "evento crítico"
// session_regenerate_id();

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout</title>
</head>

<body>
    <h1>Desconexión del sistema</h1>
    <p>Hasta la vista <?= $fullName ?></p>

</body>

</html>