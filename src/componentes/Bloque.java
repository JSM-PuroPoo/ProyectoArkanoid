/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import javax.swing.JPanel;

public class Bloque extends PanelComponente {

    private int vida;
    private boolean especial;
    private int puntuacion;

    public Bloque(int vida, int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        super(x, y, width, height, vX, vY, contenedor);
        this.vida = vida;
        this.especial = false;
        switch(vida){
            case 1:
                puntuacion = 10;
                break;
            case 2:
                puntuacion = 20;
                break;
            case 3:
                puntuacion = 30;
                break;
            case 4:
                puntuacion = 40;
                break;
            default:
                puntuacion = 0;
        }
        asignarImagen();
    }

    public Bloque(boolean especial, int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        this(1, x, y, width, height, vX, vY, contenedor);
        this.especial = especial;
        puntuacion = 50;
        setImage("recursos/bloqueRosado.png");
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
    }
}
