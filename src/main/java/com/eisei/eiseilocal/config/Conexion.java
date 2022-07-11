package com.eisei.eiseilocal.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author karla.calderon
 */
public class Conexion {

     private static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="root";
    private static final String pass="admin";
    private static final String url="jdbc:mysql://localhost:3306/usuarios?useSSL=false&serverTimezone=UTC";

    public Connection getConnection() {
        con=null;
        try {
            Class.forName(driver);
            
            con= (Connection) DriverManager.getConnection(url, user, pass);          
            
            if (con!=null){
                System.out.println("Conexión a BD exitosa.");
            }
 
        } catch (Exception e) {
            System.out.println(e);
        }
         return con;
    }
}
