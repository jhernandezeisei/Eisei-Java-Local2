var usuario='';
var contraseña='';

function buscar(){
    usuario=$('#txtusuario').val();
    contraseña=$('#txtpass').val();
    
    if(usuario===""){
        var mensaje = "Complete el campo de usuario";
        //alerta de error  
        showPopupMessageGeneric("Aviso", mensaje);
    }else if (contraseña==="") {
        var mensaje = "Complete el campo de contraseña";
        //alerta de error  
        showPopupMessageGeneric("Aviso", mensaje);
    }else
        sendRequestPOSTloggin({Usuario: usuario, Contrasena: contraseña}, "../EiseiLocal/Userlogin", usuario);
        
    }

function sendRequestPOSTloggin(fobj, actionURL, user) {
    $.ajax({
        type: "POST",
        url: actionURL,
        data: fobj,
        async: true,
        success: function (data) {
            if (data==='Ingreso') {
                    window.open("usuarios.jsp", "_self");
                } else {
                var mensaje = "Usuario incorrecto";
                    //alerta de error  
                showPopupMessageGeneric("Aviso", mensaje);
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

function showPopupMessageGeneric(tipo, menssage, show) {
        $(".solistica-popup-message").removeClass("not-showing");
        $(".solistica-popup-message").addClass("showing");
        $("#autodespacho").addClass("not-showing");
        $('#tipo').text(tipo);
        $('#mensajeError').text(menssage);
        if(show){
        $('#accept').hide();
    }
    }
    
function closePopupMessage() {
    $(".solistica-popup-message").removeClass("showing");
    $(".solistica-popup-message").addClass("not-showing");

}


