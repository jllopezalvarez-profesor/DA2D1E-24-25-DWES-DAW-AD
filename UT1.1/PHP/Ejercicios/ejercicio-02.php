<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de multiplicar de un número en tabla</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
    <h1>Tabla de multiplicar de un número en tabla</h1>
    <?php
    $numero = 4;
    ?>
    <table class="table table-dark table-striped">
        <?php for ($i = 0; $i < 10; $i++): ?>
            <tr>
                <td><?= $numero ?> * <?= $i ?> = <?= $numero * $i ?></td>
            </tr>
        <?php endfor; ?>
    </table>

</body>

</html>