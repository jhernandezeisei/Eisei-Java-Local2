
package com.eisei.eiseilocal.model;

/**
 *
 * @author karla.calderon
 */
public class ProductoResponseModel {
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
