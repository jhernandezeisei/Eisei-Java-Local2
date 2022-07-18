package com.eisei.eiseilocal.model;

/**
 *
 * @author karla.calderon
 */
public class UsuariosResponseModel {

    private int failure;
    private Usuarios object;
    private String message;

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public Usuarios getObject() {
        return object;
    }

    public void setObject(Usuarios object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
