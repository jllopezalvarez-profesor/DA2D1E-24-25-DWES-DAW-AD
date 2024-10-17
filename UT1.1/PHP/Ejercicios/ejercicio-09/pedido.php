<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body>
    <h1>Su pedido gracias</h1>
    <?php
    include "data.php";

    $errores = [];
    $hayError = false;

    // if (!isset($_POST['masa']) || strlen($_POST['masa']) == 0) {
    // }

    if (empty($_POST['masa'])) {
        $hayError = true;
        array_push($errores, "No se ha especificado el tipo de masa");
    } else {
        $masa = $_POST['masa'];
        if (!isset($tiposMasa[$masa])) {
            $hayError = true;
            array_push($errores, "El valor recibido para la masa no es válido");
        }
    }


    if (empty($_POST['tamanio'])) {
        $hayError = true;
        array_push($errores, "No se ha especificado el tamaño de la pizza");
    } else {
        $tamanio = $_POST['tamanio'];
        if (!isset($tamanios[$tamanio])) {
            $hayError = true;
            array_push($errores, "El valor recibido para el tamaño no es válido");
        }
    }

    if (!filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL)) {
        $hayError = true;
        array_push($errores, "No se ha especificado el correo electrónico o no es un email válido");
    } else {
        $email = $_POST['email'];
    }

    $ingredientes = filter_input(INPUT_POST, 'ia', FILTER_DEFAULT, FILTER_REQUIRE_ARRAY);
    // Si no se elige ningún ingrediente, el valor de $ingredientes será null.
    // Si es null, cambiamos este null por un array vacío para que sea más fácil procesarlo.
    if (!$ingredientes) {
        $ingredientes = [];
    }


    // $numcalle = filter_input(INPUT_POST, 'numcalle', FILTER_VALIDATE_INT);
    // if (!$numcalle) {
    //     $hayError = true;
    //     array_push($errores, "No se ha especificado el número de la calle o no es un entero");
    // }

    // $numcalle = $_POST['numcalle'];

    // $numcalle = filter_var($numcalle, FILTER_VALIDATE_INT);
    // if (!$numcalle) {
    //     $hayError = true;
    //     array_push($errores, "No se ha especificado el número de la calle o no es un entero");
    // }


    ?>


    <?php if ($hayError): ?>
        <div
            class="alert alert-danger"
            role="alert">
            <p>
                <strong>Hay errores</strong>
            <ul>
                <?php foreach ($errores as $error): ?>
                    <li><?= $error ?></li>
                <?php endforeach; ?>
            </ul>
            </p>
        </div>


    <?php else: ?>
        <p>Este es tu pedido</p>
        <ul>
            <li><?= $masa ?></li>
            <li><?= $tamanio ?></li>
            <li><?= $email ?></li>
            <?php if ($ingredientes): ?>
                <li>Ingredientes adicionales:
                    <ul>
                        <?php foreach ($ingredientes as $ingrediente): ?>
                            <li><?= $ingredientesAdicionales[$ingrediente] ?></li>
                        <?php endforeach ?>
                    </ul>

                </li>
            <?php endif ?>
        </ul>
    <?php endif; ?>



</body>

</html>