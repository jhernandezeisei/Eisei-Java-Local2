$(document).ready(function () {
    sendclaveRequestPOST();
    $.ajax({
        type: "GET",
        url: "../EiseiLocal/categorias",
        async: false,
        success: function (data) {
            var $ddl = $("#ddl_categorias");
            data.forEach(item => {
                $ddl.append("<option value='" + item.idCategoria + "'>" + item.nombre + "</option>");
            });
        },
        error: function (jqxhr, settings, thrownError) {
            console.log("jqxhr.responseText=" + jqxhr.responseText);
        },
        fail: function (jqXHR, textStatus) {
            console.log(">>sendRequestJQ(): thrownError:" + thrownError);
            console.log(">>sendRequestJQ(): jqXHR:" + jqXHR);
        }
    });
    destroyTable();
    sendProductT();

});

var table = null;
function llenarTabla(data) {

    $('#tp').dataTable().fnClearTable();
    $('#tp').dataTable().fnDestroy();
    var rateTable = $('#tp').DataTable({
        "searching": true,
        "ordering": false,
        "responsive": true,
        data: data,
        "columns": [
            {data: "clave",
                render: function (data) {
                    if (data == null || data == "") {
                        return "-";
                    } else {
                        return data;
                    }
                }
            },

            {data: "nombreProducto",
                render: function (data) {
                    if (data == null || data == "") {
                        return "-";
                    } else {
                        return data;
                    }
                }},
            {data: "marca",
                render: function (data) {
                    if (data == null || data == "") {
                        return "-";
                    } else {
                        return data;
                    }
                }},
            {data: "precio",
                render: function (data) {
                    if (data == null || data == "") {
                        return "-";
                    } else {
                        return "$" + data;
                    }
                }},
            {data: "cantidad",
                render: function (data) {
                    if (data == null || data == "") {
                        return "-";
                    } else {
                        return data;
                    }
                }},
            {data: "idCategoria",
                render: function (data) {
                    if (data == null || data == "") {
                        return "-";
                    } else {
                        return data;
                    }
                }},
            {data: "btn",
                render: function (data) {
                    return "<button onclick='editar(" + data + ")' class='btn btn-warning'><i class='bi bi-pencil-fill'></i></button>";

                }}


        ],
        "columnDefs": [
            {"className": "text-center", "targets": [0, 1, 2, 3, 4, 5, 6],
                orderable: true, "targets": [0, 1, 2, 3, 4, 5, 6]}
        ],
        "processing": true
    });
    $("#tp").removeClass("dataTable");


}

function editar() {
    var nombreP = $('');
    alert('editar');
    console.log()
}

function sendProductT() {
    $.ajax({
        type: "GET",
        url: "../EiseiLocal/ConsultaProductos",
        async: true,
        success: function (data) {

            if (data.object) {
                llenarTabla(data.object);
            } else {

                destroyTable();
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

function destroyTable() {
    $("#tp").dataTable().fnDestroy();
    TablaProductos = $('#tp').DataTable({
        "searching": false,
        "ordering": false,
        "serverSide": false,
        "stateSave": true,
        "lengthChange": false,
        "scrollX": true,
        "language":
                {
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "No se encontraron Resultados",
                    "sEmptyTable": "No se encontraron Resultados",
                    "sInfo": "_START_ al _END_ de _TOTAL_ registros",
                    "sInfoEmpty": "",
                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "sInfoThousands": ",",
                    "sLoadingRecords": "No se encontraron Resultados",
                    "oPaginate": {
                        "sFirst": "Primero",
                        "sLast": "Último",
                        "sNext": ">>",
                        "sPrevious": "<<"
                    }
                },
        "responsive": true,
        "columnDefs": [
            {"className": "text-center", "targets": [0, 1, 2, 3, 4, 5, 6],
                orderable: false, "targets": [0, 1, 2, 3, 4, 5, 6]}
        ],
        "processing": true
    });
    $(".th-sm").removeClass("sorting_asc");
    TablaProductos
            .clear()
            .draw();
}

function registrarP() {
    var nombrep = $('#nombrep').val();
    var marca = $('#marca').val();
    var cantidad = $('#cantidad').val();
    var clave = $('#clave').val();
    var ddl_categorias = $('#ddl_categorias').val();
    var precio = $('#precio').val();
    var fechacreacion = moment().format("YYYY-MM-DD, hh:mm:ss");
    var fechaModificacion = moment().format("YYYY-MM-DD, hh:mm:ss");
    var usuarioCreacion = $('#lb').attr("dataUser");
    var usuarioModificacion = $('#lb').attr("dataUser");



    if ((nombrep !== "") && (marca !== "") && (cantidad !== "") && (clave !== "") && (ddl_categorias !== null)) {

        sendProdRequestPOST({Clave: clave, NombreProducto: nombrep, IdCategoria: ddl_categorias, Marca: marca, Cantidad: cantidad, Precio: precio, FechaCreacion: fechacreacion, UsuarioCreacion: usuarioCreacion, FechaModificacion: fechaModificacion, UsuarioModificacion: usuarioModificacion}, "../EiseiLocal/CrearProducto");
    } else {
        var mensaje = "Completa los campos vacíos";
        showPopupMessageGeneric("Intenta de nuevo", mensaje);
    }
}

function sendProdRequestPOST(fobj, actionURL) {
    $.ajax({
        type: "POST",
        url: actionURL,
        data: fobj,
        async: true,
        success: function (data) {
            if (data.message === 'Registro') {
                console.log(data.object)
                var mensaje = "El Producto se registró con éxito";
                showPopupMessageGeneric("", mensaje);
                formulario.reset();
                location.reload();
            } else {
                var mensaje = "Request failed";
                showPopupMessageGeneric("Aviso", mensaje);
            }
        },
        error: function (jqxhr, settings, thrownError) {
            alert("Erro");
            console.log("jqxhr.responseText=" + jqxhr.responseText);
        },
        fail: function (jqXHR, textStatus) {
            alert("fail");
            console.log(">>sendRequestJQ(): thrownError:" + thrownError);
            console.log(">>sendRequestJQ(): jqXHR:" + jqXHR);
        }
    });
}


function showPopupMessageGeneric(tipo, menssage, show) {
        $(".proyecto-popup-message").removeClass("not-showing");
        $(".proyecto-popup-message").addClass("showing");
        $("#proyect").addClass("not-showing");
        $('#tipo').text(tipo);
        $('#mensajeError').text(menssage);
        if(show){
        $('#accept').hide();
    }
    }
function closePopupMessage() {
    $(".proyecto-popup-message").removeClass("showing");
    $(".proyecto-popup-message").addClass("not-showing");
}





function sendclaveRequestPOST() {

    $.ajax({
        type: "GET",
        url: "../EiseiLocal/GenerarClave",
        async: true,
        success: function (data) {
            $("#clave").val(data.obj.clave);
            console.log(data.obj.clave);

        },
        error: function (jqxhr, settings, thrownError) {
            alert("Erro");
            console.log("jqxhr.responseText=" + jqxhr.responseText);
        },
        fail: function (jqXHR, textStatus) {
            alert("fail");
            console.log(">>sendRequestJQ(): thrownError:" + thrownError);
            console.log(">>sendRequestJQ(): jqXHR:" + jqXHR);
        }
    });
}

function exportData(){
    /* Get the HTML data using Element by Id */
    var table = document.getElementById("tp");
 
    /* Declaring array variable */
    var rows = [];

    //iterate through rows of table
   for(var i=0,row; row = table.rows[i];i++){
        //rows would be accessed using the "row" variable assigned in the for loop
        //Get each cell value/column from the row
        column1 = row.cells[0].innerText;
        column2 = row.cells[1].innerText;
        column3 = row.cells[2].innerText;
        column4 = row.cells[3].innerText;
        column5 = row.cells[4].innerText;
        column6 = row.cells[5].innerText;

    /* add a new records in the array */
        rows.push(
            [
                column1,
                column2,
                column3,
                column4,
                column5,
                column6
            ]
        );

        }   csvContent = "data:text/csv;charset=utf-8,";
         /* add the column delimiter as comma(,) and each row splitted by new line character (\n) */
        rows.forEach(function(rowArray){
            row = rowArray.join(",");
            csvContent += row + "\r\n";
        });
 
        /* create a hidden <a> DOM node and set its download attribute */
        var encodedUri = encodeURI(csvContent);
        var link = document.createElement("a");
        link.setAttribute("href", encodedUri);
        link.setAttribute("download", "Producto");
        document.body.appendChild(link);
         /* download the data file named "Stock_Price_Report.csv" */
        link.click();
}






