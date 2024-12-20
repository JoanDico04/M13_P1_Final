/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package p1.t7.vista.diazcomesjoan;

import java.util.logging.Level;
import java.util.logging.Logger;
import p1.t6.interficiepersistencia.diazcomesjoan.GestorBDException;
import static p1.t7.vista.diazcomesjoan.Main.gbd;
import p1t6modeldiazcomesjoan.Temporada;

/**
 *
 * @author micro
 */
public class EditarTemporada extends javax.swing.JFrame {

    Temporada temporada = null;
    /**
     * Creates new form EditarTemporada
     * @param temporada
     */
    public EditarTemporada(Temporada temporada) {
        initComponents();
        
        this.temporada = temporada;
        
        nomField.setText(temporada.getTemporada()+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardarBoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tornarBoto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nomField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        guardarBoto.setText("Guardar");
        guardarBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBotoActionPerformed(evt);
            }
        });

        jLabel1.setText("Editar Temporada");

        tornarBoto.setText("Tornar");
        tornarBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornarBotoActionPerformed(evt);
            }
        });

        jLabel3.setText("Any");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(nomField, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)))
                .addGap(242, 242, 242))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(guardarBoto)
                .addGap(68, 68, 68)
                .addComponent(tornarBoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(nomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBoto)
                    .addComponent(tornarBoto))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBotoActionPerformed

        // TODO add your handling code here:
        Temporada gtem = new Temporada(
            temporada.getTemporadaId(),
           Integer.parseInt(nomField.getText())
        );
        System.out.println("Temporada guardat"+gtem);
        try {
            gbd.editarTemporada(gtem);
            gbd.confirmarCanvis();
        } catch (GestorBDException ex) {
            Logger.getLogger(EditarTemporada.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestioTemporada gt;
        try {
            gt = new GestioTemporada();
            gt.setVisible(true);
        } catch (GestorBDException ex) {
            Logger.getLogger(EditarTemporada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_guardarBotoActionPerformed

    private void tornarBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornarBotoActionPerformed

        // TODO add your handling code here:
        dispose();
        try {
            GestioTemporada gt = new GestioTemporada();
            gt.setVisible(true);
        } catch (GestorBDException ex) {
            java.util.logging.Logger.getLogger(EditarEquip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tornarBotoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarBoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomField;
    private javax.swing.JButton tornarBoto;
    // End of variables declaration//GEN-END:variables
}