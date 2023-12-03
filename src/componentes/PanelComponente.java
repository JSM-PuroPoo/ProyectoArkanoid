package componentes;

import interfaz.paneles.PanelIMG;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Objects;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
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
    
    public void setX(int x){
        this.setBounds(x, getY(), getWidth(), getHeight());
    }
    
    public void setY(int y){
        this.setBounds(getX(), y, getWidth(), getHeight());
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
        int nuevaX = (int) (getX() + vX);
        int nuevaY = (int) (getY() + vY);

        if (contenedor != null) {
            int maxX = contenedor.getWidth() - getWidth() - 8; 
            int maxY = contenedor.getHeight() - getHeight() - 8; 

            if (nuevaX < 8 || nuevaX > maxX) { 
                vX = -vX;
                nuevaX = Math.min(Math.max(nuevaX, 8), maxX); 
            }

            if (nuevaY < 8 || nuevaY > maxY) { 
                vY = -vY;
                nuevaY = Math.min(Math.max(nuevaY, 8), maxY);
            }
        }

        setLocation(nuevaX, nuevaY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
