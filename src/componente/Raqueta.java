/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
//raqueta normal 110, 30

public class Raqueta extends PanelComponente {

    private int estado;

    public Raqueta(int x, int y, int width, int height, JPanel contenedor) {
        super(x, y, width, height, 25, 0, contenedor);
        this.estado = 0;
        this.setImage("recursos/raqueta0.png");

    }

    public void actualizarEstado(int estado) {

    }

    public void moverIzquierda() {
        int nuevaX = getX() - getvX();
        if (nuevaX < 8) {
            nuevaX = 8;
        }
        setLocation(nuevaX, getY());
        repaint();
    }

    public void moverDerecha() {
        int nuevaX = getX() + getvX();
        int maxX = getContenedor().getWidth() - getWidth() - 8;
        if (nuevaX > maxX) {
            nuevaX = maxX;
        }
        setLocation(nuevaX, getY());
        repaint();
    }

}
