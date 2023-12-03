package interfaz;

import Game.PanelJuego;
import componentes.Bloque;
import configuraciones.Configuraciones;
import java.util.Random;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    PanelJuego pj;
    Configuraciones configuraciones;

    public Juego(Configuraciones configuraciones) {
        this();
        this.configuraciones = configuraciones;
        pj.actualizar(configuraciones);

    }

    public Juego() {
        this.setUndecorated(true);
        initComponents();
        int numRows = 5;
        int numCols = 12; //22
        int blockWidth = 62; //30
        int blockHeight = 24; //24
        int spacing = 8;  //8
        Random random = new Random();
        Bloque bloques[] = new Bloque[numRows * numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int index = row * numCols + col;
                int posX = 12 + (blockWidth + spacing) * col;
                int posY = 10 + (blockHeight + spacing) * row;
                int numeroAleatorio = random.nextInt(5) + 1;
                if (numeroAleatorio == 5 && col % (row + 1) == 0) {
                    bloques[index] = new Bloque(true, posX, posY, blockWidth, blockHeight, 0, 0, pj);
                } else {
                    if (numeroAleatorio == 5) {
                        numeroAleatorio -= random.nextInt(3) + 1;
                    }
                    bloques[index] = new Bloque(numeroAleatorio, posX, posY, blockWidth, blockHeight, 0, 0, pj);
                }
            }
        }

        pj = new PanelJuego(bloques, "recursos/fondo3.jpg", "recursos/fondopartidasolido.png", "recursos/marco0.png", this);
        pj.setSize(this.getSize());
        pj.paintComponents(this.getGraphics());
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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    public Configuraciones getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(Configuraciones configuraciones) {
        this.configuraciones = configuraciones;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
