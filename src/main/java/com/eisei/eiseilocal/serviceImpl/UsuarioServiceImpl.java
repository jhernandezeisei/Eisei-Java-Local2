
package com.eisei.eiseilocal.serviceImpl;

import com.eisei.eiseilocal.dao.UsuarioDao;
import com.eisei.eiseilocal.model.Usuario;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.eisei.eiseilocal.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class UsuarioServiceImpl implements UsuarioService{
 @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario usuarioConsulta(Usuario usu) {
        Usuario user = new Usuario();
        try {
            user = usuarioDao.consultaUsuario(usu);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    @Override
    public Usuario usuarioInsertar(Usuario usua) {
        Usuario user = new Usuario();
        try {
            user = usuarioDao.crearUsuario(usua);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

@Override
public List<Usuario> LUsuarios() {
        List<Usuario> lista = new ArrayList<>();

        try {
            lista = usuarioDao.listar();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }

@Override
    public Usuario usuarioEliminar(Usuario eUser) {
        Usuario user = new Usuario();
        try {
            user = usuarioDao.eliminarUsuario(eUser);
        } catch (Exception e)  {
            return null;
        }

        return user;
    }
}
