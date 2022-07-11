package com.eisei.eiseilocal.controller;

import com.eisei.eiseilocal.dao.LoginDao;
import com.eisei.eiseilocal.daoImpl.LoginDaoImpl;
import com.eisei.eiseilocal.model.Usuarios;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends HttpServlet {

    Usuarios user = new Usuarios();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView indexModel = new ModelAndView("index", "command", new Object());
        return indexModel;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        doPost(request, response);
    }

    @RequestMapping(value = "/Userlogin", method = RequestMethod.POST)
    protected void doPost(
            @RequestParam(value = "Usuario", required = false) String usuario,
            @RequestParam(value = "Contrasena", required = false) String contraseña,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        boolean valido = false;
        user.setUsuario(usuario);
        user.setContraseña(contraseña);

        LoginDao ld = new LoginDaoImpl();
        Usuarios u = ld.login(user);

        if(u.getUsuario() != null) {
            out.write("Ingreso");
            valido = true;
            //request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } else {
            out.write("Error");
            valido = false;
            //response.sendRedirect("index.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
