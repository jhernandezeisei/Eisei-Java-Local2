/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;


import com.eisei.eiseilocal.config.Conexion;
import java.io.IOException;

/**
 *
 * @author karla.calderon
 */
public class pruebaConexion {

    public static void main(String[] args) throws IOException {
        Conexion c = new Conexion();
        c.getConnection();

    }

}

