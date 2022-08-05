function showPopupMessage(){
    $(".proyecto-popup").removeClass("not-showing");
    $(".proyecto-popup").addClass("showing");
    $("#proyect").addClass("not-showing");

}

function closePopupMessage(){
    $(".proyecto-popup").removeClass("showing");
    $(".solistica-popup").addClass("not-showing");

}

function showPopupMessageAutoinspeccion(){
    $("#proyect").removeClass("not-showing");
    $("#proyect").addClass("showing");
}
