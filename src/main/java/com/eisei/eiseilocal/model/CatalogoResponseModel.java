/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eisei.eiseilocal.model;

import java.util.List;

/**
 *
 * @author ehecatl.moreno
 */
public class CatalogoResponseModel {

    private int failure;
    private List<Producto> object;
    private String message;

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public List<Producto> getObject() {
        return object;
    }

    public void setObject(List<Producto> object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
