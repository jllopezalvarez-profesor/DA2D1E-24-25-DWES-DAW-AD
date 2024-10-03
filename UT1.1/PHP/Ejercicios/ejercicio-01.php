<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de multiplicar de un número en UL</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
    <h1>Tabla de multiplicar de un número en UL</h1>
    <?php
    $numero = 4;
    ?>
    <ul>
        <?php for ($i = 0; $i < 10; $i++): ?>
            <li><?= $numero ?> * <?= $i ?> = <?= $numero * $i ?></li>
        <?php endfor; ?>
    </ul>

</body>

</html>