/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p1t6capaoraclediazcomesjoan;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import p1.t6.interficiepersistencia.diazcomesjoan.GestorBDException;
import p1.t6.interficiepersistencia.diazcomesjoan.IGestorBD;
import p1t6modeldiazcomesjoan.Categoria;
import p1t6modeldiazcomesjoan.Equip;
import p1t6modeldiazcomesjoan.Equip_Temporada;
import p1t6modeldiazcomesjoan.Equip_Categoria;
import p1t6modeldiazcomesjoan.Jugador;
import p1t6modeldiazcomesjoan.Membre;
import p1t6modeldiazcomesjoan.Temporada;
import p1t6modeldiazcomesjoan.Usuari;

/**
 *
 * @author micro
 */
public class GestorBDEmpresaJdbc implements IGestorBD {
     private Connection conn;
     
    private PreparedStatement psDelListEquip;
    private PreparedStatement psUpdateEquip;
    private PreparedStatement psInsertEquip;
    
    private PreparedStatement psDelListJugador;
    private PreparedStatement psUpdateJugador;
    private PreparedStatement psInsertJugador;
    
    private PreparedStatement psDelListCategoria;
    private PreparedStatement psUpdateCategoria;
    private PreparedStatement psInsertCategoria;
    
    private PreparedStatement psDelListTemporada;
    private PreparedStatement psUpdateTemporada;
    private PreparedStatement psInsertTemporada;
    
    private PreparedStatement psDelListMembre;
    private PreparedStatement psUpdateMembre;
    private PreparedStatement psInsertMembre;
    
    private PreparedStatement psDelListEquip_Temporada;
    private PreparedStatement psUpdateEquip_Temporada;
    private PreparedStatement psInsertEquip_Temporada;
    
    private PreparedStatement psDelListEquip_Categoria;
    private PreparedStatement psUpdateEquip_Categoria;
    private PreparedStatement psInsertEquip_Categoria;
    
    
    
    public GestorBDEmpresaJdbc() throws GestorBDException {
        String nomFitxer = "alumneJDBC.xml";
        try {
            Properties props = new Properties();
            props.loadFromXML(new FileInputStream(nomFitxer));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new GestorBDException("L'arxiu " + nomFitxer + " no troba la clau " + claus[i]);
                }
            }
            conn = DriverManager.getConnection(valors[0], valors[1], valors[2]);
            conn.setAutoCommit(false);
        } catch (IOException ex) {
            
            throw new GestorBDException("Problemes en recuperar l'arxiu de configuració " + nomFitxer, ex);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new GestorBDException("No es pot establir la connexió.", ex);
        }
    }
    
     @Override
    public void tancarCapa() throws GestorBDException {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new GestorBDException("Error en fer rollback final.", ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new GestorBDException("Error en tancar la connexió.\n", ex);
            }
        }
    }
    
     @Override
    public List<Equip> trobarEquip() throws GestorBDException {
    
    List<Equip> llEquip = new ArrayList<>();

    String query = "SELECT * FROM equip";
    try (PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            Equip eq = new Equip(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("tipus")
            );
            llEquip.add(eq);
        }

        } catch (SQLException ex) {
            throw new GestorBDException("Error al recuperar la lista de equipos.", ex);
        }

        // Validación final
        if (llEquip.isEmpty()) {
            System.out.println("No se encontraron equipos en la base de datos.");
        } else {
            System.out.println("Equipos recuperados: " + llEquip.size());
        }

        return llEquip;
    }
    
     @Override
    public List<Categoria> trobarCategoria() throws GestorBDException {
        List<Categoria> llCategoria = new ArrayList<Categoria>();
        Statement c = null;
        try {
            c = conn.createStatement();
            ResultSet rs = c.executeQuery("SELECT nom, edat_min, edat_max FROM categoria");
            while (rs.next()) {
                String nom = rs.getString("nom");
                Integer edat_min = rs.getInt("edat_min");
                Integer edat_max = rs.getInt("edat_max");
                Categoria cat = new Categoria(nom, edat_min, edat_max);
                llCategoria.add(cat);
                llCategoria.add(new Categoria(rs.getString("nom"), rs.getInt(edat_min), 
                        rs.getInt(edat_max)));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar recuperar la llista de categories.", ex);
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException ex) {
                    throw new GestorBDException("Error en intentar tancar la sentència que ha recuperat la llista de categories.", ex);
                }
            }
        }
        return llCategoria;
    }
    
     @Override
    public List<Temporada> trobarTemporada() throws GestorBDException {
        List<Temporada> llTemporada = new ArrayList<>();

        String query = "SELECT * FROM temporada";
        try (PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Temporada tem = new Temporada(
                    rs.getInt("id"),
                    rs.getInt("any_temporada")
                );
                llTemporada.add(tem);
            }

            } catch (SQLException ex) {
                throw new GestorBDException("Error al recuperar la lista de equipos.", ex);
            }

            // Validación final
            if (llTemporada.isEmpty()) {
                System.out.println("No se encontraron temporadas en la base de datos.");
            } else {
                System.out.println("Temporadas recuperados: " + llTemporada.size());
            }

            return llTemporada;
    }
    
     @Override
    public List<Membre> trobarMembre() throws GestorBDException {
        List<Membre> llMembre = new ArrayList<Membre>();
        Statement m = null;
        try {
            m = conn.createStatement();
            ResultSet rs = m.executeQuery("SELECT titular, equip_id, temporada_any FROM membre");
            while (rs.next()) {
                Boolean titular = rs.getBoolean("titular");
                Integer equip_id = rs.getInt("equip_id");
                Integer temporada_any = rs.getInt("temporada_any");
                Membre mem = new Membre(titular, equip_id, temporada_any);
                llMembre.add(mem);
                llMembre.add(new Membre(rs.getBoolean("titular"), rs.getInt("equip_id"), 
                        rs.getInt("temporada_any")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar recuperar la llista de membres.", ex);
        } finally {
            if (m != null) {
                try {
                    m.close();
                } catch (SQLException ex) {
                    throw new GestorBDException("Error en intentar tancar la sentència que ha recuperat la llista de membres.", ex);
                }
            }
        }
        return llMembre;
    }
    
     @Override
    public List<Equip_Temporada> trobarEquip_Temporada() throws GestorBDException {
        List<Equip_Temporada> llEquip_Temporada = new ArrayList<Equip_Temporada>();
        Statement eqtem = null;
        try {
            eqtem = conn.createStatement();
            ResultSet rs = eqtem.executeQuery("SELECT equip_id, temporada_any FROM equip_temporada");
            while (rs.next()) {
                Integer equip_id = rs.getInt("equip_id");
                Integer temporada_any = rs.getInt("temporada_any");
                Equip_Temporada et = new Equip_Temporada(equip_id, temporada_any);
                llEquip_Temporada.add(et);
                llEquip_Temporada.add(new Equip_Temporada(rs.getInt("equip_id"), 
                        rs.getInt("temporada_any")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar recuperar la llista de equip_temporades.", ex);
        } finally {
            if (eqtem != null) {
                try {
                    eqtem.close();
                } catch (SQLException ex) {
                    throw new GestorBDException("Error en intentar tancar la sentència que ha recuperat la llista de equip_temporades.", ex);
                }
            }
        }
        return llEquip_Temporada;
    }
    
     @Override
    public List<Equip_Categoria> trobarEquip_Categoria() throws GestorBDException {
        List<Equip_Categoria> llEquip_Categoria = new ArrayList<Equip_Categoria>();
        Statement eqcat = null;
        try {
            eqcat = conn.createStatement();
            ResultSet rs = eqcat.executeQuery("SELECT equip_id, temporada_any FROM equip_categoria");
            while (rs.next()) {
                Integer equip_id = rs.getInt("equip_id");
                Integer temporada_any = rs.getInt("temporada_any");
                Equip_Categoria et = new Equip_Categoria(equip_id, temporada_any);
                llEquip_Categoria.add(et);
                llEquip_Categoria.add(new Equip_Categoria(rs.getInt("equip_id"), 
                        rs.getInt("temporada_any")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar recuperar la llista de equip_categoria.", ex);
        } finally {
            if (eqcat != null) {
                try {
                    eqcat.close();
                } catch (SQLException ex) {
                    throw new GestorBDException("Error en intentar tancar la sentència que ha recuperat la llista de equip_categories.", ex);
                }
            }
        }
        return llEquip_Categoria;
    }
    
     @Override
    public void eliminarEquip(Integer id) throws GestorBDException {
        if (psDelListEquip == null) {
            try {
                psDelListEquip = conn.prepareStatement("DELETE FROM equip WHERE id = ?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psDelListEquip", ex);
            }
        }
        try {
            
            int eq = 0;
           
            psDelListEquip.setInt(1, id);
            eq = psDelListEquip.executeUpdate();  

        } catch (SQLException ex) {
            try { 
                conn.rollback();
            } catch (SQLException ex1) {
                throw new GestorBDException("Error rollback", ex);
            }
            throw new GestorBDException("Error en eliminar els jugadors de codi indicat", ex);
        }
    }
    
     @Override
    public void eliminarTemporada(Integer id) throws GestorBDException {
        if (psDelListTemporada == null) {
            try {
                psDelListTemporada = conn.prepareStatement("DELETE FROM temporada WHERE any_temporada = ?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psDelListTemporada", ex);
            }
        }
        try {
            
            int temp = 0;
           
            psDelListTemporada.setInt(1, id);
            temp = psDelListTemporada.executeUpdate();  

        } catch (SQLException ex) {
            try { 
                conn.rollback();
            } catch (SQLException ex1) {
                throw new GestorBDException("Error rollback", ex);
            }
            throw new GestorBDException("Error en eliminar les temporades de codi indicat", ex);
        }
    }
    
     @Override
    public void eliminarJugador(Integer id) throws GestorBDException {
        if (psDelListJugador == null) {
            try {
                psDelListJugador = conn.prepareStatement("DELETE FROM jugador WHERE id = ?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psDelListJugador", ex);
            }
        }
        try {
            
            int jug = 0;
           
            psDelListJugador.setInt(1, id);
            jug = psDelListJugador.executeUpdate();  

        } catch (SQLException ex) {
            try { 
                conn.rollback();
            } catch (SQLException ex1) {
                throw new GestorBDException("Error rollback", ex);
            }
            throw new GestorBDException("Error en eliminar els jugadors de codi indicat", ex);
        }
    }
    
     @Override
    public void eliminarCategoria(Integer c) throws GestorBDException {
        if (psDelListCategoria == null) {
            try {
                psDelListCategoria = conn.prepareStatement("DELETE FROM categoria WHERE nom = ?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psDelListCategoria", ex);
            }
        }
        Savepoint sp = null;
        try {
            sp = conn.setSavepoint();
            int cat = 0;
            
               // psDelListCategoria.setInt(1, codi);
                cat = cat + psDelListCategoria.executeUpdate();
            
            
        } catch (SQLException ex) {
            if (sp != null) {
                try {
                    conn.rollback(sp);
                } catch (SQLException ex1) {
                }
            }
            throw new GestorBDException("Error en eliminar les categories de codi indicat", ex);
        }
    }
    
     @Override
    public void eliminarMembre(Integer m) throws GestorBDException {
        if (psDelListMembre == null) {
            try {
                psDelListMembre = conn.prepareStatement("DELETE FROM membre WHERE titular = ?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psDelListMembre", ex);
            }
        }
        Savepoint sp = null;
        try {
            sp = conn.setSavepoint();
            int mem = 0;
            
                //psDelListMembre.setInt(1, codi);
                //mem = mem + psDelListMembre.executeUpdate();
            
           
        } catch (SQLException ex) {
            if (sp != null) {
                try {
                    conn.rollback(sp);
                } catch (SQLException ex1) {
                }
            }
            throw new GestorBDException("Error en eliminar els membres de codi indicat", ex);
        }
    }
    
     @Override
    public void eliminarEquip_Temporada(Integer et) throws GestorBDException {
        if (psDelListEquip_Temporada == null) {
            try {
                psDelListEquip_Temporada = conn.prepareStatement("DELETE FROM equip_temporada WHERE equip_id = ?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psDelListEquip_Temporada", ex);
            }
        }
        Savepoint sp = null;
        try {
            sp = conn.setSavepoint();
            int eqtemp = 0;
            
                //psDelListEquip_Temporada.setInt(1, codi);
                //eqtemp = eqtemp + psDelListEquip_Temporada.executeUpdate();
          
           
        } catch (SQLException ex) {
            if (sp != null) {
                try {
                    conn.rollback(sp);
                } catch (SQLException ex1) {
                }
            }
            throw new GestorBDException("Error en eliminar els equips_temporades de codi indicat", ex);
        }
    }
    
     @Override
    public void eliminarEquip_Categoria(Integer ec) throws GestorBDException {
        if (psDelListEquip_Categoria == null) {
            try {
                psDelListEquip_Categoria = conn.prepareStatement("DELETE FROM equip_categoria WHERE equip_id = ?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psDelListEquip_Categoria", ex);
            }
        }
        Savepoint sp = null;
        try {
            sp = conn.setSavepoint();
            int eqcat = 0;
            
                //psDelListEquip_Categoria.setInt(1, codi);
                //eqcat = eqcat + psDelListEquip_Categoria.executeUpdate();
           
        } catch (SQLException ex) {
            if (sp != null) {
                try {
                    conn.rollback(sp);
                } catch (SQLException ex1) {
                }
            }
            throw new GestorBDException("Error en eliminar els equips_categories de codi indicat", ex);
        }
    }
    
     @Override
    public void afegirEquip(Equip e) throws GestorBDException {
        if (psInsertEquip == null) {
            try {
                psInsertEquip = conn.prepareStatement("INSERT INTO equip VALUES (?,?)");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psInsertEquip", ex);
            }
        }
        try {
            psInsertEquip.setString(1, e.getNomEquip());
            psInsertEquip.setString(2, e.getEquipTipus());
            psInsertEquip.executeUpdate();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar inserir el equip " + e.getNomEquip(), ex);
        }
    }
    
     @Override
    public void afegirJugador(Jugador j) throws GestorBDException {
        if (psInsertJugador == null) {
            try {
                psInsertJugador = conn.prepareStatement("INSERT INTO jugador VALUES (?,?,?,?,?,?,?)");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psInsertJugador", ex);
            }
        }
        try {
            psInsertJugador.setString(1, j.getJugadorNom());
            psInsertJugador.setString(2, j.getJugadorCog());
            psInsertJugador.setString(3, j.getJugadorSexe());
            psInsertJugador.setDate(4, (java.sql.Date)j.getJugadorNaixemet());
            psInsertJugador.setString(5, j.getJugadorIBAN());
            psInsertJugador.setInt(6, j.getJugadorRevisio());
            psInsertJugador.setString(7, j.getJugadorAdreça());
            psInsertJugador.executeUpdate();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar inserir el jugador " + j.getJugadorNom(), ex);
        }
    }

     @Override
    public void afegirCategoria(Categoria c) throws GestorBDException {
        if (psInsertCategoria == null) {
            try {
                psInsertCategoria = conn.prepareStatement("INSERT INTO categoria VALUES (?,?,?)");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psInsertCategoria", ex);
            }
        }
        try {
            psInsertCategoria.setString(1, c.getCategoriaNom());
            psInsertCategoria.setInt(2, c.getCategoriaEdat());
            psInsertCategoria.executeUpdate();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar inserir la categoria " + c.getCategoriaNom(), ex);
        }
    }

     @Override
    public void afegirTemporada(Temporada t) throws GestorBDException {
        if (psInsertTemporada == null) {
            try {
                psInsertTemporada = conn.prepareStatement("INSERT INTO temporada VALUES (?)");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psInsertTemporada", ex);
            }
        }
        try {
            psInsertTemporada.setInt(1, t.getTemporada());
            psInsertTemporada.executeUpdate();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar inserir la temporada " + t.getTemporada(), ex);
        }
    }
    
     @Override
    public void afegirMembre(Membre m) throws GestorBDException {
        if (psInsertMembre == null) {
            try {
                psInsertMembre = conn.prepareStatement("INSERT INTO membre VALUES (?,?,?)");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psInsertMembre", ex);
            }
        }
        try {
            psInsertMembre.setBoolean(1, m.getMembreTitular());
            psInsertMembre.setInt(1, m.getMembreEquipId());
            psInsertMembre.setInt(1, m.getMembreTemporadaAny());
            psInsertMembre.executeUpdate();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar inserir el membre " + m.getMembreTitular(), ex);
        }
    }
    
    public void afegirEquip_Temporada(Equip_Temporada et) throws GestorBDException {
        if (psInsertEquip_Temporada == null) {
            try {
                psInsertEquip_Temporada = conn.prepareStatement("INSERT INTO equip_temporada VALUES (?,?)");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psInsertEquip_Temporada", ex);
            }
        }
        try {
            psInsertEquip_Temporada.setInt(1, et.getEquipId());
            psInsertEquip_Temporada.setInt(1, et.getTemporadaAny());
            psInsertEquip_Temporada.executeUpdate();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar inserir el equip_temporada " + et.getEquipId(), ex);
        }
    }
    
     @Override
    public void afegirEquip_Categoria(Equip_Categoria ec) throws GestorBDException {
        if (psInsertEquip_Categoria == null) {
            try {
                psInsertEquip_Categoria = conn.prepareStatement("INSERT INTO equip_categoria VALUES (?,?)");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psInsertEquip_Categoria", ex);
            }
        }
        try {
            psInsertEquip_Categoria.setInt(1, ec.getEquipId());
            psInsertEquip_Categoria.setInt(1, ec.getTemporadaAny());
            psInsertEquip_Categoria.executeUpdate();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar inserir el equip_categoria" + ec.getEquipId(), ex);
        }
    }

     @Override
    public void editarEquip(Equip e) throws GestorBDException {
        if (psUpdateEquip == null) {
            try {
                psUpdateEquip = conn.prepareStatement("UPDATE equip SET nom=?, tipus=? WHERE id=?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psUpdateEquip", ex);
            }
        }
        try {
            psUpdateEquip.setString(1, e.getNomEquip());
            psUpdateEquip.setString(2, e.getEquipTipus());
            psUpdateEquip.setInt(3, e.getIdEquip());
            int eq = psUpdateEquip.executeUpdate();
            if (eq == 0) {
                throw new GestorBDException("Equip no modificat per no existir");
            }
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar modificar l'equip " + e.getNomEquip(), ex);
        }
    } 
    
     @Override
    public void editarJugador(Jugador j) throws GestorBDException {
        if (psUpdateJugador == null) {
            try {
                psUpdateJugador = conn.prepareStatement("UPDATE jugador SET nom=?, cognoms=?, sexe=?, data_naix=?, IBAN=?"
                        + ", any_fi_revisio_medica=?, adreça=? WHERE id=?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psUpdateJugador", ex);
            }
        }
        try {
            psUpdateJugador.setString(1, j.getJugadorNom());
            psUpdateJugador.setString(2, j.getJugadorCog());
            psUpdateJugador.setString(3, j.getJugadorSexe());
            psUpdateJugador.setDate(4, new java.sql.Date(j.getJugadorNaixemet().getTime()));
            psUpdateJugador.setString(5, j.getJugadorIBAN());
            psUpdateJugador.setInt(6, j.getJugadorRevisio());
            psUpdateJugador.setString(7, j.getJugadorAdreça());
            psUpdateJugador.setInt(8, j.getJugadorId());
            int ju = psUpdateJugador.executeUpdate();
            if (ju == 0) {
                throw new GestorBDException("Jugador no modificat per no existir");
            }
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar modificar el jugador " + j.getJugadorNom(), ex);
        }
    } 
    
     @Override
    public void editarCategoria(Categoria c) throws GestorBDException {
        if (psUpdateCategoria == null) {
            try {
                psUpdateCategoria = conn.prepareStatement("UPDATE categoria SET edat_min=?, edat_max WHERE nom=?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psUpdateCategoria", ex);
            }
        }
        try {
            psUpdateCategoria.setString(1, c.getCategoriaNom());
            psUpdateCategoria.setInt(2, c.getCategoriaEdat());
            int cat = psUpdateCategoria.executeUpdate();
            if (cat == 0) {
                throw new GestorBDException("Categoria no modificat per no existir");
            }
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar modificar la categoria " + c.getCategoriaNom(), ex);
        }
    } 
    
    public void editarTemporada(Temporada t) throws GestorBDException {
        if (psUpdateTemporada == null) {
            try {
                psUpdateTemporada = conn.prepareStatement("UPDATE temporada SET any_temporada=? WHERE id=?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psUpdateJugador", ex);
            }
        }
        try {
            psUpdateTemporada.setInt(1, t.getTemporada());
            psUpdateTemporada.setInt(2, t.getTemporadaId());
            int ju = psUpdateTemporada.executeUpdate();
            if (ju == 0) {
                throw new GestorBDException("Temporada no modificat per no existir");
            }
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar modificar el temporada " + t.getTemporada(), ex);
        }
    } 
    
     @Override
    public void editarMembre(Membre m) throws GestorBDException {
        if (psUpdateMembre == null) {
            try {
                psUpdateMembre = conn.prepareStatement("UPDATE membre WHERE titular=?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psUpdateMembre", ex);
            }
        }
        try {
            psUpdateMembre.setBoolean(1, m.getMembreTitular());
            psUpdateMembre.setInt(1, m.getMembreEquipId());
            psUpdateMembre.setInt(1, m.getMembreTemporadaAny());
            int mem = psUpdateMembre.executeUpdate();
            if (mem == 0) {
                throw new GestorBDException("Membre no modificat per no existir");
            }
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar modificar el membre " + m.getMembreTitular(), ex);
        }
    } 
    
     @Override
    public void editarEquip_Temporada(Equip_Temporada et) throws GestorBDException {
        if (psUpdateEquip_Temporada == null) {
            try {
                psUpdateEquip_Temporada = conn.prepareStatement("UPDATE equip_temporada WHERE equip_id=?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psUpdateEquip_Temporada", ex);
            }
        }
        try {
            psUpdateEquip_Temporada.setInt(1, et.getEquipId());
            psUpdateEquip_Temporada.setInt(1, et.getTemporadaAny());
            int eqtem = psUpdateEquip_Temporada.executeUpdate();
            if (eqtem == 0) {
                throw new GestorBDException("Equip_Temporada no modificat per no existir");
            }
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar modificar el equip_temporada " + et.getEquipId(), ex);
        }
    } 
    
     @Override
    public void editarEquip_Categoria(Equip_Categoria ec) throws GestorBDException {
        if (psUpdateEquip_Categoria == null) {
            try {
                psUpdateEquip_Categoria = conn.prepareStatement("UPDATE equip_categoria WHERE equip_id=?");
            } catch (SQLException ex) {
                throw new GestorBDException("Error en preparar sentència psUpdateEquip_Categoria", ex);
            }
        }
        try {
            psUpdateEquip_Categoria.setInt(1, ec.getEquipId());
            psUpdateEquip_Categoria.setInt(1, ec.getTemporadaAny());
            int eqtem = psUpdateEquip_Categoria.executeUpdate();
            if (eqtem == 0) {
                throw new GestorBDException("Equip_Categoria no modificat per no existir");
            }
        } catch (SQLException ex) {
            throw new GestorBDException("Error en intentar modificar el equip_categoria" + ec.getEquipId(), ex);
        }
    }
    
     @Override
    public void confirmarCanvis() throws GestorBDException {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en confirmar canvis", ex);
        }
    }

     @Override
    public void desferCanvis() throws GestorBDException {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            throw new GestorBDException("Error en desfer canvis", ex);
        }
    }

    @Override
    public List<Jugador> trobarJugador() throws GestorBDException {
    List<Jugador> llJugador = new ArrayList<>();

    String query = "SELECT * FROM jugador";
    try (PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            Jugador ju = new Jugador(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("cognoms"),
                rs.getString("sexe"),
                rs.getDate("data_naix"),
                rs.getString("IBAN"),
                rs.getString("IdLegal"),
                rs.getInt("any_fi_revisio_medica"),
                rs.getString("adreça")
            );
            llJugador.add(ju);
        }

    } catch (SQLException ex) {
        throw new GestorBDException("Error al recuperar la lista de jugadores.", ex);
    }

    // Validación final
    if (llJugador.isEmpty()) {
        System.out.println("No se encontraron jugadores en la base de datos.");
    } else {
        System.out.println("Jugadores recuperados: " + llJugador.size());
    }

    return llJugador;
}

    public List<Jugador> trobarJugadorPerCamp(String camp) throws GestorBDException {
    List<Jugador> llJugador = new ArrayList<>();

    String query = "SELECT * FROM jugador WHERE nom LIKE '%"+camp+"%' OR cognoms LIKE '%"+camp+"%' OR sexe LIKE '%"+camp+"%'"
            + "OR data_naix LIKE '%"+camp+"%' OR IBAN LIKE '%"+camp+"%' OR any_fi_revisio_medica LIKE '%"+camp+"%' OR adreça LIKE '%"+camp+"%'";
    
    try {
        
        PreparedStatement stmt = conn.prepareStatement(query);
        //stmt.setString(1, camp);
        ResultSet rs = stmt.executeQuery();
       
        while (rs.next()) {
            
            Jugador ju = new Jugador(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("cognoms"),
                rs.getString("sexe"),
                rs.getDate("data_naix"),
                rs.getString("IBAN"),
                rs.getString("IdLegal"),
                rs.getInt("any_fi_revisio_medica"),
                rs.getString("adreça")
            );
            llJugador.add(ju);
        }

    } catch (SQLException ex) {
        throw new GestorBDException("Error al recuperar la lista de jugadores.", ex);
    }

    // Validación final
    if (llJugador.isEmpty()) {
        System.out.println("No se encontraron jugadores en la base de datos.");
    } else {
        System.out.println("Jugadores recuperados: " + llJugador.size());
    }

    return llJugador;
}

    @Override
  public Usuari ferLogin(String login) throws GestorBDException {
    Usuari llUsuari = new Usuari(null, null, null);
    System.out.println("login: " + login);
    String query = "SELECT * FROM usuari WHERE login LIKE '" + login + "' ";

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                System.out.println("User encontrado");
                llUsuari = new Usuari(rs.getString("login"), rs.getString("password"), rs.getString("nom"));
            } else {
                throw new GestorBDException("Usuario no encontrado para el login: " + login);
            }

            return llUsuari;
        } catch (SQLException ex) {
            throw new GestorBDException("Error al recuperar el usuario.", ex);
        }
}


    @Override
    public List<Equip> trobarEquipPerCamp(String camp) throws GestorBDException {
        List<Equip> llEquip = new ArrayList<>();

    String query = "SELECT * FROM equip WHERE nom LIKE '%"+camp+"%' OR tipus LIKE '%"+camp+"%' ";
    
    try {
        
        PreparedStatement stmt = conn.prepareStatement(query);
        //stmt.setString(1, camp);
        ResultSet rs = stmt.executeQuery();
       
        while (rs.next()) {
            Equip eq = new Equip(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("tipus")
            );
            llEquip.add(eq);
        }

        } catch (SQLException ex) {
            throw new GestorBDException("Error al recuperar la lista de jugadores.", ex);
        }

        // Validación final
        if (llEquip.isEmpty()) {
            System.out.println("No se encontraron jugadores en la base de datos.");
        } else {
            System.out.println("Jugadores recuperados: " + llEquip.size());
        }

        return llEquip;
    }

    @Override
    public List<Temporada> trobarTemporadaperCamp(String camp) throws GestorBDException {
    
        List<Temporada> llTemporada = new ArrayList<>();

        String query = "SELECT * FROM temporada WHERE any_temporada LIKE '%"+camp+"%' ";

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            //stmt.setString(1, camp);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Temporada tem = new Temporada(
                        rs.getInt("id"),
                    rs.getInt("any_temporada")
                );
                llTemporada.add(tem);
            }

            } catch (SQLException ex) {
                throw new GestorBDException("Error al recuperar la lista de jugadores.", ex);
            }

            // Validación final
            if (llTemporada.isEmpty()) {
                System.out.println("No se encontraron temporadas en la base de datos.");
            } else {
                System.out.println("Temporadas recuperados: " + llTemporada.size());
            }

            return llTemporada;
    }
}
