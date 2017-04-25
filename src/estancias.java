/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class estancias extends presupuestos{
    
    static int numEstancias;
    
    private String ciudad;
    private int numDias,tLocalizacion, tPension;
    private String [] tipoLocalizacion={"Costa","Interior","Capitales Europeas"};
    public static final int COSTA=0;
    public static final int INTERIOR=1;
    public static final int CAPITAL=2;
    private String [] tipoPension={"Solo alojamiento","Media pension","Pension completa"};
    public static final int ALOJAMIENTO=0;
    public static final int MEDIAP=1;
    public static final int PCOMPLETA=2;
    
    public static final double PRECIOCOSTA=45;
    public static final double PRECIOINTERIOR=35;
    public static final double PRECIOCAPITAL=60;

    public estancias(String ciudad, int numDias, int tLocalizacion, int tPension, String dni, String nombre, int numPasajeros) {
        super(dni, nombre, numPasajeros);
        this.ciudad = ciudad;
        this.numDias = numDias;
        this.tLocalizacion = tLocalizacion;
        this.tPension = tPension;
        numEstancias++;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public int gettLocalizacion() {
        return tLocalizacion;
    }

    public void settLocalizacion(int tLocalizacion) {
        this.tLocalizacion = tLocalizacion;
    }

    public int gettPension() {
        return tPension;
    }

    public void settPension(int tPension) {
        this.tPension = tPension;
    }

    public String[] getTipoLocalizacion() {
        return tipoLocalizacion;
    }

    public void setTipoLocalizacion(String[] tipoLocalizacion) {
        this.tipoLocalizacion = tipoLocalizacion;
    }

    public String[] getTipoPension() {
        return tipoPension;
    }

    public void setTipoPension(String[] tipoPension) {
        this.tipoPension = tipoPension;
    }
    
    @Override
    public double calcularPrecio(){
        double precioTotal=0;
        
        if(tPension==0){
            if(tLocalizacion==0){
                precioTotal=PRECIOCOSTA;
            }else if(tLocalizacion==1){
                precioTotal=PRECIOINTERIOR;
            }else if(tLocalizacion==2){
                precioTotal=PRECIOCAPITAL;
            }
        }else if(tPension==1){
            if(tLocalizacion==0){
                precioTotal=PRECIOCOSTA+10;
            }else if(tLocalizacion==1){
                precioTotal=PRECIOINTERIOR+10;
            }else if(tLocalizacion==2){
                precioTotal=PRECIOCAPITAL+10;
            }   
        }else if(tPension==2){
            if(tLocalizacion==0){
                precioTotal=PRECIOCOSTA+15;
            }else if(tLocalizacion==1){
                precioTotal=PRECIOINTERIOR+15;
            }else if(tLocalizacion==2){
                precioTotal=PRECIOCAPITAL+15;
            }
        }
        return precioTotal+CGestion;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCiudad: " + ciudad + "\nNumero de dias: " + numDias
                + "\nLocalizacion: " + tipoLocalizacion[tLocalizacion] + "\nTipo de pension: " + tipoPension[tPension];
    }
    
    public void contarEstancias(){
        System.out.println("Numero de estancias: "+numEstancias);
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.print("\t\t\tHotel\t\t\t"+calcularPrecio());
    }
    
}
