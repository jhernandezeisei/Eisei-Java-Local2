function showPopupMessage(){
	$(".solistica-popup").removeClass("not-showing");
	$(".solistica-popup").addClass("showing");
	$("#autodespacho").addClass("not-showing");
	
}

function closePopupMessage(){
	$(".solistica-popup").removeClass("showing");
	$(".solistica-popup").addClass("not-showing");
	
}

function showPopupMessageAutoinspeccion(){
	$("#autodespacho").removeClass("not-showing");
	$("#autodespacho").addClass("showing");
}

