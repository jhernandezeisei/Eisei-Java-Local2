<%-- 
    Document   : usuarios
    Created on : 8/07/2022, 01:17:43 PM
    Author     : karla.calderon
--%>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="assets/css/usuarios.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    


    <title>Usuarios</title>
</head>
<body>
    <header>
        <jsp:include page="WEB-INF/views/header.jsp" flush="true"/>
    </header>
    <section class="vh-50">
        <div class="container">
            <div class="row d-flex justify-content-center align-items-center h-95">
                <div class="col-lg-12 col-xl-11">
                    <div class="card">
                        <div class="card-body p-md-5">
                            <p class="text-center h1 fw-bold mb-3 mx-1 mx-md-3 mt-4">CREAR USUARIO</p>
                            <form class="row g-4">
                                <div class="col-md-4">
                                    <label for="nombreUser" class="form-label">Nombre(s)</label>
                                    <input type="text" class="form-control" name="nombre" id="nombre" required>
                                </div>

                                <div class="col-md-4">
                                    <label for="apellidosUser" class="form-label">Apellidos</label>
                                    <input type="text" class="form-control" name="apellidos" id="apellidos"  required>
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
                                    <input type="date" class="form-control" name="FechaNac" id="FechaNac" required />
                                </div>

                                <div class="col-md-4">
                                    <label for="Estado" class="form-label">Estado</label>
                                    <div class="input-group">
                                        <span class="fs-5 bi bi-geo-alt-fill input-group-text" id="inputGroupPrepend2"></span>
                                        <input type="text" class="form-control" name="Estado" id="Estado" required>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <label for="usuario" class="form-label">Usuario</label>
                                    <div class="input-group">
                                        <span class="fs-5 bi bi-person-plus-fill input-group-text" id="inputGroupPrepend2"></span>
                                        <input type="text" class="form-control" name="usuario" id="usuario"  aria-describedby="inputGroupPrepend2" required>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <label for="contraseña" class="form-label">Contraseña</label>
                                    <div class="input-group">
                                        <span class="fs-5 bi bi-lock-fill input-group-text" id="inputGroupPrepend2"></span>
                                        <input type="password" class="form-control" name="contraseña" id="contraseña"  aria-describedby="passwordHelpInline" required>
                                        <!--<input type="password" class="form-control" id="contraseña" aria-describedby="passwordHelpInline" >-->
                                    </div>
                                </div>

                                <div class="col-12">
                                    <button class="btn" type="submit" name="registrar" id="registrar">Registrar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>


