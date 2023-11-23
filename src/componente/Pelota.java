/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import Game.PanelJuego;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Pelota extends PanelComponente implements Runnable {

    private int speed;
    private Raqueta r;
    private PanelJuego panelJuego;

    public Pelota(int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        super(x, y, width, height, vX, vY, contenedor);
        this.setImage("recursos/pelota.png");
    }

    public boolean colisionBloque(Bloque bloque) {
        Rectangle rIzquierdo = new Rectangle(bloque.getX(), bloque.getY(), 1, bloque.getHeight());
        Rectangle rDerecho = new Rectangle(bloque.getX() + bloque.getWidth() - 1, bloque.getY(), 1, bloque.getHeight());
        Rectangle rAbajo = new Rectangle(bloque.getX(), bloque.getY() + bloque.getHeight() - 1, bloque.getWidth(), 1);

        if (bloque.getBounds().intersects(getBounds())) {
            if (bloque.colision()) {
                bloque = null;
            }
            return true;
        } else {
            return false;
        }
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

    public Raqueta getR() {
        return r;
    }

    public void setR(Raqueta r) {
        this.r = r;
    }

    public PanelJuego getPanelJuego() {
        return panelJuego;
    }

    public void setPanelJuego(PanelJuego panelJuego) {
        this.panelJuego = panelJuego;
    }

    public void mover() {
        super.mover();
        if (colisionRaqueta(r)) {
            r.colision(this);
        }
    }

    public void colisionJuego() {
        for (Bloque obj : panelJuego.getBloques()) {
            if (colisionBloque(obj)) {
                break;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            this.mover();
            this.repaint();
            this.colisionJuego();
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
