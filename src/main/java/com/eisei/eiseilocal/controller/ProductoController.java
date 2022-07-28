package com.eisei.eiseilocal.controller;

import com.eisei.eiseilocal.model.Categoria;
import com.eisei.eiseilocal.model.Producto;
import com.eisei.eiseilocal.model.ProductoResponseModel;
import com.eisei.eiseilocal.model.TProductoResponseModel;
import com.eisei.eiseilocal.service.ProductoService;
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

@Controller
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class ProductoController extends HttpServlet {

    @Autowired
    private ProductoService pService;
    Producto prod = new Producto();

@RequestMapping(value = "/productos", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView indexModel = new ModelAndView("productos", "command", new Object());
        return indexModel;
    }
@RequestMapping(value = "/categorias", method = RequestMethod.GET)
    @ResponseBody
    public List<Categoria> obtenerCategoria() {
        return pService.obtenerCategoria();

    }

@RequestMapping(value = "/CrearProducto", method = RequestMethod.POST)
    @ResponseBody
    protected ProductoResponseModel doPost(
            @RequestParam(value = "Clave", required = true) String clave,
            @RequestParam(value = "NombreProducto", required = true) String nombrep,
            @RequestParam(value = "IdCategoria", required = true) int ddl_categorias,
            @RequestParam(value = "Marca", required = true) String marca,
            @RequestParam(value = "Cantidad", required = true) int cantidad,
            @RequestParam(value = "Precio", required = true) int precio,
            @RequestParam(value = "FechaCreacion", required = true) String fechacreacion,
            @RequestParam(value = "UsuarioCreacion", required = true) String usuarioCreacion,
            @RequestParam(value = "FechaModificacion", required = true) String fechaModificacion,
            @RequestParam(value = "UsuarioModificacion", required = true) String usuarioModificacion,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
             ProductoResponseModel respObj = new ProductoResponseModel();
            prod.setClave(clave);
            prod.setNombreProducto(nombrep);
            prod.setIdCategoria(ddl_categorias);
            prod.setMarca(marca);
            prod.setCantidad(cantidad);
            prod.setPrecio(precio);
            prod.setFechaCreacion(fechacreacion);
            prod.setUsuarioCreacion(usuarioCreacion);
            prod.setFechaModificacion(fechaModificacion);
            prod.setUsuarioModificacion(usuarioModificacion);
            
            Producto p = pService.productoInsertar(prod);

            if (p.getClave()!= null) {
                respObj.setMessage("Registro");
                respObj.setObject(p);
                return respObj;
            } else {
                return respObj;
            }       
    }

@RequestMapping(value = "/ConsultaProductos", method = RequestMethod.GET)
    @ResponseBody

    protected TProductoResponseModel ConsultaProductos()
            throws ServletException, IOException {
        List<Producto> lista = new ArrayList<>();
        TProductoResponseModel objectResponse = new TProductoResponseModel();

        lista = pService.obtenerProductos();

        if (lista != null) {
            objectResponse.setMessage("Acceso a los datos");
            objectResponse.setObject(lista);
            objectResponse.setFailure(0);
            return objectResponse;
        } else {
            objectResponse.setFailure(1);
            objectResponse.setMessage("No tienes aceso a los datos");
            return objectResponse;
        }

    }

}
