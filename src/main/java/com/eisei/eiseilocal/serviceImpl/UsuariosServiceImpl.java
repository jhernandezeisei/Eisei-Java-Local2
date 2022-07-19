
package com.eisei.eiseilocal.serviceImpl;

import com.eisei.eiseilocal.dao.UsuarioDao;
import com.eisei.eiseilocal.model.Usuarios;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.eisei.eiseilocal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class UsuariosServiceImpl implements UsuarioService{
 @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuarios usuarioConsulta(Usuarios usu) {
        Usuarios user = new Usuarios();
        try {
            user = usuarioDao.consultaUsuario(usu);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    @Override
    public Usuarios usuarioInsertar(Usuarios usua) {
        Usuarios user = new Usuarios();
        try {
            user = usuarioDao.crearUsuario(usua);
        } catch (Exception e) {
            return null;
        }
        return user;
    }
    
}
