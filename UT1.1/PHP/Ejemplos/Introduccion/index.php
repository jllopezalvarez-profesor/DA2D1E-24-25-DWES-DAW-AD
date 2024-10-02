<!DOCTYPE html>
<html lang="en">
<?php
$nombre = 'José Luis';
$apellidos = 'López Álvarez';
$nombreApellidos = sprintf('%s %s', $nombre, $apellidos);



$edad = 18;
?>

<!--
<?php
var_dump($nombreApellidos);
?>
-->

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi primera página PHP</title>
</head>

<body>
    <h1>Mi primera página php</h1>
    <p>Esto ha sido mucho más fácil</p>
    <p>
        Primera opción:
        <?php
        echo $nombre;
        ?>
    </p>
    <p>Segunda opción: <?php echo $nombre; ?></p>
    <p>Tercera opción: <?php print $nombre; ?> <?php print $apellidos; ?> </p>
    <p>Cuarta opción: <?php echo $nombre, ' ', $apellidos; ?> </p>
    <p>Quinta opción: <?php printf('%s %s', $nombre, $apellidos); ?> </p>
    <p>Sexta opción: <?= $nombre, ' ', $apellidos; ?></p>

    <?php if ($edad >= 18) { ?>
        <p>Eres mayor de edad</p>
    <?php } else { ?>
        <p>No eres mayor de edad</p>
    <?php } ?>

    <?php if ($edad >= 18): ?>
        <p>Eres mayor de edad</p>
        <p>Puedo poner más HTML</p>
    <?php else: ?>
        <p>No eres mayor de edad</p>
        <p>Puedo poner más HTML</p>
    <?php endif; ?>


    <!--
    <?php
    var_dump($edad);
    echo "\n";
    print_r($edad);
    ?>
    -->


    <?php if ($edad >= 18) {
        // Mostrar un mensaje
        echo '<p>Eres mayor de edad</p>';
    } else {
        // Mostrar el otro
        echo '<p>Eres menor de edad</p>';
    } ?>

</body>

</html>