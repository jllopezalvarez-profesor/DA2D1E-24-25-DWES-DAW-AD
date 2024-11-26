<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pide tu pizza</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <style>
        fieldset {
            padding: 1em;
            border: 1px dotted gray;
        }
    </style>
</head>

<?php include "data.php" ?>

<body>
    <div class="container">
        <h1>Pide tu pizza</h1>
        <div class="container">
            <form action="pedido.php" method="post">
                <fieldset>
                    <legend>Configura tu pizza</legend>
                    <fieldset>
                        <legend>Tipo de masa</legend>

                        <?php foreach ($tiposMasa as $codigo => $nombre): ?>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="masa" id="masa<?= $codigo ?>" value="<?= $codigo ?>">
                                <label class="form-check-label" for="masa<?= $codigo ?>">
                                    <?= $nombre ?>
                                </label>
                            </div>
                        <?php endforeach ?>

                        <!--
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="masa" id="masaf" value="F">
                            <label class="form-check-label" for="masaf">
                                Masa fina
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="masa" id="masag" value="G">
                            <label class="form-check-label" for="masag"> Masa gruesa </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="masa" id="masaq" value="Q">
                            <label class="form-check-label" for="masaq"> Borde relleno de queso </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="masa" id="masasg" value="SG">
                            <label class="form-check-label" for="masasg"> Sin gluten </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="masa" id="masai" value="I">
                            <label class="form-check-label" for="masai"> Integral </label>
                        </div>
                         -->
                    </fieldset>

                    <div class="mb-3">
                        <label for="tamanio" class="form-label">Tamaño</label>
                        <select class="form-select form-select-lg" name="tamanio" id="tamanio">
                            <option value="" selected>Selecciona un tamaño</option>
                            <?php foreach ($tamanios as $codigo => $nombre): ?>
                                <option value="<?= $codigo ?>"><?= $nombre ?></option>
                            <?php endforeach ?>
                            <!--
                            <option value="S">Pequeña</option>
                            <option value="M">Mediana</option>
                            <option value="L">Grande</option>
                            <option value="XL">Familiar</option>
                            -->
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="base" class="form-label">Pizza base</label>
                        <select class="form-select form-select-lg" name="base" id="base">
                            <option value="" selected>Selecciona una pizza base</option>
                            <option value="M">Margarita</option>
                            <option value="BBQ">Barbacoa</option>
                            <option value="4Q">Cuatro quesos</option>
                        </select>
                    </div>

                    <fieldset>
                        <legend>Ingredientes adicionales</legend>
                        <?php foreach ($ingredientesAdicionales as $codigo => $nombre): ?>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="ia[]" id="ia<?= $codigo ?>" value="<?= $codigo ?>">
                                <label class="form-check-label" for="ia<?= $codigo ?>">
                                    <?= $nombre ?>
                                </label>
                            </div>
                        <?php endforeach ?>
                        <!--
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="IA-PIM" id="ia-pim" name="ia[]">
                            <label class="form-check-label" for="ia-pim">Pimiento</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="IA-CEB" id="ia-ceb" name="ia[]">
                            <label class="form-check-label" for="ia-ceb">Cebolla</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="IA-CP" id="ia-cp" name="ia[]">
                            <label class="form-check-label" for="ia-cp">Carne picada</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="IA-PL" id="ia-pl" name="ia[]">
                            <label class="form-check-label" for="ia-pl">Pollo</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="IA-BE" id="ia-be" name="ia[]">
                            <label class="form-check-label" for="ia-be">Berenjena</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="IA-XQ" id="ia-xq" name="ia[]">
                            <label class="form-check-label" for="ia-xq">Extra de queso</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="IA-BBQ" id="ia-bbq" name="ia[]">
                            <label class="form-check-label" for="ia-bbq">Extra de queso</label>
                        </div>
                            -->
                    </fieldset>
                </fieldset>

                <fieldset>
                    <legend>Datos de entrega</legend>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" name="nombre" id="nombre">
                    </div>
                    <div class="mb-3">
                        <label for="apellidos" class="form-label">Apellidos</label>
                        <input type="text" class="form-control" name="apellidos" id="apellidos">
                    </div>
                    <div class="mb-3">
                        <label for="direccion" class="form-label">Dirección completa</label>
                        <input type="text" class="form-control" name="direccion" id="direccion">
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Teléfono</label>
                        <input type="text" class="form-control" name="telefono" id="telefono">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" class="form-control" name="email" id="email" placeholder="abc@mail.com">
                    </div>
                    <div class="mb-3">
                        <label for="observaciones" class="form-label">Observaciones</label>
                        <textarea class="form-control" name="observaciones" id="observaciones"></textarea>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Forma de pago</legend>
                    <div class="mb-3">
                        <label for="base" class="form-label">Tamaño</label>
                        <select class="form-select form-select-lg" name="pago" id="pago">
                            <option value="" selected>Selecciona la forma de pago</option>
                            <option value="T">Tarjeta bancaria</option>
                            <option value="B">Bizym</option>
                            <option value="P">Paypal</option>
                        </select>
                    </div>

                </fieldset>

                <p>
                    <button type="submit" name="pedido" value="valor-pedido" class="btn btn-primary">Realizar
                        pedido</button>
                </p>
            </form>
        </div>

    </div>

</body>

</html>