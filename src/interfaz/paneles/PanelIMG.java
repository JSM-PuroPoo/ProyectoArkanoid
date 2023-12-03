package interfaz.paneles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class PanelIMG extends JPanel {

    protected BufferedImage image;

    public PanelIMG() {
    }
    
    public PanelIMG(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, (ImageObserver) this);
        }

    }
    public BufferedImage getImage() {
        return image;
    }
    public void scaleImage(int width, int height) {
        if (image != null) {
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = newImage.createGraphics();
            g2d.drawImage(scaledImage, 0, 0, null);
            g2d.dispose();
            image = newImage;
            repaint();
        }
    }
}
