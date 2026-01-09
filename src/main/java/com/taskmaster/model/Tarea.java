package com.taskmaster.model;

import java.util.UUID;

public class Tarea {
    private final String id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private Categoria categoria;
    private boolean completada;

    public Tarea(String titulo, String descripcion, Prioridad prioridad, Categoria categoria){
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        this.id = UUID.randomUUID().toString();
        this.titulo= titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.categoria = categoria;
        this.completada = false;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        String estado = completada ? "[COMPLETADA]" : "[PENDIENTE]";
        return String.format("%s ID: %s | Título: %s | Prioridad: %s | Categoría: %s",
                estado, id.substring(0, 8), titulo, prioridad, categoria);
    }

}
