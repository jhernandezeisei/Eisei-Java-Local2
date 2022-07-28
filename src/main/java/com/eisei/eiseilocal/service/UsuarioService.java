/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eisei.eiseilocal.service;

import com.eisei.eiseilocal.model.Usuario;
import java.util.List;

/**
 *
 * @author jose.garcia
 */
public interface UsuarioService {

    public Usuario usuarioConsulta(Usuario usu);

    public Usuario usuarioInsertar(Usuario usua);

    public Usuario usuarioEliminar(Usuario eUser);

    public List<Usuario> LUsuarios();

}
