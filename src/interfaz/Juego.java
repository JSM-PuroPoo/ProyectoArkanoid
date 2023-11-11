/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import animaciones.Movimiento;
import componente.Bloque;
import componente.PanelComponente;
import componente.Pelota;
import componente.Raqueta;
import interfaz.paneles.PanelIMG;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Juan Felipe
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    PanelIMG fondo = new PanelIMG();
    PanelIMG game = new PanelIMG();
    PanelIMG marco = new PanelIMG();

    public Juego() {
        this.setUndecorated(true);
        initComponents();
        this.setTitle("ArkanoidGame");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        fondo.setLayout(null); // Establecer un diseño nulo para el fondo Panel
        fondo.setBounds(0, 0, 1200, 675);
        fondo.setImage("recursos/fondo3.jpg");
        this.getContentPane().add(fondo);
        game.setOpaque(false);
        game.setBounds(30, 30, 856, 615);
        game.setImage("recursos/fondopartidasolido.png");
        marco.setBounds(0, 0, 1200, 675);
        marco.setOpaque(false);
        marco.setImage("recursos/marcojuego.png");
        fondo.add(marco);
        fondo.add(game);
        game.setLayout(null);
        marco.setLayout(null);
        game.setOpaque(false);
        Raqueta r = new Raqueta(game);
        r.actualizarEstado(2);
        game.add(r);

        Bloque bloque1 = new Bloque(-1, 8 + 30 * 0, 8, 30, 24, 0, 0, game);
        game.add(bloque1);

        Bloque bloque2 = new Bloque(1, 8 + 30 * 1, 8, 30, 24, 0, 0, game);
        game.add(bloque2);

        Bloque bloque3 = new Bloque(2, 8 + 30 * 2, 8, 30, 24, 0, 0, game);
        game.add(bloque3);

        Bloque bloque4 = new Bloque(3, 8 + 30 * 3, 8, 30, 24, 0, 0, game);
        game.add(bloque4);

        Bloque bloque5 = new Bloque(4, 8 + 30 * 4, 8, 30, 24, 0, 0, game);
        game.add(bloque5);

        Bloque bloque6 = new Bloque(true, 8 + 30 * 5, 8, 30, 24, 0, 0, game);
        game.add(bloque6);

        Pelota pelota = new Pelota(100, 400, 25, 25, 10, 10, game);
        game.add(pelota);
        pelota.setR(r);
        pelota.setSpeed(30);
        new Thread(pelota).start();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                switch (keyCode) {
                    case 39:
                        r.moverDerecha();
                        break;
                    case 37:
                        r.moverIzquierda();
                        break;
                    case 68:
                        r.moverDerecha();
                        break;
                    case 65:
                        r.moverIzquierda();
                        break;
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
