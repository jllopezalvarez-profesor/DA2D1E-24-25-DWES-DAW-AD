<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejemplo de arrays</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
    <h1>Ejemplo de arrays</h1>
    <?php
    $dias = [
        "Lunes" => 1,
        "Martes" => 2,
        "Miércoles" => 3,
        "Jueves" => 4,
        "Viernes" => 5,
        "Sábado" => 6,
        "Domingo" => 7
    ];
    ?>

    <h2>Bucle de valores</h2>
    <ul>
        <?php foreach ($dias as $dia): ?>
            <li><?php echo $dia ?></li>
        <? endforeach ?>
    </ul>


    <h2>Bucle de claves y valores</h2>
    <ul>
        <?php foreach ($dias as $nombreDia => $dia): ?>
            <li><?= $dia ?> - <?= $nombreDia ?></li>
        <? endforeach ?>
    </ul>


</body>

</html>