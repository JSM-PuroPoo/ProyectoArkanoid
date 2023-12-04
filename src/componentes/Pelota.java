package componentes;

import Game.PanelJuego;
import Sonido.Sonido;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class Pelota extends PanelComponente implements Runnable {

    private int speed;
    private PanelJuego panelJuego;
    private Thread hilo;
    private boolean continuar;
    private boolean pausa;

    public Pelota(int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        super(x, y, width, height, vX, vY, contenedor);
        this.setImage("recursos/pelota.png");
        continuar = true;
        pausa = false;
    }

    public boolean colisionBloque(Bloque bloque) {
        Rectangle pelotaBounds = this.getBounds();
        Rectangle bloqueBounds = bloque.getBounds();
        if (pelotaBounds.intersects(bloqueBounds)) {
            double overlapX = Math.min(Math.abs(pelotaBounds.getMaxX() - bloqueBounds.getMinX()), Math.abs(pelotaBounds.getMinX() - bloqueBounds.getMaxX()));
            double overlapY = Math.min(Math.abs(pelotaBounds.getMaxY() - bloqueBounds.getMinY()), Math.abs(pelotaBounds.getMinY() - bloqueBounds.getMaxY()));
            if (overlapX < overlapY) {
                setvX(-getvX());
            } else {
                setvY(-getvY());
            }
            bloque.colision();
            return true;
        }
        return false;
    }

    public boolean colisionPelota(Pelota pelota) {
        Rectangle pelotaBounds = this.getBounds();
        Rectangle otraPelotaBounds = pelota.getBounds();

        if (this != pelota) {
            if (pelotaBounds.intersects(otraPelotaBounds)) {
                double overlapX = Math.min(Math.abs(pelotaBounds.getMaxX() - otraPelotaBounds.getMinX()), Math.abs(pelotaBounds.getMinX() - otraPelotaBounds.getMaxX()));
                double overlapY = Math.min(Math.abs(pelotaBounds.getMaxY() - otraPelotaBounds.getMinY()), Math.abs(pelotaBounds.getMinY() - otraPelotaBounds.getMaxY()));
                if (overlapX < overlapY) {
                    if (pelotaBounds.getMaxX() < otraPelotaBounds.getMinX()) {
                        setX((int) (getX() - overlapX));
                        pelota.setX((int) (pelota.getX() + overlapX));
                    } else {
                        setX((int) (getX() + overlapX));
                        pelota.setX((int) (pelota.getX() - overlapX));
                    }
                    setvX(-getvX());
                    pelota.setvX(-pelota.getvX());
                } else {
                    if (pelotaBounds.getMaxY() < otraPelotaBounds.getMinY()) {
                        setY((int) (getY() - overlapY));
                        pelota.setY((int) (pelota.getY() + overlapY));
                    } else {
                        setY((int) (getY() + overlapY));
                        pelota.setY((int) (pelota.getY() - overlapY));
                    }
                    setvY(-getvY());
                    pelota.setvY(-pelota.getvY());
                }

                return true;
            }
        }

        return false;
    }

    public boolean colisionRaqueta(Raqueta raqueta) {
        if (raqueta == null) {
            return false;
        }
        return this.getBounds().intersects(raqueta.getBounds());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public PanelJuego getPanelJuego() {
        return panelJuego;
    }

    public void setPanelJuego(PanelJuego panelJuego) {
        this.panelJuego = panelJuego;
    }

    public Thread getHilo() {
        return hilo;
    }

    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }

    @Override
    public void mover() {
        super.mover();
        if (colisionRaqueta(panelJuego.getRaqueta())) {
            panelJuego.getRaqueta().colision(this);
        }
        if (getY() >= 580) {
            setvY(0);
            panelJuego.eliminarPelota(this);
        }

    }

    public synchronized void colisionJuego() {
        Sonido sonido = new Sonido();
        if (getY() < 320) {
            for (Bloque obj : panelJuego.getBloques()) {
                if (obj != null && colisionBloque(obj)) {
                    if (obj.getVida() == 0) {
                        panelJuego.eliminarBloque(obj);
                        obj.setVisible(false);
                        if (panelJuego.getConfiguraciones().isSonido()) {
                            sonido.cargarSonido("sonidos/ball breack.wav");
                            sonido.setCondicion(true);
                            sonido.reproducir(0);
                        }
                    } else {
                        if (panelJuego.getConfiguraciones().isSonido()) {
                            sonido.cargarSonido("sonidos/colisionblock.wav");
                            sonido.setCondicion(true);
                            sonido.reproducir(0);
                        }
                    }
                    break;
                }
            }
        }
    }

    public void colisionPelotas() {
        synchronized (panelJuego) {
            for (int i = 0; i < panelJuego.contPelotas; i++) {
                if (panelJuego.getPelotas()[i] != null && colisionPelota(panelJuego.getPelotas()[i])) {
                    break;
                }
            }
        }
    }

    public synchronized void cambiarEstado() {
        if (continuar) {
            continuar = false;
        } else {
            continuar = true;
        }
    }

    public synchronized void cambiarEstadoPausa() {
        if (pausa) {
            pausa = false;
        } else {
            pausa = true;
        }

    }

    @Override
    public void run() {
        while (continuar) {
            if (!pausa) {
                this.mover();
                this.repaint();
                this.colisionJuego();
                this.colisionPelotas();
                if (panelJuego.getCancion().getClip() != null && panelJuego.validarMusica) {
                    if (!panelJuego.getCancion().getClip().isRunning()) {
                        panelJuego.reproducirCancion();
                    }
                }
            }
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
