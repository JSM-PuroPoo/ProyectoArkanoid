/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Cronometro.PanelCronometro;
import componentes.Bloque;
import componentes.PanelComponente;
import componentes.Pelota;
import componentes.Raqueta;
import interfaz.paneles.PanelIMG;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;

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

    private JButton pausa = new JButton();
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
        pausa.setBackground(Color.red);
        pausa.setBounds(1170, 0, 30, 30);

        pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausaActionPerformed(evt);
            }
        });
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
        marco.add(pausa);
        this.frame.setFocusable(true);
    }

    private void pausaActionPerformed(java.awt.event.ActionEvent evt) {
        for (int i = 0; i < contPelotas; i++) {
            pelotas[i].cambiarEstadoPausa();
        }
        if (!pausado) {
            cronometro.getCronometro().time.stop();
            pausado = true;
        } else {
            frame.requestFocus();
            pausado = false;
            cronometro.getCronometro().time.start();
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
            if (pelotas[i].equals(pelota)) {
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
