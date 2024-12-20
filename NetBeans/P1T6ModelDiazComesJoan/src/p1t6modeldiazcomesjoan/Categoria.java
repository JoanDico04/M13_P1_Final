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
public class Categoria {
    private String nom;
    private Integer edat_min;
    private Integer edat_max;
    

    public Categoria(String nom, Integer edat_min, Integer edat_max) {
        this.setCategoriaEdat(edat_min, edat_max);
        this.setCategoriaNom(nom);
    }

    public Integer getCategoriaEdat() {
        return edat_max;
    }

    /* Numero dels equips no modificable */
    private void setCategoriaEdat(Integer edat_min, Integer edat_max) {
        if (edat_min == null || edat_max == null){
            throw new RuntimeException("Necesites posar una edat minima y maxima per a saber la categoria:");
        }
        if (edat_min == 7 || edat_max == 8) {
            throw new RuntimeException("Aquest Jugador es de la categoria Benjami");
        
       } else if (edat_min == 9 || edat_max == 10){
            throw new RuntimeException("Aquest Jugador es de la categoria Alevi");
            
       } else if (edat_min == 12 || edat_max == 13){
            throw new RuntimeException("Aquest Jugador es de la categoria Infantil");
            
       } else if (edat_min == 14 || edat_max == 15){
            throw new RuntimeException("Aquest Jugador es de la categoria Cadet");
            
       } else if (edat_min == 16 || edat_max == 17){
            throw new RuntimeException("Aquest Jugador es de la categoria Juvenil");
            
       } else if (edat_min == 18 || edat_max == 21){
            throw new RuntimeException("Aquest Jugador es de la categoria Senior");
            
       }
        this.edat_min = edat_min;
        this.edat_max = edat_max;
    }
    
    public String getCategoriaNom() {
        return nom;
    }

    public void setCategoriaNom(String nom) {
        if (nom==null || nom.length()==0 || nom.length()>100) {
            throw new RuntimeException("Nom de la categoria obligatori y amb un maxim de 100 caracters");
        }
        this.nom = nom;
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
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.nom, other.nom);
    }


    @Override
    public String toString() {
        return "Categoria{" + "Nom=" + nom + ", Edat Min=" + edat_min + ", Edat Max=" + edat_max + '}';

    }
}
