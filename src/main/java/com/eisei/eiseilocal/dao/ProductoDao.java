package com.eisei.eiseilocal.dao;

import com.eisei.eiseilocal.model.Categoria;
import com.eisei.eiseilocal.model.Producto;
import java.util.List;

/**
 *
 * @author karla.calderon
 */
public interface ProductoDao {

    public List<Producto> listaProducto();

    public List<Producto> obtenerProducto();

    public List<Categoria> obtenerCategoria();

    public Producto crearProducto(Producto pro);

    public Producto crearClave(Producto pro);

    List<Producto> catalogoList();

  

}
