package com.taskmaster.ui;

import com.taskmaster.model.Categoria;
import com.taskmaster.model.Prioridad;
import com.taskmaster.model.Tarea;
import com.taskmaster.service.GestorTareas;

import java.util.List;
import java.util.Scanner;

public class MenuApp {
    private GestorTareas gestorTareas;
    private Scanner scanner;
    private int opcion = 1;

    private static final String MENU = """
    --- GESTOR DE TAREAS ---
    1. Agregar Tarea.
    2. Listar Tarea.
    3. Eliminar Tarea.
    4. Salir.
    """;


    public MenuApp(){
        this.gestorTareas = GestorTareas.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar(){
        do {
            System.out.print(MENU);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    solicitarNuevaTarea();
                    break;

                case 2 :
                    gestorTareas.listarTareas();
                    break;

                case 3:
                    eliminarTarea();
                    break;

                case 4:
                    System.out.println("Gracias por elegirnos \n" +
                            "Apagando Sistema");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }

        }while (opcion != 4);
    }
    private void solicitarNuevaTarea(){
        System.out.println("Preparando la inclusion de la tarea.");

        System.out.println("Ingrese el Titulo");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese la descripcion de la tarea");
        String descripcion = scanner.nextLine();

        System.out.println("Seleccione Prioridad:");
        Prioridad[] prioridades = Prioridad.values();

        for (int i = 0; i < prioridades.length; i++) {
            System.out.println((i + 1) + ". " + prioridades[i]);
        }

        int seleccion = scanner.nextInt();
        scanner.nextLine();

        Prioridad prioridadSeleccionada = prioridades[seleccion - 1];

        System.out.println("Seleccione una categoría:");
        Categoria[] categorias = Categoria.values();

        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i]);
        }

        int catSeleccionada = scanner.nextInt();
        scanner.nextLine();

        Categoria categoriaFinal = categorias[catSeleccionada - 1];

        gestorTareas.agregarTarea(new Tarea(titulo, descripcion, prioridadSeleccionada,categoriaFinal ));
    }

    private void eliminarTarea() {
        List<Tarea> listaActual = gestorTareas.getListaTareas();

        if (listaActual.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }

        System.out.println("Seleccione el número de tarea a eliminar:");
        for (int i = 0; i < listaActual.size(); i++) {
            System.out.println((i + 1) + ". " + listaActual.get(i).getTitulo());
        }

        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice > 0 && indice <= listaActual.size()) {
            String idReal = listaActual.get(indice - 1).getId();
            gestorTareas.eliminarTarea(idReal);
            System.out.println("¡Tarea eliminada con éxito!");
        } else {
            System.out.println("Número inválido.");
        }
    }
}
