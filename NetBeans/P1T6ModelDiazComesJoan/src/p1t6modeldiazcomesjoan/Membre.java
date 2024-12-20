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
public class Membre {
    private Boolean titular;
    private Integer equip_id;
    private Integer temporada_any;

    public Membre (Boolean titular, Integer equip_id, Integer temporada_any) {
        this.setMembreTitular(titular);
        this.setEquipId(equip_id);
        this.setMembreTemporadaAny(temporada_any);        
    }

    public Boolean getMembreTitular() {
        return titular;
    }

    private void setMembreTitular (Boolean titular) {
        if (titular == true) {
            throw new RuntimeException("Aquest jugador es titular");
        } 
        this.titular = titular;
        throw new RuntimeException("Aquest jugador no es titular");
    }
    
    public Integer getMembreEquipId() {
        return equip_id;
    }

    
    private void setEquipId(Integer equip_id) {
        if (equip_id==null) {
            throw new RuntimeException("Cal especifiar el id de l'equip:");
        }
        this.equip_id = equip_id;
    }
    public Integer getMembreTemporadaAny() {
        return temporada_any;
    }

    
    private void setMembreTemporadaAny(Integer temporada_any) {
        if (temporada_any==null) {
            throw new RuntimeException("Cal especifiar el l'any de la temporada:");
        }
        this.temporada_any = temporada_any;
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
        final Membre other = (Membre) obj;
        return Objects.equals(this.titular, other.titular);
    }


    @Override
    public String toString() {
        return "Membre{" + "Titular=" + titular + ", Id Equip=" + equip_id + ", Any Temporada=" + temporada_any + '}';
    }
    
}
