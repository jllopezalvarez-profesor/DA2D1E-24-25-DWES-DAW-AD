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