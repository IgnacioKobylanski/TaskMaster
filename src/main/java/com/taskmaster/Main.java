package com.taskmaster;

import com.taskmaster.model.Categoria;
import com.taskmaster.model.Prioridad;
import com.taskmaster.model.Tarea;
import com.taskmaster.service.GestorTareas;

import javax.print.attribute.standard.Media;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = GestorTareas.getInstance();

        Tarea t1 = new Tarea("Rediseñar pagina de clientes", "Los clientes de la cuenta Carlo quieren aplicar un rebranding a su pagina", Prioridad.MEDIA, Categoria.DISEÑO);
        Tarea t2 = new Tarea("Reunion con clientes", "Reunirse con clientes para hablar del proyecto", Prioridad.MEDIA, Categoria.REUNION);
        Tarea t3 = new Tarea("Optimizacion de software", "Mejorar el software del proyecto Bustamante", Prioridad.ALTA, Categoria.SOPORTE);

        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t3);

        gestor.listarTareas();
    }
}
