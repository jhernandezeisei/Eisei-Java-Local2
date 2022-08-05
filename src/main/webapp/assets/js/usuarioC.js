var rateTable;
$(document).ready(function () {
    
    document.getElementById('edi').disabled = true;
    var myToUpperText = $('.toUpperText');
    myToUpperText.focusout(function () {
        $(this).val($(this).val().toUpperCase());
    });
    'use strict';
                const forms = document.querySelectorAll('.formu');
                Array.from(forms).forEach(form => {
                    form.addEventListener('submit', event => {
                            event.preventDefault();
                            event.stopPropagation();
                    }, false);
                });
    destroyTable();
    sendTablaUserRequestPOST();

});

function exportData() {
    var table = $('#tu').DataTable();
    var rowData = table.rows({selected: true}).data().toArray();
   if (rowData.length > 0) {
        //   showPopupSpinner();
        createXLSX(rowData);
        //      closePopupSpinner();
    } else {
        var mensaje = "No se puede realizar la exportación si no hay registros de historico de viajes en la tabla.";
        //alerta de error  
        showPopupMessageGeneric("Aviso", mensaje);
    }
}



function createXLSX(data) {
    var type_distribution = data[0].type_distribution;
    // const header = ["ID Viaje", "ID Ruta", "Operador", "Vehiculo", "Cumplimiento a tiempo de transito", "Cumplimiento de agenda"];
    const header = type_distribution === " " ?
            ["Id",
                "Usuario",
                "Contraseña",
                "Nombre",
                "Apellidos",
                "Género",
                "Fecha de Nacimiento",
                "Correo",
                "Fecha de Creacion",
                "Rol"]
            :
            ["Id",
                "Usuario",
                "Contraseña",
                "Nombre",
                "Apellidos",
                "Género",
                "Fecha de Nacimiento",
                "Correo",
                "Fecha de Creacion",
                "Rol"];
    const dataHT = [];
    //generamos el array con la informacion a mostrar
    for (let index = 0; index < data.length; index++) {
    const element = type_distribution === "" ?     
               [data[index].id,
                    data[index].usuario,
                    data[index].contrasena,
                    data[index].nombre,
                    data[index].apellidos,
                    data[index].genero,
                    data[index].fechaNacimiento,
                    data[index].correo,
                    data[index].fechaCreacion,
                    data[index].rol]
                :
             
               [data[index].id,
                    data[index].usuario,
                    data[index].contrasena,
                    data[index].nombre,
                    data[index].apellidos,
                    data[index].genero,
                    data[index].fechaNacimiento,
                    data[index].correo,
                    data[index].fechaCreacion,
                    data[index].rol];
        dataHT.push(element);
    }
   const workbook = new ExcelJS.Workbook();
    let worksheet = workbook.addWorksheet('Travels_Report');
   let titleRow = worksheet.addRow(["Registro de Usuarios"]);
    worksheet.mergeCells('A1:J1');
   titleRow.eachCell((cell, number) => {
        cell.fill = {
            type: 'pattern',
            pattern: 'solid',
            fgColor: {argb: '001141'}, //fondo de celda
            bgColor: {argb: 'ffffff'}//color letra
        };
        cell.alignment = {vertical: 'middle', horizontal: 'center'};
        cell.font = {name: 'times new roman', family: 4, size: 16, bold: true, color: {argb: 'ffffff'}};
    });
    //Add Header Row
   let headerRow = worksheet.addRow(header);
   //Filtros de Encabezado
    worksheet.autoFilter = ('A2:J2');

   //se edita los colores del header
     headerRow.eachCell((cell, number) => {
     cell.fill = {
     type: 'pattern',
     pattern: 'solid',
     fgColor: {argb: '001141'}, //fondo de celda
     bgColor: {argb: 'fffff'}//color letra
     };
     cell.border = {top: {style: 'thin'}, left: {style: 'thin'}, bottom: {style: 'thin'}, right: {style: 'thin'}};
     cell.alignment = {vertical: 'middle', horizontal: 'center'};
     cell.font = {color: {argb: 'ffffff'}};
     });
   //se agrega la informacion
    dataHT.forEach(d => {
        let row = worksheet.addRow(d);
        //centrar la info
        row.alignment = {vertical: 'middle', horizontal: 'left'};
    });

   worksheet.getColumn(1).width = 13;
    worksheet.getColumn(2).width = 13;
    worksheet.getColumn(3).width = 13;
    worksheet.getColumn(4).width = 13;
    worksheet.getColumn(5).width = 13;
    worksheet.getColumn(6).width = 13;
    worksheet.getColumn(7).width = 13;
    worksheet.getColumn(8).width = 13;
    worksheet.getColumn(9).width = 13;
    worksheet.getColumn(10).width = 13;
   //Generate Excel File with given name
    workbook.xlsx.writeBuffer().then((data) => {
        var blob = new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
        var link = document.createElement('a');
        link.href = window.URL.createObjectURL(blob);
        link.download = 'Usuarios' + '.xlsx';
        link.click();
    });
}

function editar() {
    document.getElementById('edi').disabled = false;
    document.getElementById('registro').disabled = true;
    $('#tu tr').on('click', function () {
        var idU = $(this).find('td:eq(0)').text();
        $('#usuario').val($(this).find('td:eq(1)').text());
        $('#contrasena').val($(this).find('td:eq(2)').text());
        $('#nombre').val($(this).find('td:eq(3)').text());
        $('#apellidosUser').val($(this).find('td:eq(4)').html());
        $('#Genero').val($(this).find('td:eq(5)').text());
        $('#FechaNac').val($(this).find('td:eq(6)').text());
        $('#correo').val($(this).find('td:eq(7)').text());
        $('#Rol').val($(this).find('td:eq(9)').text());
        $("#check").prop("checked", true);
        $('#idUser').val(idU);
    });
}

function modificar() {
    var id = $('#idUser').val().trim();
    var usuario = $('#usuario').val().trim();
    var contrasena = $('#contrasena').val().trim();
    var nombre = $('#nombre').val().trim();
    var apellido = $('#apellidosUser').val().trim();
    var gen = $('#Genero').val();
    var fechaN = $('#FechaNac').val();
    var correo = $('#correo').val().trim();
    var roles = $('#Rol').val();
    var genero = '';
    var edo = 0;
    var rol = 0;
    var usuarioModificacion = $('#lb').attr("dataUser");
    var fechaModificacion = moment().format("YYYY-MM-DD, hh:mm:ss");
    var estado = document.getElementById("check").checked;

    if (gen === "FEMENINO") {
        genero = "f";
    } else if (gen === "MASCULINO") {
        genero = "m";
    }
    if (estado === false) {
        edo = 0;
    } else if (estado === true) {
        edo = 1;
    }
    if (roles === 'ADMINISTRADOR') {
        rol = 1;
    } else if (roles === 'OPERADOR') {
        rol = 2;
    } else if (roles === 'VENTAS') {
        rol = 3;
    }
    if ((nombre !== "") && (apellido !== "") && (correo !== "") && (usuario !== "") && (contrasena !== "") && (gen !== null) && (fechaN !== "") && (roles !== null)) {
        sendEditarRequest({IdUsuario: id, Usuario: usuario, Contrasena: contrasena, Nombre: nombre, Apellidos: apellido, Genero: genero, FechaNacimiento: fechaN, Correo: correo, Estado: edo, UsuarioModificacion: usuarioModificacion, FechaModificacion: fechaModificacion, IdRol: rol}, "../EiseiLocal/ModificarUsuario");
    } else {
    }
}

function sendEditarRequest(fobj, actionURL) {
    $.ajax({
        type: "POST",
        url: actionURL,
        data: fobj,
        async: true,
        success: function (data) {
            if (data.message === 'Editado') {
                var mensaje = "El Usuario se editó correctamente";
                showPopupMessageGeneric("El Usuario se editó correctamente", mensaje);
                formulario.reset();
                document.getElementById('edi').disabled = true;
                document.getElementById('registro').disabled = false;
                destroyTable();
                sendTablaUserRequestPOST();
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

function registrar() {
    var genero = '';
    var edo = 0;
    var rol = 0;
    var nombre = $('#nombre').val().trim();
    var apellidos = $('#apellidosUser').val().trim();
    var correo = $('#correo').val().trim();
    var gen = $('#Genero').val();
    var fechaNac = $('#FechaNac').val();
    var usuario = $('#usuario').val().trim();
    var contrasena = $('#contrasena').val().trim();
    var fechacreacion = moment().format("YYYY-MM-DD, hh:mm:ss");
    var fechaModificacion = moment().format("YYYY-MM-DD, hh:mm:ss");
    var usuarioCreacion = $('#lb').attr("dataUser");
    var usuarioModificacion = $('#lb').attr("dataUser");
    var estado = document.getElementById("check").checked;
    var roles = $('#Rol').val();
    if (gen === "FEMENINO") {
        genero = "f";
    } else if (gen === "MASCULINO") {
        genero = "m";
    }
    if (estado === false) {
        edo = 0;
    } else if (estado === true) {
        edo = 1;
    }
    if (roles === 'ADMINISTRADOR') {
        rol = 1;
    } else if (roles === 'OPERADOR') {
        rol = 2;
    } else if (roles === 'VENTAS') {
        rol = 3;
    }
    if ((nombre !== "") && (apellidos !== "") && (correo !== "") && (usuario !== "") && (contrasena !== "") && (genero !== null) && (fechaNac !== "") && (roles !== null)) {
        sendUserRequestPOST({Usuario: usuario, Contrasena: contrasena, Nombre: nombre, Apellidos: apellidos, Genero: genero, FechaNacimiento: fechaNac, Correo: correo, Estado: edo, UsuarioCreacion: usuarioCreacion, UsuarioModificacion: usuarioModificacion, FechaCreacion: fechacreacion, FechaModificacion: fechaModificacion, IdRol: rol}, "../EiseiLocal/CrearUsuario");
      
    } else {
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
            if (data.failure === 0) {
                destroyTable();
                sendTablaUserRequestPOST();
            } else {
                destroyTable();
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
    rateTable = $('#tu').DataTable({
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
            {data: "genero",
                render: function (data) {
                    if (data === "f") {
                        return "FEMENINO";
                    } else if (data === "m") {
                        return "MASCULINO";
                    }
                }
            },
            {data: "fechaNacimiento"},
            {data: "correo"},
            {data: "fechaCreacion"},
            {data: "rol",
                render: function (data) {
                    if (data === 1) {
                        return "ADMINISTRADOR";
                    } else if (data === 2) {
                        return "OPERADOR";
                    } else if (data === 3) {
                        return "VENTAS";
                    }
                }
            },
            {data: "id",
                render: function (data) {
                    return "<button onclick='editar(" + data + ")' class='editar btn btn-warning btn-edit ali'><i class='bi bi-pencil-fill'></i></button> " +
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
                // swal("El usuario ya existe", "You clicked the button!", "error");
                showPopupMessageGeneric("Intenta de nuevo", mensaje);
            } else if (data.message === 'Registro') {
                var mensaje = "El Usuario se registró con éxito";
                showPopupMessageGeneric("", mensaje);
                formulario.reset();
                destroyTable();
                sendTablaUserRequestPOST();
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


