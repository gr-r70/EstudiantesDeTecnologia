/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Contador {
    private Notas[] estudiantes;
    private int contador;

    public Contador(int cantidad) {
        estudiantes = new Notas[cantidad];
        contador = 0;
    }

    public boolean agregarEstudiante(Notas estudiante) {
        if (contador < estudiantes.length) {
            estudiantes[contador] = estudiante;
            contador++;
            return true;
        }
        return false;
    }

    // Sobrecarga: buscar por código (int)
    public Notas buscar(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getCodigo() == codigo) {
                return estudiantes[i];
            }
        }
        return null;
    }

    // Sobrecarga: buscar por nombre (String)
    public Notas buscar(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    public Notas[] getEstudiantes() { return estudiantes; }
    public int getContador() { return contador; }
}