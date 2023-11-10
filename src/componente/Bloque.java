/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente;

import javax.swing.JPanel;

public class Bloque extends PanelComponente {

    private int vida;

    public Bloque(int vida, int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        super(x, y, width, height, vX, vY, contenedor);
        this.vida = vida;
        asignarImagen();
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void colision() {
        vida--;
    }

    public void asignarImagen() {
        if (vida < 0) {
            setImage("recursos/bloqueGris.png");
        }
    }
}
