<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de multiplicar de varios números</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body class="container-fluid">
    <h1>Tabla de multiplicar de varios números ----</h1>

    <?php if (!isset($_POST['inicio']) && !isset($_POST['fin'])): ?>
        <?php include_once "form-include.html" ?>

    <?php else: ?>

        <?php
        $ok = true;

        if (!isset($_POST['inicio'])):
            $ok = false;    ?>
            <p>No se ha recibido el parámetro inicio
            <?php endif; ?>
            <?php if (!isset($_POST['fin'])): ?>
            <p>No se ha recibido el parámetro fin
            <?php endif; ?>


            <?php
            $numInicial = $_POST['inicio'];
            $numFinal = $_POST['fin'];
            ?>

            <?php if ($numInicial > $numFinal): ?>
            <p class="alert alert-danger">El número inicial no puede ser superio al número final</p>
        <?php else: ?>
            <?php if ($ok): ?>
                <?php include "generar-tablas.php" ?>

            <?php endif; ?>
        <?php endif; ?>
        <?php include_once "form-include.html" ?>
        <?php include_once "form-include.html" ?>
        <?php include_once "form-include.html" ?>
    <?php endif; ?>
</body>

</html>