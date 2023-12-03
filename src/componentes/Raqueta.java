package componentes;

import java.awt.Rectangle;
import javax.swing.JPanel;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
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
                    this.setSize(60, 30);
                    break;
                case 1:
                    this.setImage("recursos/raqueta1.png");
                    this.setSize(110, 30);
                    break;
                case 2:
                    this.setImage("recursos/raqueta2.png");
                    this.setSize(161, 30);
                    break;
            }
        }
    }

    public void colision(Pelota pelota) {
        Rectangle rIzquierdo = new Rectangle(getX(), getY() + 1, 1, getHeight() - 2);
        Rectangle rDerecho = new Rectangle(getX() + getWidth() - 1, getY() + 1, 1, getHeight() - 2);
        Rectangle rAbajo = new Rectangle(getX(), getY() + getHeight() - 1, getWidth(), 1);
        double[] velocidades;
        if (pelota.getBounds().intersects(rIzquierdo)) {
            pelota.setvX(-pelota.getvX());
            pelota.setLocation(pelota.getX() - 26, pelota.getY());
        } else if (pelota.getBounds().intersects(rDerecho)) {
            pelota.setvX(-pelota.getvX());
            pelota.setLocation(pelota.getX() + 26, pelota.getY());
        } else if (pelota.getBounds().intersects(rAbajo)) {
            pelota.setvY(-pelota.getvY());
            pelota.setLocation(pelota.getX(), pelota.getY());
        } else {
            switch (estado) {
                case 0:
                    velocidades = new double[]{2.12, 2};
                    tipoColision(pelota, 20, velocidades);
                    break;
                case 1:
                    velocidades = new double[]{2.25, 2.12, 2};
                    tipoColision(pelota, 22, velocidades);
                    break;
                case 2:
                    velocidades = new double[]{2.5, 2.25, 2.12, 2};
                    tipoColision(pelota, 23, velocidades);
                    break;
            }
            pelota.setLocation(pelota.getX(), pelota.getY());
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
                pelota.setvX(-velocidades[i]);
            } else {
                pelota.setvX(velocidades[i]);
            }
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
