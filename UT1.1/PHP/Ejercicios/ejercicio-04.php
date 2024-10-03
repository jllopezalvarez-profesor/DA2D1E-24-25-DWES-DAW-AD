<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calendario</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
    <?php
    $mes = 8;
    $anio = 1972;
    $dia = 13;
    ?>

    <h1>Calendario de <?= $mes ?>/<?= $dia ?></h1>

    <?php
    $primerDiaMes = new DateTime(sprintf("%d-%d-%d", $anio, $mes, $dia));
    var_dump($primerDiaMes);
    $diaSemana = $primerDiaMes->format('N');
    var_dump($diaSemana);
    ?>

</body>

</html>