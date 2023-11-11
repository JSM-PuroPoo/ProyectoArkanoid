/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
//raqueta normal 110, 30

public class Raqueta extends PanelComponente {

    private int estado;

    public Raqueta(JPanel contenedor) {
        super(30, 525, 110, 30, 25, 0, contenedor);
        this.estado = 1;
        this.setImage("recursos/raqueta1.png");

    }

    public void actualizarEstado(int estado) {
        if (this.estado != estado) {
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
        switch (estado) {
            case 0:
                tipoColision0(pelota);
                break;
            case 1:
                tipoColision1(pelota);
                break;
            case 2:
                tipoColision2(pelota);
                break;
        }
        pelota.setvY(-pelota.getvY());
    }

    public void tipoColision0(Pelota pelota) {
        Rectangle r;
        int i;
        for (i = 0; i < 3; i++) {
            r = new Rectangle(getX() + 20 * i, getY(), 20, 30);
            if (pelota.getBounds().intersects(r)) {
                break;
            }
        }
        switch (i) {
            case 0:
                pelota.setvX(15 * -1.1);
                if (pelota.getBounds().intersects(new Rectangle(this.getX(), this.getY(), 1, this.getHeight()))) {
                    pelota.setvY(-pelota.getvY());
                }
                break;
            case 1:
                pelota.setvX(15);
                break;
            case 2:
                pelota.setvX(15 * 1.1);
                break;
        }
    }

    public void tipoColision1(Pelota pelota) {
        Rectangle r;
        int i;
        for (i = 0; i < 5; i++) {
            r = new Rectangle(getX() + 22 * i, getY(), 22, 30);
            if (pelota.getBounds().intersects(r)) {
                break;
            }
        }
        switch (i) {
            case 0:
                pelota.setvX(15 * -1.3);
                break;
            case 1:
                pelota.setvX(15 * -1.1);
                break;
            case 2:
                pelota.setvX(15);
                break;
            case 3:
                pelota.setvX(15 * 1.1);
                break;
            case 4:
                pelota.setvX(15 * 1.3);
        }
    }

    public void tipoColision2(Pelota pelota) {
        Rectangle r;
        int i;
        for (i = 0; i < 7; i++) {
            r = new Rectangle(getX() + 23 * i, getY(), 23, 30);
            if (pelota.getBounds().intersects(r)) {
                break;
            }
        }
        switch (i) {
            case 0:
                pelota.setvX(15 * -1.5);
                break;
            case 1:
                pelota.setvX(15 * -1.3);
                break;
            case 2:
                pelota.setvX(15 * -1.1);
                break;
            case 3:
                pelota.setvX(15);
                break;
            case 4:
                pelota.setvX(15 * 1.1);
                break;
            case 5:
                pelota.setvX(15 * 1.3);
            case 6:
                pelota.setvX(15 * 1.5);
                break;
        }
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
