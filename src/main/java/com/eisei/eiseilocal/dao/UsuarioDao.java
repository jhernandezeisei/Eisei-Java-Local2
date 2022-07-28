package com.eisei.eiseilocal.dao;

import com.eisei.eiseilocal.model.Usuario;
import java.util.List;

public interface UsuarioDao {

    public Usuario crearUsuario(Usuario usu);

    public Usuario consultaUsuario(Usuario us);

    public Usuario eliminarUsuario(Usuario eUser);

    public List<Usuario> listar();
}
