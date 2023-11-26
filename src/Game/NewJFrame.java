/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;

import componentes.Bloque;
import componentes.Pelota;
import java.util.Random;

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
        int numRows = 10;  // Número de filas de bloques    10
        int numCols = 22;  // Número de columnas de bloques
        int blockWidth = 30;
        int blockHeight = 24;
        int spacing = 8;  //8
        Random random = new Random();
        Bloque bloques[] = new Bloque[numRows * numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int index = row * numCols + col;
                int posX = 8 + (blockWidth + spacing) * col;
                int posY = 8 + (blockHeight + spacing) * row;
                int numeroAleatorio = random.nextInt(5) + 1;
                if (numeroAleatorio == 5 && col % (row + 1) == 0) {
                    bloques[index] = new Bloque(true, posX, posY, blockWidth, blockHeight, 0, 0, pj);
                } else {
                    if (numeroAleatorio == 5) {
                        numeroAleatorio -= 2;
                    }
                    bloques[index] = new Bloque(numeroAleatorio, posX, posY, blockWidth, blockHeight, 0, 0, pj);
                }
            }
        }

        pj = new PanelJuego(bloques, "recursos/fondo1.jpg", "recursos/fondopartidasolido.png", "recursos/marco0.png", this);
        pj.setSize(this.getSize());
        pj.paintComponents(this.getGraphics());
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
        pj.agregarPelota(new Pelota(365, 525, 25, 25, 2, 2, pj.getGame()));
    }

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
