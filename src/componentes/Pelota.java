/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import Game.PanelJuego;
import java.awt.Rectangle;
import javax.swing.JPanel;

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

    public boolean colisionRaqueta(Raqueta raqueta) {
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
        if (getY() < 320) {
            for (Bloque obj : panelJuego.getBloques()) {
                if (obj != null && colisionBloque(obj)) {
                    if (obj.getVida() == 0) {
                        panelJuego.eliminarBloque(obj);
                        obj.setVisible(false);
                    }
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
            }
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
