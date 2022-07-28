package com.eisei.eiseilocal.model;

/**
 *
 * @author karla.calderon
 */
public class UsuarioResponseModel {

    private int failure;
    private Usuario object;
    private String message;

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public Usuario getObject() {
        return object;
    }

    public void setObject(Usuario object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
