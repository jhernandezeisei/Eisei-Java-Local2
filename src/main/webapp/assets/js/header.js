var rol='';
$(document).ready(function () {
    rol=$('#rol').attr("dataUser");
    console.log(rol);
     if (rol === "2") {
        $('#usuarios').hide();
    } else if (rol === "3"){
        $('#usuarios').hide();
        $('#productos').hide();
    }
   // clearTimeout();
  
});

function inicio(){
    window.open("../EiseiLocal/panel", "_self");
}

function usuarios(){
    window.open("../EiseiLocal/usuarios", "_self");
}

function productos(){
    window.open("../EiseiLocal/productos", "_self");
}
function catalogo(){
}


