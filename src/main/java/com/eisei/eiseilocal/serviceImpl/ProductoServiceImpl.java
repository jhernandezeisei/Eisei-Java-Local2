package com.eisei.eiseilocal.serviceImpl;

import com.eisei.eiseilocal.daoImpl.ProductoDaoImpl;
import com.eisei.eiseilocal.dao.ProductoDao;
import com.eisei.eiseilocal.model.Categoria;
import com.eisei.eiseilocal.model.Producto;
import com.eisei.eiseilocal.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 *
 * @author karla.calderon
 */
@Service
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDaoImpl productoDaoImpl;
    @Autowired
    private ProductoDao productoDao;
 @Autowired
    private ProductoDao catalogoDao;
    @Override

    public List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();
        Producto user = new Producto();
        try {
            lista = productoDao.listaProducto();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    @Override
    public List<Categoria> obtenerCategoria() {
        List<Categoria> lista = new ArrayList<>();
        try {
            lista = productoDao.obtenerCategoria();

        } catch (Exception e) {
            return null;
        }
        return lista;
    }

    @Override
    public Producto productoInsertar(Producto prod) {
        Producto pro = new Producto();
        try {
            pro = productoDao.crearProducto(prod);
        } catch (Exception e) {
            return null;
        }
        return prod;
    }

 @Override
 public Producto clave(Producto pro){
//   Producto pro = new Producto();
     Producto PR = new Producto();
        try {
            PR = productoDao.crearClave(pro);
        } catch (Exception e) {
            return null;
        }
        return PR;

}


    @Override
    public List<Producto> catalogoListar() {
        List<Producto> lista = new ArrayList<>();
        try {
            lista = catalogoDao.catalogoList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }
}
