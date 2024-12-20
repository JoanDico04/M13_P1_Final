/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1.t7.vista.diazcomesjoan;

import p1.t6.interficiepersistencia.diazcomesjoan.IGestorBD;


/**
 *
 * @author micro
 */
public class Main {
    
    protected static IGestorBD gbd = null;
    
    public static void main(String[] args) {
     //TO DO all code...
    
     try {
            String nomClassePersistencia = args[0];
            // Intent de crear objecte per gestionar la connexió amb la BD
            System.out.println("Intentant establir connexió...");
            gbd = (IGestorBD) Class.forName(nomClassePersistencia).newInstance();
            System.out.println("Connexió establerta");
        } catch (Exception ex) {
            System.out.println(ex.getMessage()+" "+ ex.getStackTrace());
        }   
     Login l = new Login();
     l.setVisible(true);
    }
}

