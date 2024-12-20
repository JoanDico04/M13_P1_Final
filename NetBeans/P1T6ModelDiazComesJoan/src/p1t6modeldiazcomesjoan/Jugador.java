/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1t6modeldiazcomesjoan;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author micro
 */
public class Jugador {
    private Integer id;
    private String nom;
    private String cognoms;
    private String sexe;
    private Date data_naix;
    private String IBAN;
    private String IdLegal;
    private Integer any_fi_revisio;
    private String adreça;
   
    

    public Jugador(Integer id, String nom, String cognoms, String sexe, Date data_naix, String IBAN, String IdLegal, Integer any_fi_revisio, 
            String adreça) {
        this.setJugadorId(id);
        this.setJugadorNom(nom);
        this.setJugadorCog(cognoms);
        this.setJugadorSexe(sexe);
        this.setJugadorNaixemet(data_naix);
        this.setJugadorIBAN(IBAN);
        this.setJugadorIdLegal(IdLegal);
        this.setJugadorRevisio(any_fi_revisio);
        this.setJugadorAdreça(adreça);
        
    }
    
     public Integer getJugadorId() {
        return id;
    }

    
    private void setJugadorId(Integer id) {
        this.id = id;
    }

    public String getJugadorNom() {
        return nom;
    }

    
    private void setJugadorNom(String nom) {
       if (nom==null || nom.length()==0 || nom.length()>100) {
            throw new RuntimeException("Nom del jugador obligatori y amb un maxim de 100 caracters");
        }
        this.nom = nom;
    }
    
    public String getJugadorCog() {
        return cognoms;
    }

    
    private void setJugadorCog(String cognoms) {
       if (cognoms==null || cognoms.length()==0 || cognoms.length()>150) {
            throw new RuntimeException("El cognom del jugador obligatori y amb un maxim de 150 caracters");
        }
        this.cognoms = cognoms;
    }
    
    public String getJugadorSexe() {
        return sexe;
    }

    
    private void setJugadorSexe(String sexe) {
       if (sexe==null) {
            throw new RuntimeException("Si el jugador es home obligatori H si es dona una D");
            
        } else if (sexe.length()=='H') {
            throw new RuntimeException("Aquest jugador es home");
            
        } else if (sexe.length()=='D') {
            throw new RuntimeException("Aquest jugador es dona");
        }
        this.sexe = sexe;
    }

   public Date getJugadorNaixemet() {
        return data_naix;
    }

    
    private void setJugadorNaixemet(Date data_naix) {
        this.data_naix = data_naix;
    }
    
    public String getJugadorIBAN() {
        return IBAN;
    }

    
    private void setJugadorIBAN(String IBAN) {
       if (IBAN==null || IBAN.length() < 24) {
            throw new RuntimeException("L'IBAN  a de ser de 24 caracters si o si: ");
        }
        this.IBAN = IBAN;
    }
    
    public String getJugadorIdLegal() {
        return IdLegal;
    }

    
    private void setJugadorIdLegal(String IdLegal) {
        this.IdLegal = IdLegal;
    }
    
     public Integer getJugadorRevisio() {
        return any_fi_revisio;
    }

    
    private void setJugadorRevisio(Integer any_fi_revisio) {
//       if (any_fi_revisio==null || any_fi_revisio  < 2024) {
//            throw new RuntimeException("La revisio esta caducada");
//        }
        this.any_fi_revisio = any_fi_revisio;
    }
    
    public String getJugadorAdreça() {
        return adreça;
    }

    
    private void setJugadorAdreça(String adreça) {
       if (adreça==null || adreça.length()==0 || adreça.length()>255) {
            throw new RuntimeException("L'adreça de contenir obligatoriament caracters i com a maxim 255");
        }
        this.adreça = adreça;
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
        final Jugador other = (Jugador) obj;
        return Objects.equals(this.nom, other.nom);
    }


    @Override
    public String toString() {
        return "Jugador{" + "Nom=" + nom + ", Cognoms=" + cognoms +",  Sexe=" + sexe + ", Data Naixement=" + data_naix + 
                ", IBAN=" + IBAN + ", Fi Revisio=" + any_fi_revisio + ", Adreça=" + adreça +'}';
    }
}
