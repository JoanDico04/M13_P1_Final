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
public class Equip_Temporada {
    private Integer equip_id;
    private Integer temporada_any;

    public Equip_Temporada (Integer equip_id, Integer temporada_any) {
        this.setEquipId(equip_id);
        this.setTemporadaAny(temporada_any);        
    }
    
    public Integer getEquipId() {
        return equip_id;
    }
    
    private void setEquipId(Integer equip_id) {
        if (equip_id==null) {
            throw new RuntimeException("Cal especifiar el id de l'equip:");
        }
        this.equip_id = equip_id;
    }
    public Integer getTemporadaAny() {
        return temporada_any;
    }

    
    private void setTemporadaAny(Integer temporada_any) {
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
        final Equip_Temporada other = (Equip_Temporada) obj;
        return Objects.equals(this.equip_id, other.equip_id);
    }


    @Override
    public String toString() {
        return "Membre{Id Equip=" + equip_id + ", Any Temporada=" + temporada_any + '}';
    }
}
