package Game;

import Cronometro.PanelCronometro;
import Sonido.Sonido;
import componentes.Bloque;
import componentes.PanelComponente;
import componentes.Pelota;
import componentes.Raqueta;
import configuraciones.Configuraciones;
import configuraciones.Observer;
import interfaz.Inicio;
import interfaz.Juego;
import interfaz.Settings;
import interfaz.paneles.PanelIMG;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import javax.swing.*;

public class PanelJuego extends PanelIMG implements Observer {

    private JButton closeButton = new JButton();
    private JButton minimizeButton = new JButton();
    private Bloque bloques[];
    private Pelota pelotas[];
    private Raqueta raqueta;
    private PanelIMG game;
    private PanelIMG marco;
    public int contPelotas = 0;
    public int contBloques;
    public String rutaFondo;
    public String rutaFJuego;
    public String rutaMarco;
    private int puntaje;
    public Juego frame;
    private JLabel puntos = new JLabel();
    private int vidas;

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
    private int velocidad;

    private Sonido cancion = new Sonido();
    private Configuraciones configuraciones;
    public boolean validarMusica = true;
    public boolean iniciarJuego;
    boolean pelotasCargadas = false;

    public PanelJuego(Bloque bloques[], String rutaFondo, String rutaFJuego, String rutaMarco, Juego frame) {
        frame.setTitle("Ocaso Arkanoid");
        iniciarJuego = false;
        frame.setIconImage(new ImageIcon("recursos/logo.png").getImage());
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
        cronometro.setLocation(931, 100);

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

        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });

        homeButton.setIcon(new ImageIcon("recursos/HomeButton.png"));
        homeButton.setRolloverIcon(new ImageIcon("recursos/HomeButtonPressed.png"));
        homeButton.setBounds(105, 130, 191, 105);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setOpaque(false);
        homeButton.setLayout(null);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        panelPausa.add(homeButton);

        settingsButton.setIcon(new ImageIcon("recursos/SettingspausePanelButton.png"));
        settingsButton.setRolloverIcon(new ImageIcon("recursos/settingspausePanelButtonPressed.png"));
        settingsButton.setBounds(60, 215, 286, 105);
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setOpaque(false);
        settingsButton.setLayout(null);
        panelPausa.add(settingsButton);

        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonPerformed(evt);
            }
        });

        exitButton.setIcon(new ImageIcon("recursos/ExitpausePanelButton.png"));
        exitButton.setRolloverIcon(new ImageIcon("recursos/ExitpausePanelButtonPressed.png"));
        exitButton.setBounds(115, 300, 168, 105);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setOpaque(false);
        exitButton.setLayout(null);
        panelPausa.add(exitButton);

        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        puntos.setBounds(930, 430, 350, 126);
        puntos.setText("00000");
        puntos.setFont(cronometro.getFont().deriveFont(Font.PLAIN, 80));
        puntos.setForeground(Color.white);
        this.add(puntos);

        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER && !iniciarJuego) {
                    iniciarJuego = true;
                    cronometro.getCronometro().time.start();
                    for (int i = 0; i < contPelotas; i++) {
                        pelotas[i].setvX(-2);
                        pelotas[i].setvY(-2);
                    }
                }
                if (contPelotas > 0) {
                    if ((keyCode == 39 || keyCode == 68) && !iniciarJuego) {
                        for (int i = 0; i < contPelotas; i++) {
                            pelotas[i].setX((int) (pelotas[i].getX() + raqueta.getvX()));
                            if (pelotas[i].getX() > 856 - 8 - raqueta.getWidth()) {
                                pelotas[i].setX(raqueta.getX() + raqueta.getWidth() / 2 - pelotas[i].getWidth() / 2);
                            }
                        }
                    } else if ((keyCode == 37 || keyCode == 65) && !iniciarJuego) {
                        for (int i = 0; i < contPelotas; i++) {
                            pelotas[i].setX((int) (pelotas[i].getX() - raqueta.getvX()));
                            if (pelotas[i].getX() < raqueta.getWidth() / 2 + 8) {
                                pelotas[i].setX(raqueta.getX() + raqueta.getWidth() / 2 - pelotas[i].getWidth() / 2);
                            }
                        }
                    }
                }

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

        closeButton.setIcon(new ImageIcon("recursos/closeButton.png"));
        closeButton.setRolloverIcon(new ImageIcon("recursos/closeButtonRed.png"));
        closeButton.setBounds(1173, 3, 24, 24);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setOpaque(false);
        closeButton.setLayout(null);
        marco.add(closeButton);
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
        marco.add(minimizeButton);
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt, frame);
            }
        });
    }

    @Override
    public void actualizar(Configuraciones configuraciones) {
        this.configuraciones = configuraciones;
        if (configuraciones.isMusica()) {
            cancion.setCondicion(true);
            reproducirCancion();
            if (pausado) {
                cancion.detener();
            }
            validarMusica = true;
        } else {
            cancion.setCondicion(false);
            validarMusica = false;
        }
        switch (configuraciones.getDificultad()) {
            case 1:
                velocidad = SLOW;
                vidas = 5;
                break;
            case 2:
                velocidad = NORMAL;
                vidas = 3;
                break;
            case 3:
                velocidad = FAST;
                vidas = 1;
                break;
        }

        cargarPelotas();

    }

    private void resumeButtonActionPerformed(ActionEvent evt) {
        if (pausado) {
            pausa.setIcon(new ImageIcon("recursos/PauseButtonPressed.png"));
            pausa.setRolloverIcon(new ImageIcon("recursos/PauseButtonRollover.png"));
            frame.requestFocus();
            pausado = false;
            cronometro.getCronometro().time.start();
            fondoOpaco.setVisible(false);
            for (int i = 0; i < contPelotas; i++) {
                pelotas[i].cambiarEstadoPausa();
            }
            pausa.setEnabled(true);
            if (cancion.getClip() != null && configuraciones.isMusica()) {
                cancion.cambiarEstadoReproduccion();
            }

        }
    }

    private void homeButtonActionPerformed(ActionEvent evt) {
        frame.dispose();
        Inicio inicio = new Inicio(configuraciones);
        inicio.setVisible(true);
    }

    private void settingsButtonPerformed(ActionEvent evt) {
        frame.setVisible(false);
        Settings settings = new Settings(configuraciones);
        settings.setJuego(true);
        settings.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                actualizar(settings.getConfiguraciones());
                if (settings.isAceptar()) {
                    frame.dispose();
                    frame = new Juego(settings.getConfiguraciones());
                    frame.setVisible(true);
                } else {
                    frame.setVisible(true);
                }
            }
        });
        settings.setVisible(true);
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        closeButtonActionPerformed(evt);
    }

    private void closeButtonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void minimizeButtonActionPerformed(ActionEvent evt, JFrame frame) {
        frame.setExtendedState(1);
    }

    private void pausaActionPerformed(java.awt.event.ActionEvent evt) {
        if (!pausado) {
            pausa.setIcon(new ImageIcon("recursos/PlayButtonNormal.png"));
            pausa.setRolloverIcon(new ImageIcon("recursos/PlayButtonRollover.png"));
            cronometro.getCronometro().time.stop();
            fondoOpaco.setVisible(true);
            pausado = true;
            for (int i = 0; i < contPelotas; i++) {
                pelotas[i].cambiarEstadoPausa();
            }
            pausa.setEnabled(false);
            if (cancion.getClip() != null && configuraciones.isMusica() && cancion.getClip().isRunning()) {
                cancion.cambiarEstadoReproduccion();
            }
        }
    }

    public void cargarPelotas() {
        if (!iniciarJuego && !pelotasCargadas) {
            for (int i = 0; i < configuraciones.getCantidadPelotas(); i++) {
                agregarPelota(new Pelota(432, 525 - 60 * i, 25, 25, 0, 0, getGame()));
                pelotasCargadas = true;
            }
        }
    }

    public void agregarPelota(Pelota pelota) {
        if (contPelotas < 50) {
            pelota.setPanelJuego(this);
            pelota.setHilo(new Thread(pelota));
            pelota.getHilo().start();
            game.add(pelota);
            pelota.setSpeed(velocidad);
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
                if (contPelotas == 0 && vidas > 0) {
                    iniciarJuego = false;
                    raqueta.setLocation(365, 555);
                    cronometro.getCronometro().time.stop();
                    pelotasCargadas = false;
                    cargarPelotas();
                    vidas--;
                } else if (contPelotas == 0 && vidas == 0) {
                    finDelJuego();
                }
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
                this.setPuntaje(this.getPuntaje() + bloque.getPuntuacion());
                puntos.setText(new DecimalFormat("00000").format(getPuntaje()));
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

    public Sonido getCancion() {
        return cancion;
    }

    public void setCancion(Sonido cancion) {
        this.cancion = cancion;
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

    public void reproducirCancion() {
        Random random = new Random();
        int indiceRandom = random.nextInt(11) + 1;
        if (cancion.getClip() == null) {
            cancion.cargarSonido("sonidos/cancionJuego" + indiceRandom + ".wav");
            cancion.reproducir(0);
        }
    }

    public Configuraciones getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(Configuraciones configuraciones) {
        this.configuraciones = configuraciones;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void finDelJuego() {
        cronometro.getCronometro().time.stop();
        switch (configuraciones.getDificultad()) {
            case 1:
                puntaje += 500;
                break;
            case 2:
                puntaje += 700;
                break;
            case 3:
                puntaje += 1000;
                break;
        }
        User user = new User(puntaje, cronometro.getCronometro());
    }

}
