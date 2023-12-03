package componentes;

import javax.swing.JPanel;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class Bloque extends PanelComponente {

    private int vida;
    private boolean especial;
    private int puntuacion;

    public Bloque(int vida, int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        super(x, y, width, height, vX, vY, contenedor);
        this.vida = vida;
        this.especial = false;
        puntuacion = 100 * vida;
        asignarImagen();
    }

    public Bloque(boolean especial, int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        this(1, x, y, width, height, vX, vY, contenedor);
        this.especial = especial;
        puntuacion = 500;
        setImage("recursos/bloqueRosado.png");
        scaleImage(getWidth(), getHeight());
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void colision() {
        vida--;
        asignarImagen();
    }

    public void asignarImagen() {
        if (!especial) {
            if (vida < 0) {
                setImage("recursos/bloqueGris.png");
            } else if (vida == 1) {
                setImage("recursos/bloqueAzul.png");
            } else if (vida == 2) {
                setImage("recursos/bloqueVerde.png");
            } else if (vida == 3) {
                setImage("recursos/bloqueAmarillo.png");
            } else if (vida == 4) {
                setImage("recursos/bloqueRojo.png");
            }
        }
        scaleImage(getWidth(), getHeight());
    }

    public int getPuntuacion() {
        return puntuacion;
    }

}
