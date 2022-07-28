$(document).ready(function () {
    destroyTable();
    sendTablaUserRequestPOST();
});
var fila;

function editar(id) {
    alert('Presionando el boton editar');
    console.log(id);
}

function registrar() {
    var genero = '';
    var edo = 0;
    var rol = 0;
    var nombre = $('#nombre').val();
    var apellidos = $('#apellidosUser').val();
    var correo = $('#correo').val();
    var gen = $('#Genero').val();
    var fechaNac = $('#FechaNac').val();
    var usuario = $('#usuario').val();
    var contrasena = $('#contrasena').val();
    var fechacreacion = moment().format("YYYY-MM-DD, hh:mm:ss");
    var fechaModificacion = moment().format("YYYY-MM-DD, hh:mm:ss");
    var usuarioCreacion = $('#lb').attr("dataUser");
    var usuarioModificacion = $('#lb').attr("dataUser");
    var estado = document.getElementById("check").checked;
    var roles = $('#Rol').val();

    if (gen === "Femenino") {
        genero = "f";
    } else if (gen === "Masculino") {
        genero = "m";
    }
    if (estado === false) {
        edo = 0;
    } else if (estado === true) {
        edo = 1;
    }
    if (roles === 'Administrador') {
        rol = 1;
    } else if (roles === 'Operador') {
        rol = 2;
    } else if (roles === 'Ventas') {
        rol = 3;
    }
    if ((nombre !== "") && (apellidos !== "") && (correo !== "") && (usuario !== "") && (contrasena !== "") && (genero !== null) && (fechaNac !== "") && (roles !== null)) {

        sendUserRequestPOST({Usuario: usuario, Contrasena: contrasena, Nombre: nombre, Apellidos: apellidos, Genero: genero, FechaNacimiento: fechaNac, Correo: correo, Estado: edo, UsuarioCreacion: usuarioCreacion, UsuarioModificacion: usuarioModificacion, FechaCreacion: fechacreacion, FechaModificacion: fechaModificacion, IdRol: rol}, "../EiseiLocal/CrearUsuario");
    } else {
        var mensaje = "Completa los campos vacíos";
        showPopupMessageGeneric("Intenta de nuevo", mensaje);
    }
}

function delete_row(row) {

    var table = $("#tu");
    table.addClass("open");

    table.find(".mb-control-yes").on("click", function () {
        table.removeClass("open");
        $("#" + row).hide("slow", function () {
            $(this).remove();
        });
    });

}

function botonE(fobj, actionURL) {
    $.ajax({
        type: "POST",
        url: actionURL,
        data: fobj,
        async: true,
        success: function (data) {
            console.log(data);
            if (data.failure === 0) {
                destroyTable();
                location.reload();
                llenarTabla(data.object);
            } else {
                destroyTable();
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

function eliminar(id) {

    botonE({IdUsuario: id}, "../EiseiLocal/EliminarUsuario");
}

var table = null;
function llenarTabla(data) {
        $('#tu').dataTable().fnClearTable();
        $('#tu').dataTable().fnDestroy();
        var rateTable = $('#tu').DataTable({
            "searching": true,
            "ordering": true,
            "responsive": true,
            data: data,
            "columns": [
                {data: "id",
                    render: function (data) {
                        if (data == null || data == "") {
                            return "-";
                        } else {
                            return data;
                        }
                    }
                },
                {data: "usuario"},
                {data: "contrasena"},
                {data: "nombre"},
                {data: "apellidos"},
                {data: "genero"},
                {data: "fechaNacimiento"},
                {data: "correo"},
                {data: "fechaCreacion"},
                {data: "rol",
                    render: function (data) {
                        if (data === 1) {
                            return "Administrador";
                        } else if (data === 2) {
                            return "Operador";
                        } else if (data === 3) {
                            return "Ventas";
                        }
                    }
                },
                {data: "id",
                    render: function (data) {
                        return "<button onclick='editar(" + data + ")' class='btn btn-warning btn-edit ali'><i class='bi bi-pencil-fill'></i></button> " +
                                "<button onclick='eliminar(" + data + ")'  class='btn btn-danger btn-delete'>  <i class='bi bi-trash-fill'></i> </button>";
                    }
                },
            ],
            "columnDefs": [
                {"className": "text-center", "targets": [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
                    orderable: true, "targets": [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}
            ],
            "processing": true
        });
        $("#tu").removeClass("dataTable");
    }


function destroyTable() {
    $("#tu").dataTable().fnDestroy();
    tablaUsuarios = $('#tu').DataTable({
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
            {"className": "text-center", "targets": [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
                orderable: false, "targets": [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}
        ],
        "processing": true
    });
    $(".th-sm").removeClass("sorting_asc");
    tablaUsuarios
            .clear()
            .draw();
}

function sendTablaUserRequestPOST() {
    $.ajax({
        type: "GET",
        url: "../EiseiLocal/TUsuarios",
        async: true,
        success: function (data) {

            if (data.object) {
                llenarTabla(data.object);
                console.log(data.object);
            } else {
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

function sendUserRequestPOST(fobj, actionURL) {
    $.ajax({
        type: "POST",
        url: actionURL,
        data: fobj,
        async: true,
        success: function (data) {
            if (data.message === 'Existe') {
                var mensaje = "El Usuario ya existe";
                showPopupMessageGeneric("Intenta de nuevo", mensaje);

            } else if (data.message === 'Registro') {
                var mensaje = "El Usuario se registró con éxito";
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
    $(".solistica-popup-message").removeClass("not-showing");
    $(".solistica-popup-message").addClass("showing");
    $("#autodespacho").addClass("not-showing");
    $('#tipo').text(tipo);
    $('#mensajeError').text(menssage);
    if (show) {
        $('#accept').hide();
    }
}

function closePopupMessage() {
    $(".solistica-popup-message").removeClass("showing");
    $(".solistica-popup-message").addClass("not-showing");

}


