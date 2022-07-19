<%-- 
    Document   : header
    Created on : 8/07/2022, 12:33:01 PM
    Author     : karla.calderon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>

    <body style=" background-color: #c4d7e1;"> 
        <div class="container-fluid" style="background-color: #001141">
            <nav class="navbar navbar-expand-lg navbar-dark container" style="background-color: #001141">
                <div class="container-fluid">
                    <a class="navbar-brand text-white" href="#">
                        <i class="fs-4 fs-3 bi bi-code-square"></i><span class="fs-4">E<span class="d-none d-sm-inline">isei</span></span>
                    </a>
                    
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="inicio.jsp">
                                    <i class="fs-4 bi bi-house-door"></i><span class="ms-1 fs-6">Inicio</span></a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" id="usuarios" role="button" onclick="Ingresar()">
                                    <i class="fs-4 bi bi-people"></i><span class="ms-1 fs-6">Usuarios</span></a>
                            </li>

                            <li class="nav-item dropdown">

                                <a class="nav-link dropdown-toggle " id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fs-4 bi bi-box-arrow-in-left"></i></i><span class="ms-1 fs-6">Cerrar Sesión</span>
                                </a>
                                <ul class="dropdown-menu text-center" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" id="user" name="user">${nom}</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="redirect.jsp">Salir</a></li>

                                </ul>
                            </li>
                        </ul> 
                    </div>
                                    
                </div>
            </nav>
        </div>


        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap-select.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery-3.3.1.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <script src="assets/js/header.js" type="text/javascript"></script>
    </body>
</html>
