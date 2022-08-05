package com.eisei.eiseilocal.serviceImpl;

import com.eisei.eiseilocal.dao.UsuarioDao;
import com.eisei.eiseilocal.model.TUsuarioResponseModel;
import com.eisei.eiseilocal.model.Usuario;
import com.eisei.eiseilocal.model.UsuarioResponseModel;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.eisei.eiseilocal.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario usuarioConsulta(Usuario usu) {
        UsuarioResponseModel resp = new UsuarioResponseModel();
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
        UsuarioResponseModel resp = new UsuarioResponseModel();
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
    public TUsuarioResponseModel usuarioEliminar(Usuario eUser) {
        TUsuarioResponseModel objectResponse = new TUsuarioResponseModel();
        Usuario user = new Usuario();
        try {
            user = usuarioDao.eliminarUsuario(eUser);
            if (user!=null || user.equals("")) {
                objectResponse.setMessage("Ingreso");
                objectResponse.setObj(user);
                objectResponse.setFailure(0);
            } else {
                objectResponse.setFailure(1);
                objectResponse.setMessage("error");
            }
        } catch (Exception e) {
            return null;
        }
        return objectResponse;
    }

    @Override
    public UsuarioResponseModel usuarioEditar(Usuario us) {
        UsuarioResponseModel userResp = new UsuarioResponseModel();
        Usuario user = new Usuario();
        try {
            user = usuarioDao.editarUsuario(us);
            if (user.getUsuario() != null || user.getUsuario().equals("")) {
                userResp.setMessage("Editado");
                userResp.setObject(user);
                userResp.setFailure(0);

            } else {
                userResp.setFailure(1);
                userResp.setMessage("error");
            }
        } catch (Exception e) {
            userResp.setMessage("error " + e);
        }

        return userResp;
    }
}
