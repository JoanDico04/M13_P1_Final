/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p1t6modeldiazcomesjoan;

import java.util.Objects;

/**
 *
 * @author micro
 */
public final class Equip {
    
    private Integer id;
    private String nom;
    private String tipus;

    public Equip(Integer id, String nom, String tipus) {
        this.setNomEquip(nom);
        this.setTipusEquip(tipus);
        this.setIdEquip(id);
    }
    
    public Integer getIdEquip() {
        return id;
    }

    private void setIdEquip(Integer id) {
        this.id = id;
    }

    public String getNomEquip() {
        return nom;
    }

    private void setNomEquip(String nom) {
        this.nom = nom;
    }

    public String getEquipTipus() {
        return tipus;
    }

    public void setTipusEquip(String tipus) {
        this.tipus = tipus;
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
        final Equip other = (Equip) obj;
        return Objects.equals(this.nom, other.nom);
    }


    @Override
    public String toString() {
        return "Equip{" + "Nom=" + nom + ", Tipus=" + tipus + '}';
    }
    
}
