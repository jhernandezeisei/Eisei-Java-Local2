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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="assets/css/customs-styles.css">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min" type="text/css"/>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link href="assets/css/usuarios.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">



        <title>Usuarios</title>
    </head>
    <body>
        <header>
            <jsp:include page="header.jsp"/>
        </header>

        <label id="lb" dataUser="${nom}"></label>
        <section class="vh-50">
            <div class="container">
                <div class="row d-flex justify-content-center align-items-center h-95">
                    <div class="col-lg-12 col-xl-11">
                        <div class="card">
                            <div class="card-body p-md-5">
                                <p class="text-center h1 fw-bold mb-3 mx-1 mx-md-3 mt-4">CREAR USUARIO</p>
                                <form class="row g-4" id="formulario">
                                    <div class="col-md-4">
                                        <label for="nombre" class="form-label">Nombre</label>
                                        <!--<input type="text" class="form-control" id="validationDefault01"  required>-->
                                        <input type="text" class="form-control" id="nombre" required>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="apellidosUser" class="form-label">Apellidos</label>
                                        <input type="text" class="form-control" name="apellidos" id="apellidosUser" required >
                                    </div>

                                    <div class="col-md-4">
                                        <label for="correo" class="form-label">Correo</label>
                                        <div class="input-group">
                                            <span class="fs-5 bi bi-envelope-fill input-group-text" id="inputGroupPrepend2"></span>
                                            <input type="email" class="form-control" name="correo" id="correo"  placeholder="ejemplo@gmail.com" aria-describedby="emailHelp" required>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="Genero" class="form-label">Género</label>
                                        <select class="form-select" name="Genero" id="Genero" required>
                                            <option selected disabled value="">Seleccionar género</option>
                                            <option>Femenino</option>
                                            <option>Masculino</option>
                                        </select>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="FechaNac" class="form-label">Fecha de Nacimiento</label>
                                        <input type="date" class="form-control" name="FechaNac" id="FechaNac" required>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="Estado" class="form-label">Estado</label>

                                        <div class="form-check form-switch">
                                            <input class="form-check-input" type="checkbox" role="switch" id="check">
                                            <label class="form-check-label" for="flexSwitchCheckDefault">Usuario activo/inactivo</label>
                                        </div>

                                        <!-- <div class="input-group">
                                            <span class="fs-5 bi bi-toggles input-group-text" id="inputGroupPrepend2"></span>
                                            <input type="text" class="form-control" name="Estado" id="Estado"required>
                                        </div>-->
                                    </div>

                                    <div class="col-md-4">
                                        <label for="usuario" class="form-label">Usuario</label>
                                        <div class="input-group">
                                            <span class="fs-5 bi bi-person-plus-fill input-group-text" id="inputGroupPrepend2"></span>
                                            <input type="text" class="form-control" name="usuario" id="usuario"  aria-describedby="inputGroupPrepend2" required>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="contrasena" class="form-label">Contraseña</label>
                                        <div class="input-group">
                                            <span class="fs-5 bi bi-lock-fill input-group-text" id="inputGroupPrepend2"></span>
                                            <input type="password" class="form-control" name="contrasena" id="contrasena"  aria-describedby="passwordHelpInline" required>
                                            <!--<input type="password" class="form-control" id="contraseña" aria-describedby="passwordHelpInline" >-->
                                        </div>
                                    </div>
                                </form>
                                <div class="col-lg-12">
                                    <button type="submit" class="btn" style="background-color: #034e52 !important;"onclick="registrar()">Registrar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <section class="solistica-popup-message">
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
        <script type="text/javascript" src="assets/js/bootstrap-select.min.js"></script>
        <script type="text/javascript" src="assets/js/custom-scripts.js"></script>
        <script src="assets/js/moment.min.js" type="text/javascript"></script>
        <script src="assets/js/usuarioC.js" type="text/javascript"></script>
    </body>
</html>


