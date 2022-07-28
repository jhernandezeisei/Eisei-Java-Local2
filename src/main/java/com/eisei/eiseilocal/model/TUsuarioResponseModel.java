package com.eisei.eiseilocal.model;

import java.util.List;

public class TUsuarioResponseModel {

    private int failure;
    private List<Usuario> object;
    private Usuario obj;
    private String message;

    public Usuario getObj() {
        return obj;
    }

    public void setObj(Usuario obj) {
        this.obj = obj;
    }
    

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public List<Usuario> getObject() {
        return object;
    }

    public void setObject(List<Usuario> object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
