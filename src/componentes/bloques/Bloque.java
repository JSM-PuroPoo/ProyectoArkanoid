package componentes.bloques;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
/*
Cada bloque tiene una posibilidad de lanzarte una habilidad al romperlo
*/
public class Bloque extends componentes.Componente {

    protected int vida;

    public Bloque(Color color, Point punto, int ancho, int alto, int vX, int vY) {
        super(color, punto, ancho, alto, vX, vY);
    }

    public Bloque(int vida, Color color, Point punto, int ancho, int alto, int vX, int vY) {
        super(color, punto, ancho, alto, vX, vY);
        this.vida = vida;
    }

    @Override
    public void paint(Graphics2D g) {

    }

}
