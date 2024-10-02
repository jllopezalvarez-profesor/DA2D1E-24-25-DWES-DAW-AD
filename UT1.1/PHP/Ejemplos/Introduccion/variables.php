<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h2>Tipos y variables con tipado dinámico</h2>
    <p>
        <?php
        $cadena = 'Esto es una cadena';
        var_dump($cadena);
        echo '<br>';
        $numero = 3;
        var_dump($numero);
        echo '<br>';
        $numeroConDecimales = 3.141512;
        var_dump($numeroConDecimales);
        echo '<br>';
        $numero = "Holaaaa cambio de tipoooo";
        var_dump($numero);
        ?>
    </p>
    <h2>Tipado débil: cambio de tipo para adaptarse a la operación (suma de enteros)</h2>
    <p>
        <?php
        $numeroA = '20';
        $numeroB = '30';
        $resultado = $numeroA + $numeroB;
        var_dump($resultado);
        ?>
    </p>

    <h2>Tipado débil: cambio de tipo para adaptarse a la operación (concatenación)</h2>
    <p>
        <?php
        $numeroA = 20;
        var_dump($numeroA);
        $numeroB = 30;
        $resultado = $numeroA . $numeroB;
        var_dump($resultado);
        ?>
    </p>

    <h2> Comparación "relajada" vs "stricta"</h2>
    <p>
        <?php
        $variableA = 30;
        $variableB = '30';

        echo "<p>Resultado de a == b: ", var_dump($variableA == $variableB), "</p>";
        echo "<p>Resultado de a === b: ", var_dump($variableA === $variableB), "</p>";
        ?>
    </p>

    <h2>Coalescencia de nulos</h2>
    <p>
        <?php
        // $variableQuePuedeSerNula = null;
        $variableQuePuedeSerNula = 3156;
        echo "<p>Variable nula: ", var_dump($variableQuePuedeSerNula), "</p>";
        $variableConValorPorDefecto = $variableQuePuedeSerNula ?? "Valor por defecto si es nula";
        echo "<p>Variable que no puede ser nula: ", var_dump($variableConValorPorDefecto), "</p>";

        # Se podría escribir así:
        $variableConValorPorDefecto = (is_null($variableQuePuedeSerNula)) ? "Valor por defecto si es nula" : $variableQuePuedeSerNula;



        ?>
    </p>



</body>

</html>