Array.from(document.getElementsByClassName("add-to-cart-button"))
    .forEach(button => {
        console.log(button);
        button.addEventListener("click", () => {
            fetch("/api/products", {
                method: "POST",
                body: JSON.stringify({
                    name: "Producto",
                    description: "Desc del producto",
                    price: 100
                }),
                headers: {
                    "Content-type": "application/json; charset=UTF-8"
                }
            })
                .then(value => {
                    // alert("Ok")
                    fetch("/api/products")
                        .then(response => {
                            response.text().then(text => {
                                    const productos = JSON.parse(text);
                                    console.table(productos);

                                }
                            );

                        });


                })
                .catch(reason => alert("Error"))


        })
    });