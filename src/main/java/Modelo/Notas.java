/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
// Hereda nombre y codigo de CodigoPersonal, y agrega las notas
public class Notas extends CodigoPersonal {
    public Materias materias;

    public Notas(String nombre, int codigo, double software, double hardware, double matematica) {
        super(nombre, codigo);
        this.materias = new Notas_Calculo(software, hardware, matematica);
    }

    public boolean validarCompleto() {
        return validar() && materias.valido();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
             + "\nCódigo: " + getCodigo()
             + "\nNota Desarrollo: " + String.format("%.2f", materias.calcularDesarrollo())
             + "\nNota Matemáticas: " + String.format("%.2f", materias.getMatematica())
             + "\nDefinitiva: " + String.format("%.2f", materias.calculo());
    }

    private static class Notas_Calculo extends Materias {
        public Notas_Calculo(double software, double hardware, double matematica) {
            super(software, hardware, matematica);
        }
        @Override
        public double calcularDesarrollo() { return (software + hardware) / 2; }
        @Override
        public double calculo() { return (calcularDesarrollo() * 0.55) + (matematica * 0.45); }
    }
}