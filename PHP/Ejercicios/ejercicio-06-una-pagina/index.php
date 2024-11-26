<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de multiplicar de varios números</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body class="container-fluid">
    <h1>Tabla de multiplicar de varios números</h1>



    <?php

    include "form.html";

    $error = false;
    $errorMessages = [];

    if (!filter_input(INPUT_POST, 'inicio', FILTER_VALIDATE_INT)) {
        $error = true;
        array_push($errorMessages, 'El parámetro "inicio" no existe o no es un número entero válido');
    }

    if (!filter_input(INPUT_POST, 'fin', FILTER_VALIDATE_INT)) {
        $error = true;
        array_push($errorMessages, 'El parámetro "fin" no existe o no es un número entero válido');
    }

    if (!$error) {
        $inicio = (int)$_POST['inicio'];
        $fin = (int)$_POST['fin'];
        if ($inicio > $fin) {
            $error = true;
            array_push($errorMessages, 'El parámetro "inicio" no puede ser mayor que el parámetro "fin"');
        }
    }

    ?>
    <?php if ($error): ?>
        <p>Se han producido errores:</p>
        <ul>
            <?php foreach ($errorMessages as $errorMessage): ?>
                <li><?= $errorMessage ?></li>
            <?php endforeach ?>
        </ul>
    <?php else: ?>
        <?php include "generar-tablas.php" ?>
    <?php endif; ?>
</body>

</html>