package interfaz.paneles;

import componentes.Componente;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class PanelHilo extends PanelIMG implements Runnable {

    private Componente componente;
    private int velocidad;

    public PanelHilo(Componente componente, int velocidad) {
        this.componente = componente;
        this.velocidad = velocidad;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        while (true) {
            componente.getContenedor().repaint();
            componente.mover();
            try {
                Thread.sleep(velocidad);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

}
