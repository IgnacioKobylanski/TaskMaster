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
        // 1. Un espacio arriba para despegar del número que acaba de escribir el usuario
        System.out.println("\n========================================");
        System.out.println("           LISTA DE TAREAS");
        System.out.println("========================================");

        if (listaTareas.isEmpty()) {
            System.out.println("   [ No hay tareas registradas ]");
        } else {
            for (Tarea t : listaTareas) {
                System.out.println(t);
            }
        }

        // 2. Cerramos el bloque y dejamos un par de líneas en blanco
        // Esto hace que el Menú aparezca bien abajo y no se pegue
        System.out.println("========================================\n\n");
    }

    public List<Tarea> getListaTareas(){
        return new ArrayList<>(this.listaTareas);
    }
}
