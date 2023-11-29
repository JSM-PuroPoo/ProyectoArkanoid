/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import Sonido.Sonido;
import configuraciones.Configuraciones;
import configuraciones.Observer;
import interfaz.paneles.PanelIMG;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Juan Felipe
 */
public class Inicio extends javax.swing.JFrame implements Observer {

    private PanelIMG inicioFondo = new PanelIMG();
    private PanelIMG inicioMarco = new PanelIMG();
    private PanelIMG howtoplay = new PanelIMG();
    private PanelIMG tableInicio = new PanelIMG();
    private JButton playButton = new JButton();
    private JButton chartsButton = new JButton();
    private JButton settingsButton = new JButton();
    private JButton creditsButton = new JButton();
    private JButton exitButton = new JButton();
    private JButton leftarrowButton = new JButton();
    private JButton rightarrowButton = new JButton();
    private JButton closeButton = new JButton();
    private JButton minimizeButton = new JButton();
    private PanelIMG slidehowtoplay = new PanelIMG();

    private Configuraciones configuraciones;
    private Sonido musica;
    private Sonido efecto;
    int indice = 1;
    public static final int MAX_INDICE = 3;

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        setUndecorated(true);
        initComponents();
        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

            }
        };
        this.setTitle("Ocaso Arkanoid");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon("recursos/logo.png").getImage());
        inicioFondo.setLayout(null);
        inicioFondo.setImage("recursos/inicioimg.jpg");
        inicioFondo.setBounds(0, 0, 1200, 675);
        this.getContentPane().add(inicioFondo);
        inicioMarco.setBounds(0, 0, 1200, 675);
        inicioMarco.setOpaque(false);
        inicioMarco.setImage("recursos/marco0.png");
        inicioMarco.setLayout(null);
        inicioFondo.add(inicioMarco);
        howtoplay.setLayout(null);
        howtoplay.setImage("recursos/basehowtoplay.png");
        howtoplay.setBounds(470, 100, 650, 475);
        howtoplay.setOpaque(false);
        inicioFondo.add(howtoplay);
        slidehowtoplay.setLayout(null);
        slidehowtoplay.setImage("recursos/slidehowtoplay1.png");
        slidehowtoplay.setBounds(125, 100, 400, 280);
        slidehowtoplay.setOpaque(false);
        howtoplay.add(slidehowtoplay);
        tableInicio.setLayout(null);
        tableInicio.setImage("recursos/tableinicio.png");
        tableInicio.setBounds(30, 30, 388, 615);
        tableInicio.setOpaque(false);
        inicioFondo.add(tableInicio);

        playButton.setIcon(new ImageIcon("recursos/PlayButton.png"));
        playButton.setRolloverIcon(new ImageIcon("recursos/PlayButtonPressed.png"));
        playButton.setBounds(111, 220, 165, 97);
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setOpaque(false);
        playButton.setLayout(null);
        tableInicio.add(playButton);

        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonnActionPerformed(evt);
            }
        });

        playButton.addMouseListener(mouse);

        chartsButton.setIcon(new ImageIcon("recursos/ChartsButton.png"));
        chartsButton.setRolloverIcon(new ImageIcon("recursos/ChartsButtonPressed.png"));
        chartsButton.setBounds(110, 300, 165, 68);
        chartsButton.setBorderPainted(false);
        chartsButton.setContentAreaFilled(false);
        chartsButton.setOpaque(false);
        chartsButton.setLayout(null);
        tableInicio.add(chartsButton);

        chartsButton.addMouseListener(mouse);

        settingsButton.setIcon(new ImageIcon("recursos/SettingsButton.png"));
        settingsButton.setRolloverIcon(new ImageIcon("recursos/SettingsButtonPressed.png"));
        settingsButton.setBounds(105, 380, 177, 65);
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setOpaque(false);
        settingsButton.setLayout(null);
        tableInicio.add(settingsButton);

        settingsButton.addMouseListener(mouse);

        creditsButton.setIcon(new ImageIcon("recursos/CreditsButton.png"));
        creditsButton.setRolloverIcon(new ImageIcon("recursos/CreditsButtonPressed.png"));
        creditsButton.setBounds(112, 460, 165, 67);
        creditsButton.setBorderPainted(false);
        creditsButton.setContentAreaFilled(false);
        creditsButton.setOpaque(false);
        creditsButton.setLayout(null);
        tableInicio.add(creditsButton);

        creditsButton.addMouseListener(mouse);

        exitButton.setIcon(new ImageIcon("recursos/ExitButton.png"));
        exitButton.setRolloverIcon(new ImageIcon("recursos/ExitButtonPressed.png"));
        exitButton.setBounds(135, 540, 110, 69);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setOpaque(false);
        exitButton.setLayout(null);
        tableInicio.add(exitButton);

        exitButton.addMouseListener(mouse);

        leftarrowButton.setIcon(new ImageIcon("recursos/leftarrowButton.png"));
        leftarrowButton.setRolloverIcon(new ImageIcon("recursos/leftarrowButtonPressed.png"));
        leftarrowButton.setBounds(180, 400, 50, 56);
        leftarrowButton.setBorderPainted(false);
        leftarrowButton.setContentAreaFilled(false);
        leftarrowButton.setOpaque(false);
        leftarrowButton.setLayout(null);
        howtoplay.add(leftarrowButton);

        leftarrowButton.addMouseListener(mouse);

        rightarrowButton.setIcon(new ImageIcon("recursos/rightarrowButton.png"));
        rightarrowButton.setRolloverIcon(new ImageIcon("recursos/rightarrowButtonPressed.png"));
        rightarrowButton.setBounds(420, 400, 50, 56);
        rightarrowButton.setBorderPainted(false);
        rightarrowButton.setContentAreaFilled(false);
        rightarrowButton.setOpaque(false);
        rightarrowButton.setLayout(null);
        howtoplay.add(rightarrowButton);

        rightarrowButton.addMouseListener(mouse);

        rightarrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightarrowButtonActionPerformed(evt);
            }
        });

        leftarrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftarrowButtonActionPerformed(evt);
            }
        });

        closeButton.setIcon(new ImageIcon("recursos/closeButton.png"));
        closeButton.setRolloverIcon(new ImageIcon("recursos/closeButtonRed.png"));
        closeButton.setBounds(1173, 3, 24, 24);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setOpaque(false);
        closeButton.setLayout(null);
        inicioMarco.add(closeButton);

        closeButton.addMouseListener(mouse);

        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        minimizeButton.setIcon(new ImageIcon("recursos/MinimizeButton.png"));
        minimizeButton.setRolloverIcon(new ImageIcon("recursos/MinimizeButtonGray.png"));
        minimizeButton.setBounds(1135, 3, 24, 24);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setOpaque(false);
        minimizeButton.setLayout(null);
        inicioMarco.add(minimizeButton);
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });

        minimizeButton.addMouseListener(mouse);
    }

    private void rightarrowButtonActionPerformed(ActionEvent evt) {
        String ruta = "recursos/slidehowtoplay";
        indice++;
        if (indice > MAX_INDICE) {
            indice = 1;
        }
        ruta += indice + ".png";
        slidehowtoplay.setImage(ruta);
    }

    private void leftarrowButtonActionPerformed(ActionEvent evt) {
        String ruta = "recursos/slidehowtoplay";
        if (indice == 1) {
            indice = MAX_INDICE;
        } else {
            indice--;
        }
        ruta += indice + ".png";
        slidehowtoplay.setImage(ruta);
    }

    private void closeButtonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void minimizeButtonActionPerformed(ActionEvent evt) {
        this.setExtendedState(1);
    }

    private void playButtonnActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Juego juego = new Juego();
        juego.setVisible(true);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    @Override
    public void actualizar(Configuraciones configuraciones) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
