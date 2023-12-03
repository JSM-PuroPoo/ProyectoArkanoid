/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Cronometro;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.Timer;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class PanelCronometro extends javax.swing.JPanel {

    private CronometroP Cronometro;
    Font Digit;

    public PanelCronometro() {
        initComponents();
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("fonts/DSDIGIT.TTF"));;
            Digit = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.setSize(259, 58);
        crono.setFont(Digit.deriveFont(Font.PLAIN, 40));
        this.Cronometro = new CronometroP(crono);
        this.Cronometro.time = new Timer(10, Cronometro.accion);
        this.setOpaque(false);
        this.crono.setForeground(Color.WHITE);
    }

    public Font getFont(){
        return Digit;
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crono = new javax.swing.JLabel();

        crono.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        crono.setText("00:00:00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crono)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crono)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel crono;
    // End of variables declaration//GEN-END:variables

    public CronometroP getCronometro() {
        return Cronometro;
    }

    public void setCronometro(CronometroP Cronometro) {
        this.Cronometro = Cronometro;
    }
}
