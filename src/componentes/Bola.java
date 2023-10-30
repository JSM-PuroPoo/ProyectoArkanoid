package componentes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class Bola extends Componente {

    public Bola(Color color, Point punto, int ancho, int alto, int vX, int vY) {
        super(color, punto, ancho, alto, vX, vY);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(this.color);
        g.fill(new Ellipse2D.Double(punto.x, punto.y, ancho, alto));
        g.setColor(Color.GRAY);
        g.drawOval(punto.x, punto.y, ancho, alto);
    }

}
