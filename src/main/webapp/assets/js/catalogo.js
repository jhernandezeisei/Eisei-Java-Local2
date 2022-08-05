$(document).ready(function () {
    prueba();
});

function prueba() {
    $.ajax({
        type: "GET",
        url: "../EiseiLocal/catalogoListar",
        async: true,
        success: function (data) {
            if (data.object) {
                cardsProductos(data);
            } else {
                //alerta de error  
                showPopupMessageGeneric("Aviso", data.message);
            }
        },
        error: function (jqxhr, settings, thrownError) {
            console.log("jqxhr.responseText=" + jqxhr.responseText);
        },
        fail: function (jqXHR, textStatus) {
            console.log(">>sendRequestJQ(): thrownError:" + thrownError);
            console.log(">>sendRequestJQ(): jqXHR:" + jqXHR);
        }
    });
}
function cardsProductos(data) {

    const formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
        minimumFractionDigits: 0
    })

    for (let item of data.object) {

        var card = `
                    <div class="card mx-5 my-5" style="width: 25rem;">
                    <img class="card-img-top" src="data:image/jpg;base64,${item.fotoProductoString}" alt="Card image cap">
                    <div class="card-body">
                    <h5 class="card-title">${item.nombreProducto}</h5>
                    <p class="card-text">${(formatter.format(item.precio))}</p>
                    </div>
                    </div>
                    </div>
                        `
        const cardContainer = document.getElementById("card-container")
        cardContainer.innerHTML += card
    }
}

