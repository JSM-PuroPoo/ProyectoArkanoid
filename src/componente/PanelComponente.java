package componente;

import interfaz.paneles.PanelIMG;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Objects;

public class PanelComponente extends PanelIMG {

    protected double vX;
    protected double vY;
    protected JPanel contenedor;

    public PanelComponente(int x, int y, int width, int height, double vX, double vY, JPanel contenedor) {
        this.setBounds(x, y, width, height);
        this.vX = vX;
        this.vY = vY;
        this.contenedor = contenedor;
        this.setOpaque(false);
    }

    public double getvX() {
        return vX;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getvY() {
        return vY;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public JPanel getContenedor() {
        return contenedor;
    }

    public void setContenedor(JPanel contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PanelComponente other = (PanelComponente) obj;

        if (this.vX != other.vX) {
            return false;
        }
        if (this.vY != other.vY) {
            return false;
        }
        if (!Objects.equals(this.contenedor, other.contenedor)) {
            return false;
        }

        if (!this.getBounds().equals(other.getBounds())) {
            return false;
        }

        return true;
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
        setLocation((int)(getX() + vX), (int)(getY() + vY));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
