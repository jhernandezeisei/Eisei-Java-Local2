<%-- 
    Document   : productos
    Created on : 28/07/2022, 10:48:19 AM
    Author     : karla.calderon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/customs-styles.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap-min.css">
        <link rel="stylesheet" href="assets/css/productos.css">
        <link rel="stylesheet" href="assets/css/bootstrap-icons.css" type="text/css">
        <title>Productos</title>
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
                                <p class="text-center h1 fw-bold mb-3 mx-1 mx-md-3 mt-4">CREAR PRODUCTO</p>
                                <form class="row g-4" id="formulario">
                                    <div class="col-md-4">
                                        <label for="nombrep" class="form-label">Nombre del Producto</label>
                                        <!--<input type="text" class="form-control" id="validationDefault01"  required>-->
                                        <input type="text" style="text-transform:uppercase;" onkeyup="javascript:this.value=this.value.toUpperCase();"
                                               class="form-control" id="nombrep" required>
                                    </div>

                                    <div class="col-md-4">
                                        <label for="marca" class="form-label">Marca</label>
                                        <input type="text" class="form-control" id="marca" required >
                                    </div>
                                    <div class="col-md-4">
                                        <label for="precio" class="form-label">Precio</label>
                                        <input type="input" name="ESP" onKeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" class="form-control"  id="precio" required min = "0" step="">
                                        <!--<input value=""  class="form-control" min="0" step="0.01" id="precio" required>-->
                                    </div>
                                    <div class="col-md-4">
                                        <label for="cantidad" class="form-label">Cantidad</label>
                                        <input value="" type="number" class="form-control" min="0" step=""id="cantidad" required >
                                    </div>
                                    <div class="col-md-4">
                                        <label for="clave" class="form-label">Clave</label>
                                        <input type="text" class="form-control" id="clave" required disabled >
                                    </div>
                                    <div class="col-md-4">
                                        <label for="ddl_categorias" class="form-label">Tipo Producto</label>
                                        <select class="form-select" id="ddl_categorias" required>
                                            <option selected disabled value="0">Seleccionar tipo de producto</option>
<!--                                            <option>Telefonos</option>
                                            <option>Televisores</option>-->
                                        </select>
                                    </div>
                                </form>
                                <br>
                                <div class="col-lg-12">
                                    <button type="submit" class="boton btn" id="registro" style="background-color: #034e52 !important;"onclick="registrarP()">Registrar</button>
                                     <button type="submit" class="boton1 btn btn-warning" id="edi" onclick="modificar()">Editar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <center>
                <div class="cuerpo" >
                    <div class="table-responsive-lg ">
                        <table class="table table-hover table-bordered " border="1" id="tp" class="display" style="width:100%" align="center">
                            <thead>
                                <tr>
                                    <th>Clave</th>
                                    <th>Producto</th>
                                    <th>Marca</th>
                                    <th>Precio</th>
                                    <th>Stock</th>
                                    <th>Categoria</th>
                                    <th>Acciones</th>
                                    <button onclick="exportData()">
                                <span class="glyphicon glyphicon-download"></span>
                                Descargar Excel</button>
                                </tr>
                            </thead>
                        </table>
                    </div>

                </div>
            </center>
        </section>


     <section class="proyecto-popup-message">
        <div class="proyecto-popup-container">
            <div class="box-popup">
                <div class="popup-message">
                    <span class="title-popup" id="title-error">Aviso</span>
                    <span class="message-popup" id="mensajeError"></span>
                </div>
                <div class="popup-buttons">
                                        <a id="accept" href="#" class="proyecto-btn btn-green-light btn-small" onclick="closePopupMessage()"> Aceptar</a>
                </div>
            </div>
        </div>
    </section>

        <script type="text/javascript" src="assets/js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/js/custom-scripts.js"></script>
        <script src="assets/js/datatables.min.js"></script>
        <script src="assets/js/sweetalert.min.js"></script>
        <script src="assets/js/moment.min.js" type="text/javascript"></script>
        <script src="assets/js/productos.js" type="text/javascript"></script>
    </body>
</html>
