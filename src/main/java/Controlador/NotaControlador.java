/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Contador;
import Modelo.Notas;
import Vista.NotaVista;

public class NotaControlador {

    private final NotaVista vista;
    private Contador curso;

    public NotaControlador(NotaVista vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.menuInicio();
            switch (opcion) {
                case 1: definirTamano();        break;
                case 2: añadirEstudiantes();    break;
                case 3: resultadosDefinitivos(); break;
                case 4: listaEstudiantes();     break;
                case 5: incrementarDesarrollo(); break;
                case 6: modificarNota();        break;
                case 7: vista.mostrarMensaje("Saliendo del sistema"); break;
                default: vista.mostrarMensaje("Opción inválida");
            }
        } while (opcion != 7);
    }

    private void definirTamano() {
        int cantidad = vista.pedirCantidadEstudiantes();
        curso = new Contador(cantidad);
        vista.mostrarMensaje("Sistema configurado para " + cantidad + " estudiantes.");
    }

    private void añadirEstudiantes() {
        if (curso == null) { vista.mostrarMensaje("Primero defina la cantidad."); return; }

        String nombre = vista.pedirNombre();
        int codigo    = vista.pedirCodigo();
        double s      = vista.pedirNotaS();
        double h      = vista.pedirNotaH();
        double m      = vista.pedirNotaM();

        Notas estudiante = new Notas(nombre, codigo, s, h, m);

        if (!estudiante.validarCompleto()) {
            vista.mostrarMensaje("Datos inválidos."); return;
        }
        if (curso.agregarEstudiante(estudiante)) {
            vista.mostrarMensaje("Estudiante agregado correctamente.");
        } else {
            vista.mostrarMensaje("No hay más espacio.");
        }
    }

    private void resultadosDefinitivos() {
        if (curso == null || curso.getContador() == 0) {
            vista.mostrarMensaje("No hay estudiantes."); return;
        }
        Notas[] lista = curso.getEstudiantes();
        int total = curso.getContador();

        // Ordenar de mayor a menor definitiva (burbuja)
        for (int i = 0; i < total - 1; i++) {
            for (int j = 0; j < total - 1 - i; j++) {
                if (lista[j].calculo() < lista[j + 1].calculo()) {
                    Notas temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
        String mensaje = "===== RESULTADOS =====\n\n";
        for (int i = 0; i < total; i++) {
            mensaje += lista[i].toString() + "\n";
            mensaje += "Estado: " + lista[i].obtenerResultado() + "\n";
            mensaje += "----------------------\n";
        }
        vista.mostrarMensaje(mensaje);
    }

    private void listaEstudiantes() {
        if (curso == null || curso.getContador() == 0) {
            vista.mostrarMensaje("No hay estudiantes."); return;
        }
        double limite = vista.pedirNotaLimite();
        if (limite < 0.0 || limite > 5.0) {
            vista.mostrarMensaje("Nota inválida."); return;
        }
        Notas[] lista = curso.getEstudiantes();
        int total = curso.getContador();
        String mensaje = "Estudiantes con nota superior a " + limite + ":\n\n";
        for (int i = 0; i < total; i++) {
            if (lista[i].calculo() > limite) {
                mensaje += "Código: " + lista[i].getCodigo() + "\n";
                mensaje += "Nombre: " + lista[i].getNombre() + "\n";
                mensaje += "Definitiva: " + String.format("%.2f", lista[i].calculo()) + "\n";
                mensaje += "------------------\n";
            }
        }
        vista.mostrarMensaje(mensaje);
    }

    private void incrementarDesarrollo() {
        if (curso == null || curso.getContador() == 0) {
            vista.mostrarMensaje("No hay estudiantes."); return;
        }
        double incremento = vista.pedirIncrementoDesarrollo();
        if (incremento < 0.0 || incremento > 0.5) {
            vista.mostrarMensaje("Incremento inválido."); return;
        }
        Notas[] lista = curso.getEstudiantes();
        for (int i = 0; i < curso.getContador(); i++) {
            double nuevo = lista[i].calcularDesarrollo() + incremento;
            if (nuevo > 5.0) nuevo = 5.0;
            lista[i].setSoftware(nuevo);
            lista[i].setHardware(nuevo);
        }
        vista.mostrarMensaje("Incremento aplicado.");
    }

    private void modificarNota() {
        if (curso == null) { vista.mostrarMensaje("No hay estudiantes."); return; }
        int codigo = vista.pedirBuscarCodigo();
        // Sobrecarga: buscar por int
        Notas estudiante = curso.buscar(codigo);
        if (estudiante == null) { vista.mostrarMensaje("Estudiante no encontrado."); return; }

        estudiante.setSoftware(vista.pedirNotaS());
        estudiante.setHardware(vista.pedirNotaH());
        estudiante.setMatematica(vista.pedirNotaM());
        vista.mostrarMensaje("Nota modificada correctamente.");
    }
}
