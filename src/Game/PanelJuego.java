package Game;

import Cronometro.PanelCronometro;
import componentes.Bloque;
import componentes.PanelComponente;
import componentes.Pelota;
import componentes.Raqueta;
import interfaz.paneles.PanelIMG;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.*;

public class PanelJuego extends PanelIMG {

    private Bloque bloques[];
    private Pelota pelotas[];
    private Raqueta raqueta;
    private PanelIMG game;
    private PanelIMG marco;
    public int contPelotas;
    public int contBloques;
    public String rutaFondo;
    public String rutaFJuego;
    public String rutaMarco;
    public JFrame frame;
    private JLabel puntos = new JLabel();

    private PanelIMG fondoOpaco = new PanelIMG();
    private PanelIMG panelPausa = new PanelIMG();
    private JButton pausa = new JButton();
    private JButton resumeButton = new JButton();
    private JButton homeButton = new JButton();
    private JButton settingsButton = new JButton();
    private JButton exitButton = new JButton();
    private PanelIMG pointPanel = new PanelIMG();
    private boolean pausado;
    PanelCronometro cronometro = new PanelCronometro();

    public static final int NORMAL = 8;
    public static final int SLOW = 10;
    public static final int FAST = 6;

    public PanelJuego(Bloque bloques[], String rutaFondo, String rutaFJuego, String rutaMarco, JFrame frame) {
        this.bloques = bloques;
        this.frame = frame;
        pelotas = new Pelota[50];
        Arrays.sort(bloques, Comparator.comparingInt(Bloque::getX));
        contPelotas = 0;
        contBloques = bloques.length;
        this.rutaFondo = rutaFondo;
        this.rutaFJuego = rutaFJuego;
        this.rutaMarco = rutaMarco;
        this.setImage(rutaFondo);
        game = new PanelIMG(rutaFJuego);
        this.setLayout(null);
        marco = new PanelIMG(rutaMarco);
        this.setOpaque(false);
        marco.setBounds(0, 0, 1200, 675);
        marco.setOpaque(false);
        marco.setLayout(null);
        this.setBounds(0, 0, 1200, 675);
        this.add(marco);
        this.add(game);
        game.setOpaque(false);
        game.setBounds(30, 30, 856, 615);
        game.setLayout(null);
        game.setOpaque(false);
        raqueta = new Raqueta(game);
        game.add(raqueta);
        raqueta.actualizarEstado(2);

        pausado = false;

        this.add(cronometro);
        cronometro.getCronometro().time.start();
        cronometro.setLocation(931, 100);

        this.frame.setTitle("ArkanoidGame");
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setBounds(0, 0, 1200, 675);
        this.frame.setLocationRelativeTo(null);
        this.frame.setLayout(null);
        this.frame.add(this);

        pausa.setBounds(974, 200, 120, 120);
        pausa.setIcon(new ImageIcon("recursos/PauseButtonPressed.png"));
        pausa.setRolloverIcon(new ImageIcon("recursos/PauseButtonRollover.png"));
        pausa.setBorderPainted(false);
        pausa.setContentAreaFilled(false);
        pausa.setOpaque(false);
        pausa.setLayout(null);
        this.add(pausa);
        pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausaActionPerformed(evt);
            }
        });
        pointPanel.setImage("recursos/pointsLabel.png");
        pointPanel.setOpaque(false);
        pointPanel.setBounds(944, 370, 175, 63);
        pointPanel.setLayout(null);
        this.add(pointPanel);
        fondoOpaco.setImage("recursos/paneloscuro.png");
        fondoOpaco.setOpaque(false);
        fondoOpaco.setBounds(30, 30, 1140, 615);
        fondoOpaco.setLayout(null);
        fondoOpaco.setVisible(false);
        this.add(fondoOpaco);
        this.setComponentZOrder(fondoOpaco, 0);

        panelPausa.setImage("recursos/panelPausa.png");
        panelPausa.setBounds(370, 82, 400, 448);
        panelPausa.setOpaque(false);
        panelPausa.setLayout(null);
        fondoOpaco.add(panelPausa);
        
        resumeButton.setIcon(new ImageIcon("recursos/ResumeButton.png"));
        resumeButton.setRolloverIcon(new ImageIcon("recursos/ResumeButtonPressed.png"));
        resumeButton.setBounds(75, 50, 250, 105);
        resumeButton.setBorderPainted(false);
        resumeButton.setContentAreaFilled(false);
        resumeButton.setOpaque(false);
        resumeButton.setLayout(null);
        panelPausa.add(resumeButton);
        
        homeButton.setIcon(new ImageIcon("recursos/HomeButton.png"));
        homeButton.setRolloverIcon(new ImageIcon("recursos/HomeButtonPressed.png"));
        homeButton.setBounds(105, 130, 191, 105);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setOpaque(false);
        homeButton.setLayout(null);
        panelPausa.add(homeButton);
        
        settingsButton.setIcon(new ImageIcon("recursos/SettingspausePanelButton.png"));
        settingsButton.setRolloverIcon(new ImageIcon("recursos/settingspausePanelButtonPressed.png"));
        settingsButton.setBounds(60, 215, 286, 105);
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setOpaque(false);
        settingsButton.setLayout(null);
        panelPausa.add(settingsButton);
        
        
        exitButton.setIcon(new ImageIcon("recursos/ExitpausePanelButton.png"));
        exitButton.setRolloverIcon(new ImageIcon("recursos/ExitpausePanelButtonPressed.png"));
        exitButton.setBounds(115, 300, 168, 105);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setOpaque(false);
        exitButton.setLayout(null);
        panelPausa.add(exitButton);


        puntos.setBounds(925, 430, 350, 126);
        puntos.setText("00000");
        puntos.setFont(cronometro.getFont().deriveFont(Font.PLAIN, 80));
        puntos.setForeground(Color.white);
        this.add(puntos);

        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case 39:
                        raqueta.moverDerecha();
                        break;
                    case 37:
                        raqueta.moverIzquierda();
                        break;
                    case 68:
                        raqueta.moverDerecha();
                        break;
                    case 65:
                        raqueta.moverIzquierda();
                        break;
                }
            }

        });
        this.frame.setFocusable(true);
    }
    
    private void pausaActionPerformed(java.awt.event.ActionEvent evt) {
        for (int i = 0; i < contPelotas; i++) {
            pelotas[i].cambiarEstadoPausa();
        }
        if (!pausado) {
            pausa.setIcon(new ImageIcon("recursos/PlayButtonNormal.png"));
            pausa.setRolloverIcon(new ImageIcon("recursos/PlayButtonRollover.png"));
            cronometro.getCronometro().time.stop();
            fondoOpaco.setVisible(true);
            pausado = true;
        } else {
            pausa.setIcon(new ImageIcon("recursos/PauseButtonPressed.png"));
            pausa.setRolloverIcon(new ImageIcon("recursos/PauseButtonRollover.png"));
            frame.requestFocus();
            pausado = false;
            cronometro.getCronometro().time.start();
            fondoOpaco.setVisible(false);
        }
    }

    public void agregarPelota(Pelota pelota) {
        if (contPelotas < 50) {
            pelota.setHilo(new Thread(pelota));
            pelota.getHilo().start();
            game.add(pelota);
            pelota.setSpeed(SLOW);
            pelota.setPanelJuego(this);
            pelotas[contPelotas++] = pelota;
        }
    }

    public void eliminarPelota(Pelota pelota) {
        for (int i = 0; i < contPelotas; i++) {
            if (pelotas[i].equals(pelota) && pelotas[i] != null) {
                pelotas[i].setVisible(false);
                pelotas[i].cambiarEstado();
                pelotas[i] = null;
                ordenarArray(pelotas);
                contPelotas--;
                repaint();
                break;
            }
        }
    }

    public Raqueta getRaqueta() {
        return raqueta;
    }

    public void eliminarBloque(Bloque bloque) {
        for (int i = 0; i < contBloques; i++) {
            if (bloques[i] != null && bloques[i].equals(bloque)) {
                bloques[i] = null;
                ordenarArray(bloques);
                contBloques--;
                break;
            }
        }
    }

    public Bloque[] getBloques() {
        return bloques;
    }

    public Pelota[] getPelotas() {
        return pelotas;
    }

    public int getContPelotas() {
        return contPelotas;
    }

    public boolean isPausado() {
        return pausado;
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }

    public void ordenarArray(PanelComponente array[]) {
        Comparator<PanelComponente> customComparator = (a, b) -> {
            if (a == null && b == null) {
                return 0;
            }
            if (a == null) {
                return 1;
            }
            if (b == null) {
                return -1;
            }
            return 0;
        };
        Arrays.sort(array, customComparator);
    }

    public PanelIMG getGame() {
        return game;
    }

    public void setGame(PanelIMG game) {
        this.game = game;
    }

    public PanelIMG getMarco() {
        return marco;
    }

    public void setMarco(PanelIMG marco) {
        this.marco = marco;
    }

    @Override
    public void paintComponents(Graphics graphics) {
        super.paintComponent(graphics);
        for (Bloque obj : bloques) {
            game.add(obj);
            obj.paint(graphics);
        }
        game.paint(graphics);
    }

}
