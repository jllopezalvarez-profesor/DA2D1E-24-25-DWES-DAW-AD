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
    $ok = true;

    if (!isset($_GET['inicio'])):
        $ok = false;    ?>
        <p>No se ha recibido el parámetro inicio
        <?php endif; ?>
        <?php if (!isset($_GET['fin'])): ?>
        <p>No se ha recibido el parámetro fin
        <?php endif; ?>


        <?php
        $numInicial = $_GET['inicio'];
        $numFinal = $_GET['fin'];
        ?>

        <?php if ($numInicial > $numFinal): ?>
        <p class="alert alert-danger">El número inicial no puede ser superio al número final</p>
    <?php else: ?>
        <?php if ($ok): ?>
            <table class="table table-border table-striped-columns">
                <tr>
                    <td></td>
                    <?php for ($i = $numInicial; $i <= $numFinal; $i++): ?>
                        <th scope="col"><?= $i ?></th>
                    <?php endfor; ?>
                </tr>
                <?php for ($fila = 0; $fila < 10; $fila++): ?>
                    <tr>
                        <th scope="row"><?= $fila ?></th>
                        <?php for ($i = $numInicial; $i <= $numFinal; $i++): ?>
                            <td><?= $fila * $i ?></td>
                        <?php endfor; ?>

                    </tr>

                <?php endfor; ?>

            </table>

        <?php endif; ?>
    <?php endif; ?>

</body>

</html>