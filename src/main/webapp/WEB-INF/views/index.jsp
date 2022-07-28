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
        
        <link rel="stylesheet" href="assets/css/customs-styles.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap-min.css">
        <link href="assets/css/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="assets/css/bootstrap-icons.css" type="text/css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Prueba de Eisei</title>
    </head>
    <body style="background-color: #c4d7e1 !important;">

        <div class="align-items-center align-content-center" style="padding: 130px;">
            <div class="row  d-flex align-items-center justify-content-center" ">

                <div class="card col-md-8 col-lg-6 col-xl-12  text-center" style="color: white; width: 25rem; height: 27rem; padding-top: 52px; padding-bottom: 20px; background-color: #001141 !important" >   
                    <div class=" form-group text-center">
                        <img src="assets/img/usuario1.png" height="100" width="100" />   
                    </div>
                    
                    <form>
                    <div >
                        <!--<label for="usuario" class="form-label text-center"style="font-family: 'Alegreya Sans', sans-serif; font-weight: bold;">Usuario</label>-->
                        <div class="input-group">
                            <span class="fs-5 bi bi-person-plus-fill input-group-text" id="inputGroupPrepend2"></span>
                            <input type="text" class="form-control" name="txtusuario" id="txtusuario" placeholder="                        Usuario">
                        </div>
                    </div>
                    <div>
                        <label for="contraseña" class="form-label text-center"style="font-family: 'Alegreya Sans', sans-serif; font-weight: bold;"></label>
                        <div class="input-group">
                            <span class="fs-5 bi bi-lock-fill input-group-text" id="inputGroupPrepend2"></span>
                            <input type="password" class="form-control" name="txtpass" id="txtpass" placeholder="                     Contraseña">
                            <!--<input type="password" class="form-control" id="contraseña" aria-describedby="passwordHelpInline" >-->
                        </div>
                    </div>

                    <div class="mb-3 form-check" style="font-family: 'Alegreya Sans', sans-serif; font-weight: bold;">
                        
                    </div>
                    <!--<a class="btn btn-primary" href="prueba.jsp" role="button">Link</a-->
                    
                    </form>
                    <button class="btn" type="submit"  style="color: white; font-family: 'Alegreya Sans', sans-serif; background-color: #034e52 !important;"onclick="buscar()">Ingresar</button>
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
        <script src="assets/js/sweetalert.min.js"></script>
        <script type="text/javascript" src="assets/js/custom-scripts.js"></script>
        <script src="assets/js/Loggin.js" type="text/javascript"></script>
    </body>
</html>

