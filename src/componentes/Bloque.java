/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import Sonido.Sonido;
import javax.swing.JPanel;

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
