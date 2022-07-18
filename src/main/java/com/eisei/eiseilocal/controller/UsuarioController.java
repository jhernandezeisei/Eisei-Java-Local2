/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.eisei.eiseilocal.controller;

import com.eisei.eiseilocal.dao.UsuarioDao;
import com.eisei.eiseilocal.daoImpl.UsuarioDaoImpl;
import com.eisei.eiseilocal.model.Usuarios;
import com.eisei.eiseilocal.model.UsuariosResponseModel;
import com.eisei.eiseilocal.service.LoginService;
import com.eisei.eiseilocal.service.UsuarioService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
    Usuarios user = new Usuarios();

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ModelAndView panel() throws Exception {
        ModelAndView indexModel = new ModelAndView("usuarios", "command", new Object());
        return indexModel;
    }

    @RequestMapping(value = "/CrearUsuario", method = RequestMethod.POST)
    @ResponseBody
    protected UsuariosResponseModel doPost(
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
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuariosResponseModel resp = new UsuariosResponseModel();
        user.setUsuario(usuario);
        Usuarios x = uService.usuarioConsulta(user);

        if (x.getUsuario().equals("1")) {
            resp.setMessage("Existe");
            resp.setObject(x);
            return resp;
        } else if (x.getUsuario().equals("0")) {
            UsuariosResponseModel respObj = new UsuariosResponseModel();
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
            Usuarios n = uService.usuarioInsertar(user);

            if (n.getUsuario() != null) {
                respObj.setMessage("Registro");
                respObj.setObject(n);
                return respObj;
            } else {
                return respObj;
            }
        }
        //return uService.crearUsuario(usuario, contraseña, nombre, apellidos, genero, fechaNac, correo, estado, usuarioCrea, usuarioModi, fechaCrea, fechaModi);        
        return resp;

    }
}
