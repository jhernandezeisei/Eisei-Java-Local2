package com.eisei.eiseilocal.daoImpl;

import com.eisei.eiseilocal.config.Conexion;
import com.eisei.eiseilocal.dao.LoginDao;
import com.eisei.eiseilocal.model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class LoginDaoImpl implements LoginDao {

    Usuario user = new Usuario();
    String resp = null;
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public Usuario login(Usuario obj) {
        try {
            Conexion c = new Conexion();
            con = c.getConnection();

            String sql = "{call SP_ObtenerUsuario(?,?)}";
            ps = con.prepareCall(sql);
            System.out.println(sql);
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getContrasena());
            rs = ps.executeQuery();

            while (rs.next()) {
                user.setUsuario(rs.getString(1));
                user.setContrasena(rs.getString(2));
                user.setRol(rs.getInt(3));
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return user;
    }
}
