/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import interfaz.paneles.*;
import configuraciones.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author nalis
 */
public class Settings extends javax.swing.JFrame implements Observer {

    private Configuraciones configuraciones = new Configuraciones();
    private Configuraciones configuracionesCopy;
    PanelIMG settingsPanel = new PanelIMG();
    PanelIMG settingsMarco = new PanelIMG();
    PanelIMG subPanels = new PanelIMG();
    JButton acceptButton = new JButton();
    JButton cancelButton = new JButton();
    JButton easyButton = new JButton();
    JButton normalButton = new JButton();
    JButton hardButton = new JButton();
    JButton minusButton = new JButton();
    JButton plusButton = new JButton();
    JButton soundButton = new JButton();
    JButton musicButton = new JButton();
    JLabel ballCountL = new JLabel();
    PanelIMG ballCountPanel = new PanelIMG();

    private JButton closeButton = new JButton();
    private JButton minimizeButton = new JButton();

    private boolean juego;
    private boolean alerta;

    Font text;

    /**
     * Creates new form Settings
     */
    public Settings() {
        this.setUndecorated(true);
        initComponents();
        alerta = false;
        juego = true;
        configuraciones.setSonido(true);
        configuraciones.setMusica(true);
        configuraciones.setCantidadPelotas(1);
        configuraciones.setDificultad(2);
        configuracionesCopy = configuraciones.copiar();

        this.setTitle("Ocaso Arkanoid");
        this.setSize(1200, 675);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon("recursos/logo.png").getImage());
        settingsMarco.setBounds(0, 0, 1200, 675);
        settingsMarco.setOpaque(false);
        settingsMarco.setImage("recursos/marco0.png");
        settingsMarco.setLayout(null);
        this.getContentPane().add(settingsMarco);
        settingsPanel.setImage("recursos/settingsBackPanel.png");
        settingsPanel.setBounds(30, 30, 1140, 615);
        settingsPanel.setLayout(null);
        settingsPanel.setOpaque(false);
        this.getContentPane().add(settingsPanel);

        acceptButton.setIcon(new ImageIcon("recursos/acceptButton.png"));
        acceptButton.setRolloverIcon(new ImageIcon("recursos/acceptButtonPressed.png"));
        acceptButton.setBounds(600, 520, 220, 94);
        acceptButton.setBorderPainted(false);
        acceptButton.setContentAreaFilled(false);
        acceptButton.setOpaque(false);
        acceptButton.setLayout(null);
        settingsPanel.add(acceptButton);

        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new ImageIcon("recursos/cancelButton.png"));
        cancelButton.setRolloverIcon(new ImageIcon("recursos/cancelButtonPressed.png"));
        cancelButton.setBounds(320, 522, 218, 94);
        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setOpaque(false);
        cancelButton.setLayout(null);
        settingsPanel.add(cancelButton);

        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        subPanels.setImage("recursos/settingsSubPanels.png");
        subPanels.setBounds(80, 110, 970, 403);
        subPanels.setLayout(null);
        subPanels.setOpaque(false);
        settingsPanel.add(subPanels);

        easyButton.setIcon(new ImageIcon("recursos/easyNormalButton.png"));
        easyButton.setRolloverIcon(new ImageIcon("recursos/easyButtonPressed.png"));
        easyButton.setBounds(350, 3, 117, 117);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setOpaque(false);
        easyButton.setLayout(null);
        subPanels.add(easyButton);

        easyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyButtonActionPerformed(evt);
            }
        });

        normalButton.setIcon(new ImageIcon("recursos/normalNormalButton.png"));
        normalButton.setRolloverIcon(new ImageIcon("recursos/normalButtonPressed.png"));
        normalButton.setBounds(550, 3, 117, 117);
        normalButton.setBorderPainted(false);
        normalButton.setContentAreaFilled(false);
        normalButton.setOpaque(false);
        normalButton.setLayout(null);
        subPanels.add(normalButton);

        normalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalButtonActionPerformed(evt);
            }
        });

        hardButton.setIcon(new ImageIcon("recursos/hardNormalButton.png"));
        hardButton.setRolloverIcon(new ImageIcon("recursos/hardButtonPressed.png"));
        hardButton.setBounds(750, 3, 117, 117);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setOpaque(false);
        hardButton.setLayout(null);
        subPanels.add(hardButton);

        hardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardButtonActionPerformed(evt);
            }
        });

        soundButton.setIcon(new ImageIcon("recursos/speakerButton.png"));
        soundButton.setRolloverIcon(new ImageIcon("recursos/speakerButtonPressed.png"));
        soundButton.setBounds(320, 284, 96, 96);
        soundButton.setBorderPainted(false);
        soundButton.setContentAreaFilled(false);
        soundButton.setOpaque(false);
        soundButton.setLayout(null);
        subPanels.add(soundButton);

        soundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundButtonActionPerformed(evt);
            }
        });

        musicButton.setIcon(new ImageIcon("recursos/speakerButton.png"));
        musicButton.setRolloverIcon(new ImageIcon("recursos/speakerButtonPressed.png"));
        musicButton.setBounds(760, 284, 96, 96);
        musicButton.setBorderPainted(false);
        musicButton.setContentAreaFilled(false);
        musicButton.setOpaque(false);
        musicButton.setLayout(null);
        subPanels.add(musicButton);

        musicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicButtonActionPerformed(evt);
            }
        });

        minusButton.setIcon(new ImageIcon("recursos/minusButton.png"));
        minusButton.setRolloverIcon(new ImageIcon("recursos/minusButtonPressed.png"));
        minusButton.setBounds(330, 160, 64, 64);
        minusButton.setBorderPainted(false);
        minusButton.setContentAreaFilled(false);
        minusButton.setOpaque(false);
        minusButton.setLayout(null);
        subPanels.add(minusButton);

        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });

        plusButton.setIcon(new ImageIcon("recursos/plusButton.png"));
        plusButton.setRolloverIcon(new ImageIcon("recursos/plusButtonPressed.png"));
        plusButton.setBounds(780, 160, 64, 64);
        plusButton.setBorderPainted(false);
        plusButton.setContentAreaFilled(false);
        plusButton.setOpaque(false);
        plusButton.setLayout(null);
        subPanels.add(plusButton);

        plusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusButtonActionPerformed(evt);
            }
        });

        ballCountPanel.setImage("recursos/BallCountLabel.png");
        ballCountPanel.setBounds(495, 153, 170, 80);
        ballCountPanel.setLayout(null);
        ballCountPanel.setOpaque(false);
        subPanels.add(ballCountPanel);

        try {
            InputStream is = new BufferedInputStream(new FileInputStream("fonts/Retronoid.TTF"));;
            text = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        ballCountL.setBounds(0, 0, 170, 80);
        ballCountL.setFont(text.deriveFont(Font.PLAIN, 55));
        ballCountL.setHorizontalAlignment(SwingConstants.CENTER);
        ballCountL.setVerticalAlignment(SwingConstants.CENTER);
        ballCountL.setForeground(Color.white);
        ballCountL.setLayout(null);
        ballCountL.setOpaque(false);
        ballCountL.setText("" + configuraciones.getCantidadPelotas());
        ballCountPanel.add(ballCountL);

        closeButton.setIcon(new ImageIcon("recursos/closeButton.png"));
        closeButton.setRolloverIcon(new ImageIcon("recursos/closeButtonRed.png"));
        closeButton.setBounds(1173, 3, 24, 24);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setOpaque(false);
        closeButton.setLayout(null);
        settingsMarco.add(closeButton);
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
        settingsMarco.add(minimizeButton);
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });

        switch (configuraciones.getDificultad()) {
            case 1:
                easyButton.setIcon(new ImageIcon("recursos/easyButtonPressed.png"));
                break;
            case 2:
                normalButton.setIcon(new ImageIcon("recursos/normalButtonPressed.png"));
                break;
            case 3:
                hardButton.setIcon(new ImageIcon("recursos/hardButtonPressed.png"));
                break;
        }
    }

    private void closeButtonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void minimizeButtonActionPerformed(ActionEvent evt) {
        this.setExtendedState(1);
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        reiniciarFrame();
        configuraciones = configuracionesCopy.copiar();
    }

    private void acceptButtonActionPerformed(ActionEvent evt) {
        if (alerta) {
            Warning warning = new Warning();
            warning.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    if (warning.choice) {
                        reiniciarFrame();
                        configuracionesCopy = configuraciones.copiar();
                    }
                }
            });
            warning.setVisible(true);
        } else {
            reiniciarFrame();
            configuracionesCopy = configuraciones.copiar();
        }
    }

    private void easyButtonActionPerformed(ActionEvent evt) {
        easyButton.setIcon(new ImageIcon("recursos/easyButtonPressed.png"));
        normalButton.setIcon(new ImageIcon("recursos/normalNormalButton.png"));
        hardButton.setIcon(new ImageIcon("recursos/hardNormalButton.png"));
        alerta = true;
        configuraciones.setDificultad(1);
    }

    private void normalButtonActionPerformed(ActionEvent evt) {
        easyButton.setIcon(new ImageIcon("recursos/easyNormalButton.png"));
        normalButton.setIcon(new ImageIcon("recursos/normalButtonPressed.png"));
        hardButton.setIcon(new ImageIcon("recursos/hardNormalButton.png"));
        alerta = true;
        configuraciones.setDificultad(2);
    }

    private void hardButtonActionPerformed(ActionEvent evt) {
        easyButton.setIcon(new ImageIcon("recursos/easyNormalButton.png"));
        normalButton.setIcon(new ImageIcon("recursos/normalNormalButton.png"));
        hardButton.setIcon(new ImageIcon("recursos/hardButtonPressed.png"));
        alerta = true;
        configuraciones.setDificultad(3);
    }

    private void soundButtonActionPerformed(ActionEvent evt) {
        if (configuraciones.isSonido()) {
            soundButton.setIcon(new ImageIcon("recursos/noSpeakerButton.png"));
            soundButton.setRolloverIcon(new ImageIcon("recursos/noSpeakerButtonPressed.png"));
            configuraciones.setSonido(false);
        } else {
            soundButton.setIcon(new ImageIcon("recursos/speakerButton.png"));
            soundButton.setRolloverIcon(new ImageIcon("recursos/speakerButtonPressed.png"));
            configuraciones.setSonido(true);
        }
    }

    private void musicButtonActionPerformed(ActionEvent evt) {
        if (configuraciones.isMusica()) {
            musicButton.setIcon(new ImageIcon("recursos/noSpeakerButton.png"));
            musicButton.setRolloverIcon(new ImageIcon("recursos/noSpeakerButtonPressed.png"));
            configuraciones.setMusica(false);
        } else {
            musicButton.setIcon(new ImageIcon("recursos/speakerButton.png"));
            musicButton.setRolloverIcon(new ImageIcon("recursos/speakerButtonPressed.png"));
            configuraciones.setMusica(true);
        }
    }

    private void minusButtonActionPerformed(ActionEvent evt) {
        configuraciones.setCantidadPelotas(configuraciones.getCantidadPelotas() - 1);
        if (configuraciones.getCantidadPelotas() < 1) {
            configuraciones.setCantidadPelotas(3);
        }
        alerta = true;
        ballCountL.setText("" + configuraciones.getCantidadPelotas());
    }

    private void plusButtonActionPerformed(ActionEvent evt) {
        configuraciones.setCantidadPelotas(configuraciones.getCantidadPelotas() + 1);
        if (configuraciones.getCantidadPelotas() > 3) {
            configuraciones.setCantidadPelotas(1);
        }
        alerta = true;
        ballCountL.setText("" + configuraciones.getCantidadPelotas());
    }

    public void setJuego(boolean juego) {
        this.juego = juego;
    }

    /*
    String ruta = "recursos/slidehowtoplay";
       indice++; 
       if (indice > MAX_INDICE) {
           indice = 1;
       }
       ruta += indice + ".png";
       slidehowtoplay.setImage(ruta);
     */
    public void reiniciarFrame() {
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Settings();
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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    @Override
    public void actualizar(Configuraciones configuraciones) {

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
