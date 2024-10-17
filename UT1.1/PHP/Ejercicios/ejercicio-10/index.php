<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Procesamiento de documentos subidos</title>
</head>

<body>
    <h1>Procesamiento de documentos subidos</h1>
    <h2>Datos del fichero subido</h2>
    <p><?= var_dump($_FILES) ?></p>
    <p><?= var_dump($_FILES['documentos']) ?></p>
    <p><?= var_dump($_FILES['documentos']) ?></p>
    <h2>Ficheros subidos</h2>
    <?php



    if (isset($_FILES['file']) && $_FILES['file']['error'] === UPLOAD_ERR_OK) {
    }

    ?>

</body>

</html>