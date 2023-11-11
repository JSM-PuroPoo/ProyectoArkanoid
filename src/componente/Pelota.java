/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import java.awt.Rectangle;
import javax.swing.JPanel;

public class Pelota extends PanelComponente implements Runnable {

    private int speed;
    private Raqueta r;

    public Pelota(int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        super(x, y, width, height, vX, vY, contenedor);
        this.setImage("recursos/pelota.png");
    }

    public boolean colisionBloque(Bloque bloque) {
        Rectangle pelotaBounds = this.getBounds();
        Rectangle bloqueBounds = bloque.getBounds();
        if (pelotaBounds.intersects(bloqueBounds)) {
            int ladoColision = 0;
            if (pelotaBounds.intersects(new Rectangle(bloqueBounds.x, bloqueBounds.y, 1, bloqueBounds.height))) {
                ladoColision = 1;
            } else if (pelotaBounds.intersects(new Rectangle(bloqueBounds.x + bloqueBounds.width - 1, bloqueBounds.y, 1, bloqueBounds.height))) {
                ladoColision = 2;
            }

            if (ladoColision == 1 || ladoColision == 2) {
                setvX(-getvX());
            } else {
                setvY(-getvY());
            }
            bloque.colision();
            if (bloque.getVida() == 0) {
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

    public void mover() {
        super.mover();
        if (colisionRaqueta(r)) {
            r.colision(this);
        }
    }

    @Override
    public void run() {
        while (true) {
            this.mover();
            this.repaint();
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
