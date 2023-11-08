package componentes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public abstract class Componente {

    protected BufferedImage image;
    protected Color color;
    protected Rectangle r;
    protected int vX;
    protected int vY;
    protected Container contenedor;

    public Componente(Color color, Rectangle r, int vX, int vY) {
        this.color = color;
        this.r = r;
        this.vX = vX;
        this.vY = vY;
    }

    public Componente(Rectangle r, int vX, int vY, Container contenedor) {
        this.r = r;
        this.vX = vX;
        this.vY = vY;
        this.contenedor = contenedor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle getR() {
        return r;
    }

    public void setR(Rectangle r) {
        this.r = r;
    }

    public int getvX() {
        return vX;
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public int getvY() {
        return vY;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Container getContenedor() {
        return contenedor;
    }

    public void setContenedor(Container contenedor) {
        this.contenedor = contenedor;
    }

    public abstract void paint(Graphics g);

    public abstract void mover();

}
