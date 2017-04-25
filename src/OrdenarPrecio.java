
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loren
 */
public class OrdenarPrecio implements Comparator<presupuestos>{

    @Override
    public int compare(presupuestos o1, presupuestos o2) {
        return (int) (o2.calcularPrecio()-o1.calcularPrecio());
    }

   
    
}
