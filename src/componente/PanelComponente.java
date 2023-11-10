package componente;

import interfaz.paneles.PanelIMG;
import javax.swing.JPanel;
import java.awt.Graphics;

public class PanelComponente extends PanelIMG {

    protected int vX;
    protected int vY;
    protected JPanel contenedor;

    public PanelComponente(int x, int y, int width, int height, int vX, int vY, JPanel contenedor) {
        this.setBounds(x, y, width, height);
        this.vX = vX;
        this.vY = vY;
        this.contenedor = contenedor;
    }

    public int getvX() {
        return vX;
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public int getvY() {
        return vY;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }

    public JPanel getContenedor() {
        return contenedor;
    }

    public void setContenedor(JPanel contenedor) {
        this.contenedor = contenedor;
    }

    public void mover() {
        if (contenedor != null) {
            if (getX() + vX < 0 || getX() + vX > contenedor.getWidth() - getWidth()) {
                vX = -vX;
            }

            if (getY() + vY < 0 || getY() + vY > contenedor.getHeight() - getHeight()) {
                vY = -vY;
            }
        }
        setLocation(getX() + vX, getY() + vY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
