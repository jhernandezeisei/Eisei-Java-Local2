package com.eisei.eiseilocal.controller;

import com.eisei.eiseilocal.model.TUsuarioResponseModel;
import com.eisei.eiseilocal.model.Usuario;
import com.eisei.eiseilocal.model.UsuarioResponseModel;
import com.eisei.eiseilocal.service.UsuarioService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author karla.calderon
 */
@Controller
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})

public class UsuarioController extends HttpServlet {

    @Autowired
    private UsuarioService uService;
    Usuario user = new Usuario();

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ModelAndView usuarios() throws Exception {
        ModelAndView indexModel = new ModelAndView("usuarios", "command", new Object());
        return indexModel;
    }

    @RequestMapping(value = "/CrearUsuario", method = RequestMethod.POST)
    @ResponseBody
    protected UsuarioResponseModel CrearUsuario(
            @RequestParam(value = "Usuario", required = true) String usuario,
            @RequestParam(value = "Contrasena", required = true) String contrasena,
            @RequestParam(value = "Nombre", required = true) String nombre,
            @RequestParam(value = "Apellidos", required = true) String apellidos,
            @RequestParam(value = "Genero", required = true) String genero,
            @RequestParam(value = "FechaNacimiento", required = true) String fechaNac,
            @RequestParam(value = "Correo", required = true) String correo,
            @RequestParam(value = "Estado", required = true) int estado,
            @RequestParam(value = "UsuarioCreacion", required = true) String usuarioCrea,
            @RequestParam(value = "UsuarioModificacion", required = true) String usuarioModi,
            @RequestParam(value = "FechaCreacion", required = true) String fechaCrea,
            @RequestParam(value = "FechaModificacion", required = true) String fechaModi,
            @RequestParam(value = "IdRol", required = true) int rol,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioResponseModel resp = new UsuarioResponseModel();
        user.setUsuario(usuario);
        Usuario x = uService.usuarioConsulta(user);
        String usuarioObjx = x.getUsuario();

        if (x.getUsuario().equals("1")) {
            resp.setMessage("Existe");
            resp.setObject(x);
            return resp;
        } else if (x.getUsuario().equals("0")) {
            UsuarioResponseModel respObj = new UsuarioResponseModel();
            user.setUsuario(usuario);
            user.setContrasena(contrasena);
            user.setNombre(nombre);
            user.setApellidos(apellidos);
            user.setGenero(genero);
            user.setFechaNacimiento(fechaNac);
            user.setCorreo(correo);
            user.setEstado(estado);
            user.setUsuarioCreacion(usuarioCrea);
            user.setUsuarioModificacion(usuarioModi);
            user.setFechaCreacion(fechaCrea);
            user.setFechaModificacion(fechaModi);
            user.setRol(rol);
            Usuario n = uService.usuarioInsertar(user);
            String usuarioObj = n.getUsuario();

            if (n.getUsuario() != null) {
                respObj.setMessage("Registro");
                respObj.setObject(n);
                return respObj;
            } else {
                return respObj;
            }
        }
        return resp;

    }

    @RequestMapping(value = "/TUsuarios", method = RequestMethod.GET)
    @ResponseBody
    protected TUsuarioResponseModel TUsuarios()
            throws ServletException, IOException {
        List<Usuario> lista = new ArrayList<>();
        TUsuarioResponseModel objectResponse = new TUsuarioResponseModel();
        lista = uService.LUsuarios();

        if (lista != null) {
            objectResponse.setMessage("Ingreso");
            objectResponse.setObject(lista);
            objectResponse.setFailure(0);
            return objectResponse;
        } else {
            objectResponse.setFailure(1);
            objectResponse.setMessage("error: credenciales incorrectas");
            return objectResponse;
        }

    }

    @RequestMapping(value = "/EliminarUsuario", method = RequestMethod.POST)
    @ResponseBody
    protected TUsuarioResponseModel EliminarUsuario(
            @RequestParam(value = "IdUsuario", required = false) int id,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario eUser = new Usuario();
        TUsuarioResponseModel objectResponse = new TUsuarioResponseModel();

        eUser.setId(id);
        objectResponse = uService.usuarioEliminar(eUser);

        return objectResponse;
    }

    @RequestMapping(value = "/ModificarUsuario", method = RequestMethod.POST)
    @ResponseBody
    protected UsuarioResponseModel ModificarUsuario(
            @RequestParam(value = "IdUsuario", required = true) int id,
            @RequestParam(value = "Usuario", required = true) String usuario,
            @RequestParam(value = "Contrasena", required = true) String contrasena,
            @RequestParam(value = "Nombre", required = true) String nombre,
            @RequestParam(value = "Apellidos", required = true) String apellidos,
            @RequestParam(value = "Genero", required = true) String genero,
            @RequestParam(value = "FechaNacimiento", required = true) String fechaNac,
            @RequestParam(value = "Correo", required = true) String correo,
            @RequestParam(value = "Estado", required = true) int estado,
            @RequestParam(value = "UsuarioModificacion", required = true) String usuarioModi,
            @RequestParam(value = "FechaModificacion", required = true) String fechaModi,
            @RequestParam(value = "IdRol", required = true) int rol,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioResponseModel userResp = new UsuarioResponseModel();
        Usuario u = new Usuario();

        u.setId(id);
        u.setUsuario(usuario);
        u.setContrasena(contrasena);
        u.setNombre(nombre);
        u.setApellidos(apellidos);
        u.setGenero(genero);
        u.setFechaNacimiento(fechaNac);
        u.setCorreo(correo);
        u.setEstado(estado);
        u.setUsuarioModificacion(usuarioModi);
        u.setFechaModificacion(fechaModi);
        u.setRol(rol);

        userResp = uService.usuarioEditar(u);

        return userResp;
    }

}
