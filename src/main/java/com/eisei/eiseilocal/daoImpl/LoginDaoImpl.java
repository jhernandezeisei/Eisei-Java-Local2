package com.eisei.eiseilocal.daoImpl;


import com.eisei.eiseilocal.config.Conexion;
import com.eisei.eiseilocal.dao.LoginDao;
import com.eisei.eiseilocal.model.Usuarios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDaoImpl implements LoginDao {

    Usuarios user = new Usuarios();
    String resp = null;
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public Usuarios login(Usuarios obj) {
        try {
            Conexion c = new Conexion();
            con = c.getConnection();

            String sql = "{call SP_ObtenerUsuario(?,?)}";
            ps = con.prepareCall(sql);
            System.out.println(sql);
            ps.setString(1, obj.getUsuario());
            ps.setString(2, obj.getContraseña());
            rs = ps.executeQuery();


            while (rs.next()) {
                user.setUsuario(rs.getString(1));
                user.setContraseña(rs.getString(2));
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