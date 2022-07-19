package com.eisei.eiseilocal.dao;

import com.eisei.eiseilocal.model.Usuarios;

public interface UsuarioDao {

    public Usuarios crearUsuario(Usuarios usu);

    public Usuarios consultaUsuario(Usuarios us);
}
