
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public abstract class presupuestos implements Serializable, Comparable<presupuestos>{
    static int numPres;
    
    private String dni, nombre;
    private int numPasajeros;
    public static final double CGestion=8.25;

    public presupuestos(String dni, String nombre, int numPasajeros) {
        this.dni = dni;
        this.nombre = nombre;
        this.numPasajeros = numPasajeros;
        numPres++;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + "\nNombre: " + nombre + "\nNumero de pasajeros: " + numPasajeros;
    }
    
    public double calcularPrecio(){
        return 0;
    }
    
    public void contarPresupuestos(){
        System.out.println("Numero de presupuestos: "+numPres);
    }
    public void mostrar(){
        System.out.print(nombre+"\t"+dni+"\t"+numPasajeros);
    }

    @Override
    public int compareTo(presupuestos o) {
        
        if(this.nombre.equalsIgnoreCase(o.nombre))
            return this.dni.compareToIgnoreCase(o.dni);
        else
            return  this.nombre.compareToIgnoreCase(o.nombre);
            
    }
}
