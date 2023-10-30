package componentes.bloques;

import java.awt.Color;
import java.awt.Point;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
/*
Bloque gris es un bloque el cual no se puede romper
 */
public class Gris extends Bloque {

    public Gris(Point punto, int ancho, int alto, int vX, int vY) {
        super(-1, Color.GRAY, punto, ancho, alto, vX, vY);
    }

}
