/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eisei.eiseilocal.service;

import com.eisei.eiseilocal.model.Usuarios;

/**
 *
 * @author jose.garcia
 */
public interface UsuarioService {
    public Usuarios usuarioConsulta(Usuarios usu);
    public Usuarios usuarioInsertar(Usuarios usua);
    
}
