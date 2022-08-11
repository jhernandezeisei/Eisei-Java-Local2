/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eisei.eiseilocal.model;



/**
 *
 * @author ehecatl.moreno
 */
public class eProductoResponseModel {

    private int failure;
    private Producto object;
   
    private String message;

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public Producto getObject() {
        return object;
    }

    public void setObject(Producto object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
