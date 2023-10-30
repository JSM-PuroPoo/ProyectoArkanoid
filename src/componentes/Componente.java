package componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public abstract class Componente {

    protected Color color;
    protected Point punto;
    protected int ancho;
    protected int alto;
    protected int vX;
    protected int vY;

    public Componente(Color color, Point punto, int ancho, int alto, int vX, int vY) {
        this.color = color;
        this.punto = punto;
        this.ancho = ancho;
        this.alto = alto;
        this.vX = vX;
        this.vY = vY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPunto() {
        return punto;
    }

    public void setPunto(Point punto) {
        this.punto = punto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
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
    
    public abstract void paint(Graphics2D g);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Componente{");
        sb.append("color=").append(color);
        sb.append(", punto=").append(punto);
        sb.append(", ancho=").append(ancho);
        sb.append(", alto=").append(alto);
        sb.append(", vX=").append(vX);
        sb.append(", vY=").append(vY);
        sb.append('}');
        return sb.toString();
    }
    
    
}
