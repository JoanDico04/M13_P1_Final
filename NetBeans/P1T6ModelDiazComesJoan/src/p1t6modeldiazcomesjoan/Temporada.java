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
public class Temporada {
    private Integer id;
    private Integer any_temporada;    

    public Temporada(Integer id, Integer any_temporada) {
        this.setTemporadaId(id);
        this.setTemporada(any_temporada);
        
    }
    
    public Integer getTemporadaId() {
        return id;
    }

    
    private void setTemporadaId(Integer id) {
        this.id = id;
    }

    public Integer getTemporada() {
        return any_temporada;
    }

    
    private void setTemporada(Integer any_temporada) {
        this.any_temporada = any_temporada;
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
        final Temporada other = (Temporada) obj;
        return Objects.equals(this.any_temporada, other.any_temporada);
    }


    @Override
    public String toString() {
        return "Temporada{" + "Any=" + any_temporada + '}';
    }
}
