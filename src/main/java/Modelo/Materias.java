/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

//Clase padre
public class Materias {
    
    protected double software;
    protected double hardware;
    protected double matematica;
    public Materias(double software, double hardware, double matematica){
       this.software=software;
       this.hardware=hardware;
       this.matematica=matematica; 
    }

    public double getSoftware() {
        return software;
    }

    public void setSoftware(double software) {
        this.software = software;
    }

    public double getHardware() {
        return hardware;
    }

    public void setHardware(double hardware) {
        this.hardware = hardware;
    }

    public double getMatematica() {
        return matematica;
    }

    public void setMatematica(double matematica) {
        this.matematica = matematica;
    }
    public double calcularDesarrollo() {
        return 0; // valor inicial
    }
    public double calculo() {
        return 0; // valor inicial
    }

    public String obtenerResultado() {
        return calculo() >= 3.5 ? "SI APRUEBA" : "NO APRUEBA";
    }

    public boolean valido() {
        return software >= 0.0 && software <= 5.0
            && hardware >= 0.0 && hardware <= 5.0
            && matematica >= 0.0 && matematica <= 5.0;
    }
}

