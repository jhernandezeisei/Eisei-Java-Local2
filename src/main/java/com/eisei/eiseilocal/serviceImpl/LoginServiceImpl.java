/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eisei.eiseilocal.serviceImpl;

import com.eisei.eiseilocal.dao.LoginDao;
import com.eisei.eiseilocal.model.Usuarios;
import com.eisei.eiseilocal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose.garcia
 */
@Service
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public Usuarios login(Usuarios obj) {
        Usuarios user = new Usuarios();
        try {
            user = loginDao.login(obj);
        } catch (Exception e) {
            return null;
        }
        return user;
    }
}
