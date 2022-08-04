package com.eisei.eiseilocal.dao;

import com.eisei.eiseilocal.model.Usuario;
import com.eisei.eiseilocal.model.UsuarioResponseModel;
import java.util.List;

public interface UsuarioDao {

    public Usuario crearUsuario(Usuario usu);

    public Usuario consultaUsuario(Usuario us);

    public Usuario eliminarUsuario(Usuario eUser);

    public Usuario editarUsuario(Usuario us);

    public List<Usuario> listar();
}
