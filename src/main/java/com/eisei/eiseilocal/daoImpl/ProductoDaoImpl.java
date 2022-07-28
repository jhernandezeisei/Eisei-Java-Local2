package com.eisei.eiseilocal.daoImpl;

import com.eisei.eiseilocal.config.Conexion;
import com.eisei.eiseilocal.dao.ProductoDao;
import com.eisei.eiseilocal.model.Categoria;
import com.eisei.eiseilocal.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karla.calderon
 */
@Component
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class ProductoDaoImpl implements ProductoDao {
    
    String resp = null;
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @Override
    
    public List<Producto> listaProducto() {
        
        List<Producto> lista = new ArrayList<>();
        try {
            Conexion c = new Conexion();
            con = c.getConnection();
            
            String sql = "{call SP_Productos()}";
            ps = con.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Mostrando datos");
                Producto prod = new Producto();
                prod.setClave(rs.getString("Clave"));
                prod.setNombreProducto(rs.getString("NombreProducto"));
                prod.setIdCategoria(rs.getInt("IdCategoria"));
                prod.setMarca(rs.getString("Marca"));
                prod.setPrecio(rs.getInt("Precio"));
                prod.setCantidad(rs.getInt("Cantidad"));
                lista.add(prod);
                
            }
            
        } catch (Exception e) {
            
        }
        return lista;
    }
    
    @Override
    public List<Producto> obtenerProducto() {
        List<Producto> productos = new ArrayList<>();
        Producto producto = new Producto();
        try {
            Conexion c = new Conexion();
            
            con = c.getConnection();
            
            String sql = "select * from productos";
            ps = con.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                producto.setIdCategoria(Integer.parseInt(rs.getString(1)));
                
            }
            ps.close();
            rs.close();
            con.close();
            
        } catch (Exception e) {
        }
        return productos;
        
    }
    
    @Override
    public List<Categoria> obtenerCategoria() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            Conexion c = new Conexion();
            con = c.getConnection();
            String sql = "{call SP_Categorias()}";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idCategoria");
                String nombre = rs.getString("Nombre");
                String fecha = rs.getString("FechaCreacion");
                String usuario = rs.getString("UsuarioCreacion");
                Categoria categoria = new Categoria(id, nombre, fecha, usuario);
                categorias.add(categoria);
                
            }
            ps.close();
            rs.close();
            con.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        return categorias;
    }
    
    @Override
    public Producto crearProducto(Producto pro) {
        try {
            Conexion c = new Conexion();
            con = c.getConnection();
            String sql = "{call SP_CrearProducto(?,?,?,?,?,?,?,?,?,?)}";
            ps = con.prepareCall(sql);
            ps.setString(1, pro.getClave());
            ps.setString(2, pro.getNombreProducto());
            ps.setInt(3, pro.getIdCategoria());
            ps.setString(4, pro.getMarca());
            ps.setInt(5, pro.getCantidad());
            ps.setInt(6, pro.getPrecio());
            ps.setString(7, pro.getFechaCreacion());
            ps.setString(8, pro.getUsuarioCreacion());
            ps.setString(9, pro.getFechaModificacion());
            ps.setString(10, pro.getUsuarioModificacion());
            int r = ps.executeUpdate();
            if (r > 0) {
                System.out.println("Se insertó correctamente");
            } else {
                System.out.println("Falló");
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return pro;
    }
}
