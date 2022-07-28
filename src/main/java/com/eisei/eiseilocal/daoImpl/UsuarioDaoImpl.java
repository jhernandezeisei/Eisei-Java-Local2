package com.eisei.eiseilocal.daoImpl;

import com.eisei.eiseilocal.config.Conexion;
import com.eisei.eiseilocal.dao.UsuarioDao;
import com.eisei.eiseilocal.model.Usuario;
import com.eisei.eiseilocal.model.UsuarioResponseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karla.calderon
 */
@Component
@Repository
public class UsuarioDaoImpl implements UsuarioDao {
    
    Usuario user = new Usuario();
    String resp = null;
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Conexion c = new Conexion();
    
    @Override
    public Usuario crearUsuario(Usuario usu) {
        try {
            con = c.getConnection();
            String sql = "{call SP_CrearUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            ps = con.prepareCall(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getContrasena());
            ps.setString(3, usu.getNombre());
            ps.setString(4, usu.getApellidos());
            ps.setString(5, usu.getGenero());
            ps.setString(6, usu.getFechaNacimiento());
            ps.setString(7, usu.getCorreo());
            ps.setInt(8, usu.getEstado());
            ps.setString(9, usu.getUsuarioCreacion());
            ps.setString(10, usu.getUsuarioModificacion());
            ps.setString(11, usu.getFechaCreacion());
            ps.setString(12, usu.getFechaModificacion());
            ps.setInt(13, usu.getRol());
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
        
        return usu;
    }
    
    @Override
    public Usuario consultaUsuario(Usuario us) {
        try {
            UsuarioResponseModel resp = new UsuarioResponseModel();
            con = c.getConnection();
            String sql = "{call SP_CountId(?)}";
            ps = con.prepareCall(sql);
            System.out.println(sql);
            ps.setString(1, us.getUsuario());
            rs = ps.executeQuery();
            
            while (rs.next()) {
                user.setUsuario(rs.getString(1));
            }
            
            ps.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
        
    }
    
    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            Conexion c = new Conexion();
            con = c.getConnection();
            
            String sql = "{call SP_Usuarios()}";
            ps = con.prepareStatement(sql);
            System.out.println(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Mostrando datos");
                
                Usuario user = new Usuario();
                
                user.setId(rs.getInt("IdUsuario"));
                user.setUsuario(rs.getString("Usuario"));
                user.setContrasena(rs.getString("Contrasena"));
                user.setNombre(rs.getString("Nombre"));
                user.setApellidos(rs.getString("Apellidos"));
                user.setGenero(rs.getString("Genero"));
                user.setFechaNacimiento(rs.getString("FechaNacimiento"));
                user.setCorreo(rs.getString("Correo"));
                user.setFechaCreacion(rs.getString("FechaCreacion"));
                user.setRol(rs.getInt("IdRol"));
                lista.add(user);
                
            }
            
        } catch (Exception e) {
            
        }
        return lista;
    }
    
    @Override
    public Usuario eliminarUsuario(Usuario eUser) {
        try {
            Conexion c = new Conexion();
            con = c.getConnection();
            
            String sql = "{call SP_EliminarUsuario(?)}";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, eUser.getId());
            System.out.println(sql);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se guardo el registro");
            }
            
        } catch (Exception e) {
            
        }
        return eUser;
    }
}
