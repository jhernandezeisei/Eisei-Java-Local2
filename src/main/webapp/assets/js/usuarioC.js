function registrar() {
    var genero = '';
    var edo = 0;
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
    if ((nombre !== "") && (apellidos !== "") && (correo !== "") && (usuario !== "") && (contrasena !== "") && (genero !== null) && (fechaNac !== "")) {

        sendUserRequestPOST({Usuario: usuario, Contrasena: contrasena, Nombre: nombre, Apellidos: apellidos, Genero: genero, FechaNacimiento: fechaNac, Correo: correo, Estado: edo, UsuarioCreacion: usuarioCreacion, UsuarioModificacion: usuarioModificacion, FechaCreacion: fechacreacion, FechaModificacion: fechaModificacion}, "../EiseiLocal/CrearUsuario");
    } else {
        var mensaje = "Completa los campos vacíos";
        showPopupMessageGeneric("Intenta de nuevo", mensaje);
    }
}

function sendUserRequestPOST(fobj, actionURL) {
    $.ajax({
        type: "POST",
        url: actionURL,
        data: fobj,
        async: true,
        success: function (data) {
            
            if (data.message==='Existe') {
                var mensaje = "El Usuario ya existe";
                showPopupMessageGeneric("Intenta de nuevo", mensaje);

            } else if (data.message === 'Registro') {
                console.log(data.object)
                var mensaje = "El Usuario se registró con éxito";
                showPopupMessageGeneric("", mensaje);
                formulario.reset();
            } else  {
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


