/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

//clase hijo
public class CodigoPersonal extends Personas{
    private int codigo;
    public CodigoPersonal(String nombre, int codigo){
        super(nombre);
        this.codigo=codigo;    
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public boolean validar() {
        return codigo >= 21000;
    }
    
}
