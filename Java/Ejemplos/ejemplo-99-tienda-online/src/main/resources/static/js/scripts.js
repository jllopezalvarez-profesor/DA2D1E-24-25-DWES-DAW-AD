

async function addToCart(button) {
    // Obtener el id del producto a partir del atributo data- del botón
    const productId = button.getAttribute("data-product-id");
    const quantity = 1;

    // Construir URL para la petición, usando interpolación.
    const requestUrl = `${appRootPath}api/v1/cart`;

    // Construir opciones y contenido de la petición
    const requestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ productId, quantity })
    };


    try {
        // Lanzar la petición usando async / await
        const response = await fetch(requestUrl, requestOptions);

        // Si algo ha fallado, lanzar excepción
        if (!response.ok) {
            throw new Error("Error al añadir al carrito");
        }

        // Obtener el resultado de la petición, convirtiendo el json en un objeto.
        const cartData = await response.json(); // Convertir la respuesta en un objeto

        // Usar el objeto para actualizar el UI
        updateCart(cartData);

        // TODO: TOAST para decir que todo ha ido bien

    } catch (error) {
        // TODO: TOAST para indicar que ha habido un error.
        console.error("Error:", error);
    }
}

/**
 * Función que se encarga de actualizar el carrito de compra.
 * De momento solo actualiza las unidades en el badge del carro.
 * @param cartData Carro de compra, con totales y unidades
 */
function updateCart(cartData) {
    // Obtener el badge con el número de unidades
    const productCountBadge = document.getElementById("product-count-badge");
    if (productCountBadge){
        productCountBadge.innerText = cartData.productCount;
    }
}



// function addToCart(button) {
//     const productId = button.getAttribute("data-product-id");
//     const quantity = 1;
//
//     const requestOptions = {
//         method: "POST",
//         headers: { "Content-Type": "application/json" },
//         body: JSON.stringify({ productId, quantity })
//     };
//
//     const requestUrl=`${appRootPath}api/v1/cart`
//
//     fetch(requestUrl, requestOptions)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error("Error al añadir al carrito");
//             }
//
//
//             console.log("Producto añadido con éxito");
//         })
//         .catch(error => console.error("Error:", error));
// }

