package com.eisei.eiseilocal.service;

import com.eisei.eiseilocal.model.Categoria;
import com.eisei.eiseilocal.model.Producto;
import com.eisei.eiseilocal.model.eProductoResponseModel;

import java.util.List;

/**
 *
 * @author karla.calderon
 */
public interface ProductoService {

    public Producto productoInsertar(Producto prod);

    public List<Categoria> obtenerCategoria();

    public List<Producto> obtenerProductos();

    public Producto clave(Producto pro);

    List<Producto> catalogoListar();
  
    public eProductoResponseModel prodEditar (Producto pro);


    public List<Producto> llamarcat(Producto pr);
   
    
//    public Producto proEdicion (Producto pro);
}
