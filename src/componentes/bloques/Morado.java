/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes.bloques;

import java.awt.Color;
import java.awt.Point;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
/*
Bloque Morado es un bloque el cual se rompe al tocarlo una vez y te suelta una habilidad aleatoria
 */
public class Morado extends Bloque {

    public Morado(Point punto, int ancho, int alto, int vX, int vY) {
        super(1, Color.MAGENTA, punto, ancho, alto, vX, vY);
    }
    
}
