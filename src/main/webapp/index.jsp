<%-- 
    Document   : index
    Created on : 8/07/2022, 10:10:55 AM
    Author     : karla.calderon
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="#">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="assets/css/customs-styles.css">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min" type="text/css"/>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link href="assets/css/estilos.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Prueba de Eisei</title>
    </head>
    <body>
        <div id="contenedor">       
            <div class="align-items-center">
                <div class="row justify-content-md-center">
                    <div class="card" style="width: 20rem" >   
                        <div class="form-group text-center">
                            <img src="assets/img/perfil-del-usuario.png" height="100" width="100" />   
                        </div>                     
                        <div class="form-group text-center">
                            <label for="usuario" class="form-label">Usuario</label>
                            <input type="text" class="form-control" id="txtusuario">
                        </div>
                        <div class="form-group text-center">
                            <label for="contraseña" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="txtpass" >
                        </div>
                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="recordarPass">
                            <label class="form-check-label" for="exampleCheck1">Recordar contraseña</label>
                        </div>
                        <!--<a class="btn btn-primary" href="prueba.jsp" role="button">Link</a>-->
                        <button type="submit" class="btn btn-primary" onclick="buscar()">Ingresar</button>
                    </div>
                </div>
            </div>
        </div>
        
        <section class="solistica-popup-message">
		<div class="solistica-popup-container">
			<div class="box-popup">
				<div class="popup-message">
					<span class="title-popup" id="title-error">Aviso</span>
					<span class="message-popup" id="mensajeError"></span>
				</div>
				<div class="popup-buttons">
                                        <a id="accept" href="#" class="solistica-btn btn-orange-light btn-small" onclick="closePopupMessage()"> Aceptar</a>
				</div>
			</div>
		</div>
	</section>

        <script type="text/javascript" src="assets/js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap-select.min.js"></script>
        <script type="text/javascript" src="assets/js/custom-scripts.js"></script>
        <script src="assets/js/Loggin.js" type="text/javascript"></script>
    </body>
</html>

