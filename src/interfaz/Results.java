package interfaz;

import interfaz.paneles.PanelIMG;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class Results extends javax.swing.JFrame {

    private PanelIMG baseResults = new PanelIMG();
    public PanelIMG youWon = new PanelIMG();
    public PanelIMG youLost = new PanelIMG();
    public JLabel scoreShow = new JLabel();
    public JLabel timeShow = new JLabel();
    private JButton replayButton = new JButton();
    private JButton homeButton = new JButton();
    private JButton exitButton = new JButton();
    public int decision;

    Font text;

    /**
     * Creates new form YouWon
     */
    public Results() {
        this.setUndecorated(true);
        initComponents();
        setIconImage(new ImageIcon("recursos/logo.png").getImage());
        this.setTitle("Ocaso Arkanoid");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        baseResults.setImage("recursos/baseResult.png");
        baseResults.scaleImage(650, 400);
        baseResults.setBounds(0, 0, 650, 400);
        baseResults.setOpaque(false);
        baseResults.setLayout(null);
        this.getContentPane().add(baseResults);

        youLost.setImage("recursos/youLost.png");
        youLost.setBounds(190, 0, 280, 74);
        youLost.setOpaque(false);
        youLost.setLayout(null);
        baseResults.add(youLost);
        youLost.setVisible(false);

        youWon.setImage("recursos/youWon.png");
        youWon.setBounds(190, 0, 280, 74);
        youWon.setOpaque(false);
        youWon.setLayout(null);
        baseResults.add(youWon);
        youWon.setVisible(false);

        try {
            InputStream is = new BufferedInputStream(new FileInputStream("fonts/DSDIGI.TTF"));;
            text = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        //scoreShow.setIcon(new ImageIcon("recursos/paneloscuro.png"));
        scoreShow.setBounds(40, 152, 283, 73);
        scoreShow.setFont(text.deriveFont(Font.PLAIN, 55));
        scoreShow.setForeground(Color.white);
        scoreShow.setHorizontalAlignment(SwingConstants.CENTER);
        scoreShow.setVerticalAlignment(SwingConstants.CENTER);
        scoreShow.setOpaque(false);
        scoreShow.setLayout(null);
        baseResults.add(scoreShow);

        //timeShow.setIcon(new ImageIcon("recursos/paneloscuro.png"));
        timeShow.setBounds(40, 273, 283, 73);
        timeShow.setFont(text.deriveFont(Font.PLAIN, 55));
        timeShow.setForeground(Color.white);
        timeShow.setHorizontalAlignment(SwingConstants.CENTER);
        timeShow.setVerticalAlignment(SwingConstants.CENTER);
        timeShow.setOpaque(false);
        timeShow.setLayout(null);
        baseResults.add(timeShow);

        replayButton.setIcon(new ImageIcon("recursos/replayButton.png"));
        replayButton.setRolloverIcon(new ImageIcon("recursos/replayButtonPressed.png"));
        replayButton.setBounds(410, 95, 190, 84);
        replayButton.setBorderPainted(false);
        replayButton.setContentAreaFilled(false);
        replayButton.setOpaque(false);
        replayButton.setLayout(null);
        baseResults.add(replayButton);

        replayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replayButtonActionPerformed(evt);
            }
        });

        homeButton.setIcon(new ImageIcon("recursos/homeWonButton.png"));
        homeButton.setRolloverIcon(new ImageIcon("recursos/homeWonButtonPressed.png"));
        homeButton.setBounds(425, 190, 153, 84);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setOpaque(false);
        homeButton.setLayout(null);
        baseResults.add(homeButton);

        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        exitButton.setIcon(new ImageIcon("recursos/exitWonButton.png"));
        exitButton.setRolloverIcon(new ImageIcon("recursos/exitWonButtonPressed.png"));
        exitButton.setBounds(435, 290, 134, 84);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setOpaque(false);
        exitButton.setLayout(null);
        baseResults.add(exitButton);

        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

    }

    private void replayButtonActionPerformed(ActionEvent evt) {
        decision = 0;
        this.dispose();
    }

    private void homeButtonActionPerformed(ActionEvent evt) {
        decision = 1;
        this.dispose();
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        decision = 2;
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 400));

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
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Results().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
