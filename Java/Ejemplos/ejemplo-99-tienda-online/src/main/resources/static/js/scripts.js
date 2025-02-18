/*!
* Start Bootstrap - Shop Homepage v5.0.6 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

function addToCart(button) {
    const productId = button.getAttribute("data-product-id");
    const quantity = 1;
    console.log("productId", productId);

    fetch(appRootPath +  'api/v1/cart', {
        method: "POST",
        body: JSON.stringify({productId, units: quantity}),
        headers: {
            "Content-type": "application/json"
        }
    }).then(response => {
            if (response.ok) {
                console.log("Añadido con éxito")
            }
        }
    ).catch(reason => {
        console.log(reason)
    })

}