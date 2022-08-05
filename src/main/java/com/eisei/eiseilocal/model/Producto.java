package com.eisei.eiseilocal.model;

/**
 *
 * @author karla.calderon
 */
public class Producto {

    int idCategoria;
    int idProducto;
    String clave;
    String nombreProducto;
    String marca;
    int cantidad;
    float precio;
    String fechaCreacion;
    String usuarioCreacion;
    String fechaModificacion;
    String usuarioModificacion;
    String fotoProductoString;

    public Producto() {
    }

    public Producto(int idCategoria, int idProducto, String clave, String nombreProducto, String marca, int cantidad, float precio, String fechaCreacion, String usuarioCreacion, String fechaModificacion, String usuarioModificacion, String fotoProductoString) {
        this.idCategoria = idCategoria;
        this.idProducto = idProducto;
        this.clave = clave;
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fotoProductoString = fotoProductoString;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

public String getfotoProductoString() {
        return fotoProductoString;
    }

    public void setfotoProductoString(String fotoProductoString) {
        this.fotoProductoString=fotoProductoString;
    }
}
