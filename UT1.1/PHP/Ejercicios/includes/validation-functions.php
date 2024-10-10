    <?php

    function checkIntegerParam(string $nombreParam, array &$mensajesError): bool
    {
        if (!isset($_GET[$nombreParam])) {
            array_push($mensajesError, sprintf("No se ha recibido el parámetro '%s'", $nombreParam));
            return false;
        }

        if (!is_numeric($_GET[$nombreParam])) {
            array_push($mensajesError, sprintf("El parámetro '%s' no es un valor numérico", $nombreParam));
            return false;
        }

        $paramValue = (int)$_GET[$nombreParam];

        if (!is_int($paramValue)) {
            array_push($mensajesError, sprintf("El parámetro '%s' no es un número entero", $nombreParam));
            return false;
        }

        return true;
    }

    ?>