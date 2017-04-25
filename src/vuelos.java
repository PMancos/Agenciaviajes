/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class vuelos extends presupuestos{
    static int numVuelos;
    
    private String ciudadSalida, ciudadDestino;
    
    private String [] tipoVuelo={"Dentro de la peninsula","Europa","Fuera de Europa"};
    public static final int PENINSULA=0;
    public static final int EUROPA=1;
    public static final int FUERA=2;
    
    private String [] idaVuelta={"Ida","Ida y vuelta"};
    public static final int IDA=0;
    public static final int IDAYVUELTA=1;
    
    private int tiposV, idaVuel;
    
    public static final double TASAPENINSULA=100;
    public static final double TASAEUROPA=150;
    public static final double TASAFUERA=200;

    public vuelos(String ciudadSalida, String ciudadDestino, int tiposV, int idaVuel, String dni, String nombre, int numPasajeros) {
        super(dni, nombre, numPasajeros);
        this.ciudadSalida = ciudadSalida;
        this.ciudadDestino = ciudadDestino;
        this.tiposV = tiposV;
        this.idaVuel = idaVuel;
        numVuelos++;
    }

    public String getCiudadSalida() {
        return ciudadSalida;
    }

    public void setCiudadSalida(String ciudadSalida) {
        this.ciudadSalida = ciudadSalida;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String[] getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String[] tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String[] getIdaVuelta() {
        return idaVuelta;
    }

    public void setIdaVuelta(String[] idaVuelta) {
        this.idaVuelta = idaVuelta;
    }

    public int getTiposV() {
        return tiposV;
    }

    public void setTiposV(int tiposV) {
        this.tiposV = tiposV;
    }

    public int getIdaVuel() {
        return idaVuel;
    }

    public void setIdaVuel(int idaVuel) {
        this.idaVuel = idaVuel;
    }
    
    @Override
    public double calcularPrecio(){
        double precioTotal=0;
        
        if(idaVuel==0){
            if(tiposV==0){
                precioTotal=TASAPENINSULA;
            }else if(tiposV==1){
                precioTotal=TASAEUROPA;
            }else if(tiposV==2){
                precioTotal=TASAFUERA;
            }
        }else if (idaVuel==1){
            if(tiposV==0){
                precioTotal=TASAPENINSULA*2;
            }else if(tiposV==1){
                precioTotal=TASAEUROPA*2;
            }else if(tiposV==2){
                precioTotal=TASAFUERA*2;
            }    
        }
    return precioTotal+CGestion;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCiudad de salida: " + ciudadSalida + "\nCiudad de destino: " 
                + ciudadDestino + "\nTipo de vuelo: " + tipoVuelo[tiposV] + "\nIda o Ida y vuelta: "
                + idaVuelta[idaVuel];
    }
    
    public void contarVuelos(){
        System.out.println("Numero de vuelos: "+numVuelos);
    }
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.print("\t\t\tVuelo\t\t\t"+calcularPrecio());
    }
}
