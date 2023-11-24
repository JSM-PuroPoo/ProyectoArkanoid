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
        Rectangle pelotaBounds = this.getBounds();
        Rectangle bloqueBounds = bloque.getBounds();

        if (pelotaBounds.intersects(bloqueBounds)) {
            double centroX = pelotaBounds.getCenterX();
            double centroY = pelotaBounds.getCenterY();

            double overlapX = Math.min(Math.abs(pelotaBounds.getMaxX() - bloqueBounds.getMinX()), Math.abs(pelotaBounds.getMinX() - bloqueBounds.getMaxX()));
            double overlapY = Math.min(Math.abs(pelotaBounds.getMaxY() - bloqueBounds.getMinY()), Math.abs(pelotaBounds.getMinY() - bloqueBounds.getMaxY()));

            if (overlapX < overlapY) {

                setvX(-getvX());

                if (centroX < bloqueBounds.getCenterX()) {
                    setX(bloque.getX() - getWidth());
                } else {
                    setX(bloque.getX() + bloque.getWidth());
                }
            } else {

                setvY(-getvY());

                if (centroY < bloqueBounds.getCenterY()) {
                    setY(bloque.getY() - getHeight());
                } else {
                    setY(bloque.getY() + bloque.getHeight());
                }
            }

            bloque.colision();
            return true;
        }

        return false;
    }

    /*public boolean colisionBloque(Bloque bloque) {
        Rectangle pelotaBounds = this.getBounds();
        Rectangle bloqueBounds = bloque.getBounds();

        if (pelotaBounds.intersects(bloqueBounds)) {
            double overlapX = Math.min(Math.abs(pelotaBounds.getMaxX() - bloqueBounds.getMinX()), Math.abs(pelotaBounds.getMinX() - bloqueBounds.getMaxX()));
            double overlapY = Math.min(Math.abs(pelotaBounds.getMaxY() - bloqueBounds.getMinY()), Math.abs(pelotaBounds.getMinY() - bloqueBounds.getMaxY()));
            double centroX = pelotaBounds.getCenterX();
            double centroY = pelotaBounds.getCenterY();
            if (overlapX < overlapY) {
                setvX(-getvX());
                setX(centroX < bloqueBounds.getCenterX() ? bloque.getX() - getWidth() : bloque.getX() + bloque.getWidth());
            } else {
                setvY(-getvY());
                setY(centroY < bloqueBounds.getCenterY() ? bloque.getY() - getHeight() : bloque.getY() + bloque.getHeight());
            }

            bloque.colision();
            return true;
        }

        return false;
    }*/

 /*public boolean colisionBloque(Bloque bloque) {
        Rectangle pelotaBounds = this.getBounds();
        Rectangle bloqueBounds = bloque.getBounds();
        double centroX = pelotaBounds.getCenterX();
        double centroY = pelotaBounds.getCenterY();
        if (pelotaBounds.intersects(bloqueBounds)) {
            double overlapX = Math.min(Math.abs(pelotaBounds.getMaxX() - bloqueBounds.getMinX()), Math.abs(pelotaBounds.getMinX() - bloqueBounds.getMaxX()));
            double overlapY = Math.min(Math.abs(pelotaBounds.getMaxY() - bloqueBounds.getMinY()), Math.abs(pelotaBounds.getMinY() - bloqueBounds.getMaxY()));

            if (overlapX < overlapY) {
                setvX(-getvX());

                // Ajustar la posición en función de la ubicación de la colisión en el bloque
                double adjustmentX = (getWidth() / 2) * (getvX() > 0 ? 1 : -1);
                setX((int) (centroX < bloqueBounds.getCenterX() ? bloque.getX() - getWidth() + adjustmentX : bloque.getX() + bloque.getWidth() + adjustmentX));
            } else {
                setvY(-getvY());

                // Ajustar la posición en función de la ubicación de la colisión en el bloque
                double adjustmentY = (getHeight() / 2) * (getvY() > 0 ? 1 : -1);
                setY((int) (centroY < bloqueBounds.getCenterY() ? bloque.getY() - getHeight() + adjustmentY : bloque.getY() + bloque.getHeight() + adjustmentY));
            }

            bloque.colision();
            return true;
        }

        return false;
    }*/
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

    @Override
    public void mover() {
        super.mover();
        if (colisionRaqueta(r)) {
            r.colision(this);
        }
        
    }

    public void colisionJuego() {
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
