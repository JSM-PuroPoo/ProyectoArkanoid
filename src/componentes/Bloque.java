package componentes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
/*
Cada bloque tiene una posibilidad de lanzarte una habilidad al romperlo
 */
public class Bloque extends Componente {

    protected int vida;
    protected BufferedImage imagen;

    public Bloque(int vida, BufferedImage imagen, Container contenedor, Color color, Rectangle r, int vX, int vY) {
        super(color, r, vX, vY);
        this.vida = vida;
        this.imagen = imagen;
        this.contenedor = contenedor;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.getImage(), r.x, r.y, contenedor);
    }

    @Override
    public void mover() {

    }

}
