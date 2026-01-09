package com.taskmaster.service;

import com.taskmaster.model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private static GestorTareas gestor;
    private final List<Tarea> listaTareas;

    private GestorTareas() {
        this.listaTareas = new ArrayList<>();
    }

    public static GestorTareas getInstance(){
        if (gestor == null) {
            gestor = new GestorTareas();
        }
        return gestor;
    }

    public void agregarTarea(Tarea nuevaTarea) {
        if (nuevaTarea != null){
            this.listaTareas.add(nuevaTarea);
        }
        else{
            System.out.println("La tarea esta vacia");
        }
    }

    public boolean eliminarTarea(String id) {
        return listaTareas.removeIf(t -> t.getId().equals(id));
    }

    public boolean updateTarea(String id) {
        for (Tarea t : listaTareas) {
            if (t.getId().equals(id)) {
                t.setCompletada(true);
                return true;
            }
        }
        return false;
    }

    public void listarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar.");
        } else {
            for (Tarea t : listaTareas) {
                System.out.println(t);
            }
        }
    }
}
