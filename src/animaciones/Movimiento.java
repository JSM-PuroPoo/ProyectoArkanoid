package animaciones;

import componente.PanelComponente;

public class Movimiento extends Thread {

    private PanelComponente panelComponente;
    private int speed;

    public Movimiento(PanelComponente panelComponente, int speed) {
        this.panelComponente = panelComponente;
        this.speed = speed;
    }

    public PanelComponente getPanelComponente() {
        return panelComponente;
    }

    public void setPanelComponente(PanelComponente panelComponente) {
        this.panelComponente = panelComponente;
    }

    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true) {
            panelComponente.mover();
            panelComponente.repaint();
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
