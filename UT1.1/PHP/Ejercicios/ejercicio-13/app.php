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


?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>APP</h1>
    <p>UserName: <?= $userName ?></p>
    <p>Nombre completo: <?= $fullName ?></p>

</body>

</html>