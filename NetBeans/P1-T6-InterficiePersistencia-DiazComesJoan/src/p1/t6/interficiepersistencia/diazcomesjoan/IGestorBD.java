/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package p1.t6.interficiepersistencia.diazcomesjoan;

import java.util.List;
import p1t6modeldiazcomesjoan.Categoria;
import p1t6modeldiazcomesjoan.Equip;
import p1t6modeldiazcomesjoan.Equip_Categoria;
import p1t6modeldiazcomesjoan.Equip_Temporada;
import p1t6modeldiazcomesjoan.Jugador;
import p1t6modeldiazcomesjoan.Membre;
import p1t6modeldiazcomesjoan.Temporada;
import p1t6modeldiazcomesjoan.Usuari;

/**
 *
 * @author micro
 */
public interface IGestorBD {
    
    Usuari ferLogin(String login) throws GestorBDException;
  
    void afegirEquip(Equip e) throws GestorBDException;
 
    void afegirJugador(Jugador j) throws GestorBDException;
    
    void afegirCategoria(Categoria c) throws GestorBDException;
  
    void afegirTemporada(Temporada t) throws GestorBDException;
    
    void afegirMembre(Membre t) throws GestorBDException;
    
    void afegirEquip_Temporada(Equip_Temporada et) throws GestorBDException;
    
    void afegirEquip_Categoria(Equip_Categoria ec) throws GestorBDException;

    void tancarCapa() throws GestorBDException;

    void eliminarEquip(Integer e) throws GestorBDException;
    
    void eliminarTemporada(Integer t) throws GestorBDException;

    void eliminarJugador(Integer j) throws GestorBDException;

    void eliminarCategoria(Integer c) throws GestorBDException;
    
    void eliminarMembre(Integer m) throws GestorBDException;
    
    void eliminarEquip_Temporada(Integer et) throws GestorBDException;
    
    void eliminarEquip_Categoria(Integer ep) throws GestorBDException;
  
    List<Equip> trobarEquip() throws GestorBDException;
    
    List<Equip> trobarEquipPerCamp(String camp) throws GestorBDException;
    
    List<Jugador> trobarJugadorPerCamp(String camp) throws GestorBDException;
   
    List<Jugador> trobarJugador() throws GestorBDException;

    List<Categoria> trobarCategoria() throws GestorBDException;
    
    List<Temporada> trobarTemporada() throws GestorBDException;
    
    List<Temporada> trobarTemporadaperCamp(String camp) throws GestorBDException;
    
    List<Membre> trobarMembre() throws GestorBDException;
    
    List<Equip_Temporada> trobarEquip_Temporada() throws GestorBDException;
    
    List<Equip_Categoria> trobarEquip_Categoria() throws GestorBDException;
    
    void editarEquip(Equip e) throws GestorBDException;

    void editarJugador(Jugador j) throws GestorBDException;

    void editarCategoria(Categoria c) throws GestorBDException;

    void editarTemporada(Temporada t) throws GestorBDException;
    
    void editarMembre(Membre m) throws GestorBDException;
    
    void editarEquip_Temporada(Equip_Temporada et) throws GestorBDException;
    
    void editarEquip_Categoria(Equip_Categoria ec) throws GestorBDException;

    void confirmarCanvis() throws GestorBDException;

    void desferCanvis() throws GestorBDException;

}
