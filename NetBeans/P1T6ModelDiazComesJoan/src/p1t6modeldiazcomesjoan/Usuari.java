    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1t6modeldiazcomesjoan;

import java.util.Objects;

/**
 *
 * @author micro
 */
public class Usuari {
    private String login;
    private String passw;
    private String nom;

    public Usuari(String login, String passw, String nom) {
        this.setUsuariLogin(login);
        this.setUsuariPassw(passw);
        this.setUsuariNom(nom);

    }

    public String getUsuariLogin() {
        return login;
    }

    public void setUsuariLogin(String login) {
          
        this.login = login;
    }
    
    public String getUsuariNom() {
        return nom;
    }

    public void setUsuariNom(String nom) {
      
        this.nom = nom;
    }
    
     
    public String getUsuariPassw() {
        return passw;
    }

    public void setUsuariPassw(String passw) {
        
        this.passw = passw;
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuari other = (Usuari) obj;
        return Objects.equals(this.login, other.login);
    }


    @Override
    public String toString() {
        return "Usuari{" + "Login=" + login + ", Nom=" + nom + ", Password=" + passw + '}';
    }
}
