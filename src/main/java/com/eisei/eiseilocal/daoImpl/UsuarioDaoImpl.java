package com.eisei.eiseilocal.daoImpl;

import com.eisei.eiseilocal.config.Conexion;
import com.eisei.eiseilocal.dao.UsuarioDao;
import com.eisei.eiseilocal.model.Usuarios;
import com.eisei.eiseilocal.model.UsuariosResponseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    Usuarios user = new Usuarios();
    String resp = null;
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Conexion c = new Conexion();

    @Override
    public Usuarios crearUsuario(Usuarios usu) {
        try {

            con = c.getConnection();
            String sql = "{call SP_CrearUsuario(?,?,?,?,?,?,?,?,?,?,?,?)}";
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
    public Usuarios consultaUsuario(Usuarios us) {
        try {
            UsuariosResponseModel resp = new UsuariosResponseModel();
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
}
