/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
//raqueta normal 110, 30

public class Raqueta extends PanelComponente {

    private int estado;

    public Raqueta(JPanel contenedor) {
        super(365, 555, 110, 30, 22, 0, contenedor);
        this.estado = 1;
        this.setImage("recursos/raqueta1.png");

    }

    public void actualizarEstado(int estado) {
        if (this.estado != estado) {
            this.estado = estado;
            switch (estado) {
                case 0:
                    this.setImage("recursos/raqueta0.png");
                    this.setBounds(getX(), getY(), 60, 30);
                    break;
                case 1:
                    this.setImage("recursos/raqueta1.png");
                    this.setBounds(getX(), getY(), 110, 30);
                    break;
                case 2:
                    this.setImage("recursos/raqueta2.png");
                    this.setBounds(getX(), getY(), 161, 30);
                    break;
            }
        }
    }

    public void colision(Pelota pelota) {
        Rectangle rIzquierdo = new Rectangle(getX(), getY() + 1 , 1, getHeight() - 2);
        Rectangle rDerecho = new Rectangle(getX() + getWidth() - 1, getY() + 1, 1, getHeight() - 2);
        Rectangle rAbajo = new Rectangle(getX(), getY() + getHeight() - 1, getWidth(), 1);

        if (pelota.getBounds().intersects(rIzquierdo)) {
            pelota.setvX(-pelota.getvX());
            pelota.setLocation(pelota.getX() - 26, pelota.getY());
        } else if (pelota.getBounds().intersects(rDerecho)) {
            pelota.setvX(-pelota.getvX());
            pelota.setLocation(pelota.getX() + 26, pelota.getY());
        } else if (pelota.getBounds().intersects(rAbajo)) {
            pelota.setvY(-pelota.getvY());
            pelota.setLocation(pelota.getX(), pelota.getY() + 25);
        } else {
           /* switch (estado) {
                case 0:
                    tipoColision0(pelota);
                    break;
                case 1:
                    tipoColision1(pelota);
                    break;
                case 2:
                    System.out.println(pelota.getvX());
                    tipoColision2(pelota);
                    break;
            }*/
            pelota.setLocation(pelota.getX(), pelota.getY() - 25);
            pelota.setvY(-pelota.getvY());
        }

    }

    public void tipoColision(Pelota pelota, int cellWidth, double[] velocidades) {
        Rectangle r;
        int i;
        int numCells = velocidades.length;
        for (i = 0; i < numCells; i++) {
            r = new Rectangle(getX() + cellWidth * i, getY() - 2, cellWidth, 1);
            if (pelota.getBounds().intersects(r)) {
                break;
            }
        }
        if (i < numCells) {
            if (pelota.getvX() < 0) {
                pelota.setvX(-15 * velocidades[i]);
            } else {
                pelota.setvX(15 * velocidades[i]);
            }
        }
    }

    public void tipoColision0(Pelota pelota) {
        double[] velocidades = {1.05, 1, 1.05};
        tipoColision(pelota, 20, velocidades);
    }

    public void tipoColision1(Pelota pelota) {
        double[] velocidades = {1.1, 1.05, 1, 1.05, 1.1};
        tipoColision(pelota, 22, velocidades);
    }

    public void tipoColision2(Pelota pelota) {
        double[] velocidades = {1.15, 1.1, 1.05, 1, 1.05, 1.1, 1.15};
        tipoColision(pelota, 23, velocidades);
    }

    public void moverIzquierda() {
        int nuevaX = (int) (getX() - getvX());
        if (nuevaX < 8) {
            nuevaX = 8;
        }
        setLocation(nuevaX, getY());
        repaint();
    }

    public void moverDerecha() {
        int nuevaX = (int) (getX() + getvX());
        int maxX = getContenedor().getWidth() - getWidth() - 8;
        if (nuevaX > maxX) {
            nuevaX = maxX;
        }
        setLocation(nuevaX, getY());
        repaint();
    }

}
