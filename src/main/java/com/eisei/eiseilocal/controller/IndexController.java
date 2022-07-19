package com.eisei.eiseilocal.controller;

import com.eisei.eiseilocal.dao.LoginDao;
import com.eisei.eiseilocal.daoImpl.LoginDaoImpl;
import com.eisei.eiseilocal.model.ResponseUsuariosModel;
import com.eisei.eiseilocal.model.Usuarios;
import com.eisei.eiseilocal.service.LoginService;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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

@Controller
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class IndexController extends HttpServlet {

    @Autowired
    private LoginService loginService;
    Usuarios user = new Usuarios();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView indexModel = new ModelAndView("index", "command", new Object());
        return indexModel;
    }

    @RequestMapping(value = "/Userlogin", method = RequestMethod.POST)
    @ResponseBody
    protected ResponseUsuariosModel doPost(
            @RequestParam(value = "Usuario", required = false) String usuario,
            @RequestParam(value = "Contrasena", required = false) String contraseña,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ResponseUsuariosModel objectResponse = new ResponseUsuariosModel();

        user.setUsuario(usuario);
        user.setContrasena(contraseña);

        Usuarios u = loginService.login(user);

        if (u.getUsuario() != null) {
            request.getSession().setAttribute("nom", usuario);
            objectResponse.setMessage("Ingreso");
            objectResponse.setObject(u);
            objectResponse.setFailure(0);
            return objectResponse;
        } else {
            objectResponse.setFailure(1);
            objectResponse.setMessage("error: credenciales incorrectas");
            return objectResponse;
        }

    }
}
