/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cronometro;

import javax.swing.Timer;
import java.io.*;
import java.awt.*;

/**
 *
 * @author nalis
 */
public class Crono extends javax.swing.JFrame {

    CronometroP Cronometro;
    Font Digit;

    /**
     * Creates new form Crono
     */
    public Crono() {
        initComponents();
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("fonts/DSDIGIT.TTF"));;
            // load a custom font in your project folder
            Digit = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.setSize(280, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        crono.setFont(Digit.deriveFont(Font.PLAIN, 24));
        SavedCrono.setFont(Digit.deriveFont(Font.PLAIN, 24));
        this.Cronometro = new CronometroP(crono);
        this.Cronometro.time = new Timer(10, Cronometro.accion);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crono = new javax.swing.JLabel();
        Start = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        SavedCrono = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Resume = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(280, 300));

        crono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        crono.setText("00:00:00:00");

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Stop.setText("Stop");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });

        SavedCrono.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SavedCrono.setText("00:00:00:00");

        jLabel2.setText("Saved timer:");

        Resume.setText("Resume");
        Resume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Resume)
                        .addGap(12, 12, 12)
                        .addComponent(Stop)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SavedCrono)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(crono, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(crono, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start)
                    .addComponent(Stop)
                    .addComponent(Resume))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(SavedCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
        this.Cronometro.time.start();
        this.Start.setEnabled(false);
    }//GEN-LAST:event_StartActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        // TODO add your handling code here:
        if (!this.Cronometro.pause) {
            this.Cronometro.time.stop();
            this.Cronometro = new CronometroP(Cronometro.hour, Cronometro.min, Cronometro.seg, Cronometro.miliseg, SavedCrono);
            this.Cronometro.TimeTags();
            this.Cronometro.pause = true;

        }
    }//GEN-LAST:event_StopActionPerformed

    private void ResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumeActionPerformed
        // TODO add your handling code here:
        if (this.Cronometro.pause) {
            this.Cronometro = new CronometroP(Cronometro.hour, Cronometro.min, Cronometro.seg, Cronometro.miliseg, crono);
            this.Cronometro.time = new Timer(10, Cronometro.accion);
            this.Cronometro.time.start();
            this.Cronometro.pause = false;
        }
    }//GEN-LAST:event_ResumeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Resume;
    private javax.swing.JLabel SavedCrono;
    private javax.swing.JButton Start;
    private javax.swing.JButton Stop;
    private javax.swing.JLabel crono;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
