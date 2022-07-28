package com.eisei.eiseilocal.model;

/**
 *
 * @author karla.calderon
 */
public class Categoria {

    int idCategoria;
    String nombre;
    String fechaCreacion;
    String usuarioCreacion;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nombre, String fechaCreacion, String usuarioCreacion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

}
