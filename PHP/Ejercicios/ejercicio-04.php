<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calendario</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        td {
            height: 7em;
        }
    </style>
</head>

<body>
    <?php
    $mes = 11;
    $anio = 2024;
    $dia = 1;
    ?>

    <h1>Calendario <?= $mes ?>/<?= $anio ?></h1>

    <?php
    $primerDiaMes = new DateTime(sprintf("%d-%d-%d", $anio, $mes, $dia));
    // var_dump($primerDiaMes);
    // echo "<br>";
    $diaSemana = $primerDiaMes->format('N');
    // var_dump($diaSemana);
    $diasMes = $primerDiaMes->format('t');



    ?>


    <table class="table table-bordered">
        <tr>
            <?php for ($dia = 1; $dia < $diaSemana; $dia++): ?>
                <td>&nbsp;</td>
            <?php endfor; ?>

            <?php for ($dia = 1; $dia + $diaSemana - 1 <= $diasMes + $diaSemana - 1; $dia++): ?>
                <td><?= $dia ?></td>
                <?php if ((($dia + $diaSemana - 1) % 7) == 0) {
                    echo "</tr><tr>";
                }
                ?>
            <?php endfor; ?>
            <?php
            while (($dia + $diaSemana - 1) % 7 != 0) {
                echo "<td>&nbsp</td>";
                $dia++;
            }
            ?>

        </tr>
    </table>


</body>

</html>