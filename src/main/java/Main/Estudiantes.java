/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;
import Controlador.NotaControlador;
import Vista.NotaVista;

public class Estudiantes {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            NotaVista vista = new NotaVista();
            vista.setVisible(true);
            NotaControlador controlador = new NotaControlador(vista);
            controlador.iniciar();
        });
    }
}