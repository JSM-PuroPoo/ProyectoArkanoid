/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;

import componente.Bloque;
import componente.Pelota;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Juan Felipe
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    PanelJuego pj;

    public NewJFrame() {
        this.setUndecorated(true);
        initComponents();
        this.setTitle("ArkanoidGame");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setBounds(0, 0, 1200, 675);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        int numRows = 2;  // Número de filas de bloques
        int numCols = 22;  // Número de columnas de bloques
        int blockWidth = 30;
        int blockHeight = 24;
        int spacing = 8;  //8

        Bloque bloques[] = new Bloque[numRows * numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int index = row * numCols + col;

                int posX = 8 + (blockWidth + spacing) * col;
                int posY = 8 + (blockHeight + spacing) * row;

                if (col % 6 == 5) {
                    bloques[index] = new Bloque(true, posX, posY, blockWidth, blockHeight, 0, 0, pj);
                } else {
                    int vida = col % 4 + 1;  // Asignar valores de vida de 1 a 5
                    bloques[index] = new Bloque(vida, posX, posY, blockWidth, blockHeight, 0, 0, pj);
                }
            }
        }


        /*Bloque bloques[] = new Bloque[]{
            new Bloque(-1, 8 + 30 * 0, 8, 30, 24, 0, 0, pj),
            new Bloque(1, 8 + 30 * 1, 8, 30, 24, 0, 0, pj),
            new Bloque(2, 8 + 30 * 2, 8, 30, 24, 0, 0, pj),
            new Bloque(3, 8 + 30 * 3, 8, 30, 24, 0, 0, pj),
            new Bloque(4, 8 + 30 * 4, 8, 30, 24, 0, 0, pj),
            new Bloque(true, 8 + 30 * 5, 8, 30, 24, 0, 0, pj),
            new Bloque(-1, 8 + 30 * 6, 8, 30, 24, 0, 0, pj),
            new Bloque(1, 8 + 30 * 7, 8, 30, 24, 0, 0, pj),
            new Bloque(2, 8 + 30 * 8, 8, 30, 24, 0, 0, pj),
            new Bloque(3, 8 + 30 * 9, 8, 30, 24, 0, 0, pj),
            new Bloque(4, 8 + 30 * 10, 8, 30, 24, 0, 0, pj),
            new Bloque(true, 8 + 30 * 11, 8, 30, 24, 0, 0, pj),
            new Bloque(-1, 8 + 30 * 12, 8, 30, 24, 0, 0, pj),
            new Bloque(1, 8 + 30 * 13, 8, 30, 24, 0, 0, pj),
            new Bloque(2, 8 + 30 * 14, 8, 30, 24, 0, 0, pj),
            new Bloque(3, 8 + 30 * 15, 8, 30, 24, 0, 0, pj),
            new Bloque(4, 8 + 30 * 16, 8, 30, 24, 0, 0, pj),
            new Bloque(true, 8 + 30 * 17, 8, 30, 24, 0, 0, pj),
            new Bloque(-1, 8 + 30 * 18, 8, 30, 24, 0, 0, pj),
            new Bloque(1, 8 + 30 * 19, 8, 30, 24, 0, 0, pj),
            new Bloque(2, 8 + 30 * 20, 8, 30, 24, 0, 0, pj),
            new Bloque(3, 8 + 30 * 21, 8, 30, 24, 0, 0, pj),
            new Bloque(4, 8 + 30 * 22, 8, 30, 24, 0, 0, pj),
            new Bloque(true, 8 + 17 * 23, 8, 30, 24, 0, 0, pj)
        };*/
        pj = new PanelJuego(bloques, "recursos/fondo1.jpg", "recursos/fondopartidasolido.png", "recursos/marco0.png");
        pj.setSize(this.getSize());
        this.add(pj);
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        /*pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 1, 1, pj.getGame()));
        /*pj.agregarPelota(new Pelota(365, 525, 25, 25, 10, -10, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, -10, 10, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 11, 10, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 10, -11, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, -11, 10, pj.getGame()));
        
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 10, 12, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 10, -12, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, -10, 12, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 11, 12, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 10, -12, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, -11, 12, pj.getGame()));
*/
        pj.paintComponents(this.getGraphics());

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                switch (keyCode) {
                    case 39:
                        pj.getRaqueta().moverDerecha();
                        break;
                    case 37:
                        pj.getRaqueta().moverIzquierda();
                        break;
                    case 68:
                        pj.getRaqueta().moverDerecha();
                        break;
                    case 65:
                        pj.getRaqueta().moverIzquierda();
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
