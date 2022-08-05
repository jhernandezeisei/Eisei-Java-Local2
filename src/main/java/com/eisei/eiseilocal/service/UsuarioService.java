/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eisei.eiseilocal.service;

import com.eisei.eiseilocal.model.TUsuarioResponseModel;
import com.eisei.eiseilocal.model.Usuario;
import com.eisei.eiseilocal.model.UsuarioResponseModel;
import java.util.List;

/**
 *
 * @author jose.garcia
 */
public interface UsuarioService {

    public Usuario usuarioConsulta(Usuario usu);

    public Usuario usuarioInsertar(Usuario usua);

    public TUsuarioResponseModel usuarioEliminar(Usuario eUser);

    public UsuarioResponseModel usuarioEditar(Usuario us);

    public List<Usuario> LUsuarios();

}
