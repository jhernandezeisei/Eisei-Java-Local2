<%-- 
    Document   : usuarios
    Created on : 8/07/2022, 01:17:43 PM
    Author     : karla.calderon
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/customs-styles.css">
        <link href="assets/css/usuarios.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap-min.css">
        <link rel="stylesheet" href="assets/css/bootstrap-icons.css" type="text/css">



        <title>Usuarios</title>
    </head>
    <body>
        <header>
            <jsp:include page="header.jsp"/>
        </header>

        <label id="lb" dataUser="${nom}"></label>
        <input id="idUser" style="display: none">
        <section class="vh-50">
            <div class="container">
                <div class="row d-flex justify-content-center align-items-center h-95">
                    <div class="col-lg-12 col-xl-11">
                        <div class="card">
                            <div class="card-body p-md-5">
                                <p class="text-center h1 fw-bold mb-3 mx-1 mx-md-3 mt-4">CREAR USUARIO</p>
                                <form class="row g-4 formu" id="formulario">
                                    <div class="col-md-4">
                                        <label for="nombre" class="form-label">Nombre</label>
                                        <input type="text" class=" toUpperText form-control" id="nombre" required pattern="[A-ZÁÉÍÓÚ .-]{3,50}" title="Ingresa sólo letras">
                                    </div>

                                    <div class="col-md-4">
                                        <label for="apellidosUser" class="form-label">Apellidos</label>
                                        <input type="text" class="toUpperText form-control" name="apellidos" id="apellidosUser" required pattern="[A-ZÁÉÍÓÚ .-]{3,50}" title="Ingresa sólo letras">
                                    </div>

                                    <div class="col-md-4">
                                        <label for="correo" class="form-label">Correo</label>
                                        <div class="input-group">
                                            <span class="fs-5 bi bi-envelope-fill input-group-text" id="inputGroupPrepend2"></span>
                                            <input type="email" class="toUpperText form-control " name="correo" id="correo"  placeholder="ejemplo@gmail.com" aria-describedby="emailHelp" maxlength="70" required 
                                                   pattern="[a-zA-Z0-9_]([\.]?[a-zA-Z0-9])+@[a-zA-Z0-9]([^@&%$\/()=?¿!.,:;]|\d)+[a-zA-Z0-9][\.][a-zA-Z]{2,4}([\.][a-zA-Z]{2})?" title="Ingresa un correo válido. Ej. eisei@gmail.com:">
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="Genero" class="form-label">Género</label>
                                        <select class="form-select " name="Genero" id="Genero" required >
                                            <option selected disabled  value="">SELECCIONAR GÉNERO</option>
                                            <option>FEMENINO</option>
                                            <option>MASCULINO</option>
                                        </select>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="FechaNac" class="form-label">Fecha de Nacimiento</label>
                                        <input type="date" class="form-control " name="FechaNac" id="FechaNac" required>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="Estado" class="form-label">Estado</label>

                                        <div class="form-check form-switch">
                                            <input class="form-check-input" type="checkbox" role="switch" id="check">
                                            <label class="form-check-label" for="flexSwitchCheckDefault">Usuario activo/inactivo</label>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="usuario" class="form-label">Usuario</label>
                                        <div class="input-group">
                                            <span class="fs-5 bi bi-person-plus-fill input-group-text" id="inputGroupPrepend2"></span>
                                            <input type="text" class="form-control" name="usuario" id="usuario"  aria-describedby="inputGroupPrepend2" maxlength="50" required>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="contrasena" class="form-label">Contraseña</label>
                                        <div class="input-group">
                                            <span class="fs-5 bi bi-lock-fill input-group-text" id="inputGroupPrepend2"></span>
                                            <input type="password" class="form-control" name="contrasena" id="contrasena"  aria-describedby="passwordHelpInline" maxlength="50" required>
                                            <!--<input type="password" class="form-control" id="contraseña" aria-describedby="passwordHelpInline" >-->
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="Rol" class="form-label">Rol</label>
                                        <select class="form-select" name="Rol" id="Rol" required>
                                            <option selected disabled value="">SELECCIONAR ROL</option>
                                            <option>ADMINISTRADOR</option>
                                            <option>OPERADOR</option>
                                            <option>VENTAS</option>
                                        </select>
                                    </div>

                                    <div class="col-xl-12">
                                        <button type="submit" class="boton btn" id="registro" style="background-color: #034e52 !important;"  onclick="registrar()">Registrar</button> 
                                       <!-- <button type="reset" class="boton2 bi bi-x-circle btn btn-danger" id="cancelar"></button>       -->
                                       <button type="submit" class="boton1 btn btn-warning" id="edi" onclick="modificar()">Editar</button>
                                    </div>                                    
                                </form>
                                <div class="col-xl-12">
                                    
                                </div>
                                <br>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
 
            <center>
                <div class="cuerpo" >
                    <div class="table-responsive-lg">
                        <button type="button" class="export btn btn-size" style="background-color: #034e52 !important; color: white" onclick=" exportData()"> Exportar </button>
                        <table class="table table-hover table-bordered" border="1" id="tu" class="display" style="width:100%" aling="center">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Usuario</th>                
                                    <th>Contrasena</th>
                                    <th>Nombre</th>
                                    <th>Apellidos</th>
                                    <th>Genero</th>                        
                                    <th>Fecha de Nacimiento</th>
                                    <th>Correo</th>                       
                                    <th>Fecha de Creacion</th>
                                    <th>Rol</th>
                                    <th>Acciones</th>
                                   
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>

                </div>
            </center>
        </section>

        <section class="solistica-popup-message ">
            <div class="solistica-popup-container">
                <div class="box-popup">
                    <div class="popup-message">
                        <span class="title-popup" id="title-error">Aviso</span>
                        <span class="message-popup" id="mensajeError"></span>
                    </div>
                    <div class="popup-buttons">
                        <a id="accept" class="solistica-btn btn-orange-light btn-small" href="#" onclick="closePopupMessage()"> Aceptar</a>
                    </div>
                </div>
            </div>
        </section>
        
        <script type="text/javascript" src="assets/js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/js/custom-scripts.js"></script>
        <script src="assets/js/datatables.min.js"></script>
        <script src="assets/js/sweetalert.min.js"></script>
        <script src="assets/js/exceljs.min.js" type="text/javascript"></script>
        <script src="assets/js/moment.min.js" type="text/javascript"></script>
        <script src="assets/js/usuarioC.js" type="text/javascript"></script>
    </body>
</html>


