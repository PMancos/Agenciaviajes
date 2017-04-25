
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class aplicacion {
static Scanner teclado=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        File f=new File("agenciaViajes.dat");
        ArrayList<presupuestos>listaPresupuestos=null;
        
        if(!f.exists())
            listaPresupuestos=new ArrayList<presupuestos>();
        else{
            FileInputStream fis;
            
                fis = new FileInputStream(f);
                ObjectInputStream ois;
            
                ois = new ObjectInputStream(fis);
                listaPresupuestos= (ArrayList<presupuestos>) ois.readObject();

                ois.close();
                fis.close();
        }
        
        int opcion=0;
        
        boolean modificado=false;
        
            do {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        contratarVacaciones(listaPresupuestos);
                        modificado = true;
                        break;
                    case 2:
                        Collections.sort(listaPresupuestos);
                        mostrar(listaPresupuestos);
                        modificado = true;
                        break;
                    case 3:
                        Collections.sort(listaPresupuestos, new OrdenarPrecio());
                        mostrar(listaPresupuestos);
                        break;
                    case 4:
                        if (modificado) {
                            //Si se ha modificado guardamos los cambios
                            FileOutputStream fos = new FileOutputStream(f);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            System.out.println("Guardado correctamente");
                            oos.writeObject(listaPresupuestos);
                            oos.close();
                        } else {
                            System.out.println("No ha habido cambios, no se ha guardado");
                        }
                        System.out.println("Datos guardados correctamente.");
                        break;

                }
            } while (opcion !=4);
            
            } catch (FileNotFoundException ex) {
                Logger.getLogger(aplicacion.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex) {
                Logger.getLogger(aplicacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(aplicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    public static int pedirNumeroEntero() {
        int n = 0;
        try {
            n = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error no has introducido un entero");
            teclado.nextLine();
        }
        return n;
    }

    public static int menu() {

        System.out.println("\n1. Contratar vacaciones"
                + "\n2. Listar presupuestos ordenados por nombre y si coincide por DNI"
                + "\n3. Listar presupuestos por precio de mayor a menor"
                + "\n4. Salir\n");

        int opcion;
        do {
            System.out.print("Introduce una opcion (1/5): ");
            opcion = pedirNumeroEntero();
        } while (opcion < 1 || opcion > 5);
        teclado.nextLine();
        return opcion;
    }
    
    public static void contratarVacaciones(ArrayList<presupuestos>lista){
        String dni,nombre,ciudadO,ciudadD, nomCiudad;
        int personas, opcion,idayvuelta,tipoVuelo, numDias,tipoLoca, tipoPension;
        
        System.out.println("");
        System.out.print("Introduzca el numero de DNI: ");
            dni=teclado.nextLine();
        System.out.print("Introduzca su nombre: ");
            nombre=teclado.nextLine();
        System.out.print("Introduzca el numero de personas: ");
            personas=pedirNumeroEntero();
        System.out.println("");
        System.out.print("Elija el tipo de servicio: \n0. Vuelo\n1. Estancia");
        System.out.println("");
        opcion=pedirNumeroEntero();
        
        if(opcion==0){
            teclado.nextLine();
            System.out.print("Introduzca la ciudad de origen: ");
                ciudadO=teclado.nextLine();
            System.out.print("Introduzca la ciudad de destino: ");
                ciudadD=teclado.nextLine();
            System.out.print("Elija la opcion: \n0. Solo ida\n1. Ida y vuelta");
            System.out.println("");
                idayvuelta=pedirNumeroEntero();
            System.out.println("Elija el tipo de vuelo: \n0. Peninsula\n1. Europa\n2. Fuera de Europa");
            System.out.println("");
                tipoVuelo=pedirNumeroEntero();
                
            lista.add(new vuelos(ciudadO, ciudadD, tipoVuelo, idayvuelta, dni, nombre, personas));
            System.out.println("");
            System.out.println("Vuelo creado");
            
            
        }else if (opcion==1){
            teclado.nextLine();
            System.out.print("Introduzca el nombre de la ciudad: ");
                nomCiudad=teclado.nextLine();
            System.out.print("Introduzca el numero de dias: ");
                numDias=pedirNumeroEntero();
            System.out.print("Elija el tipo de localizacion: \n0. Costa\n1. Interior\n2. Capital");
            System.out.println("");
                tipoLoca=pedirNumeroEntero();
            System.out.print("Elija el tipo de pension: \n0. Solo alojamiento\n1. Media pension\n2. Pension completa ");
            System.out.println("");
                tipoPension=pedirNumeroEntero();
            
            lista.add(new estancias(nomCiudad, numDias, tipoLoca, tipoPension, dni, nombre, personas));
            System.out.println("");
            System.out.println("Estancia creada");
        }
    }
    public static void mostrar(ArrayList<presupuestos>lista){
         System.out.println("\nNombre\tDNI Cliente\tNumero de pasajeros\tTipo de servicio\tPrecio"
                          + "\n______\t___________\t___________________\t________________\t______");
        
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).mostrar();
            System.out.println("");
        }
    }
            
}
    

