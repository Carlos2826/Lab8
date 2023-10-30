package com.example.ejemplo.modelos;

public class Productos {
    private int Id;
    private String nombre;
    private float precio;
    private int CategoriaId;
    private String foto;
    private String fecha_preparacion;
    private String fecha_expiracion;

    public Productos() {

    }

    public Productos(int id, String nombre, float precio, int categoriaId, String foto, String fecha_preparacion,
            String fecha_expiracion) {
        Id = id;
        this.nombre = nombre;
        this.precio = precio;
        CategoriaId = categoriaId;
        this.foto = foto;
        this.fecha_preparacion = fecha_preparacion;
        this.fecha_expiracion = fecha_expiracion;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        CategoriaId = categoriaId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFecha_preparacion() {
        return fecha_preparacion;
    }

    public void setFecha_preparacion(String fecha_preparacion) {
        this.fecha_preparacion = fecha_preparacion;
    }

    public String getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

}
