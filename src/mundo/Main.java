/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import Interfaz.InterfazCarga;

/**
 *
 * @author Jose
 */
public class Main {
    
    public static InterfazCarga miInterfazCarga;
    
    public static void main(String args []){
        miInterfazCarga = new InterfazCarga();
        miInterfazCarga.setVisible(true);
    }
}