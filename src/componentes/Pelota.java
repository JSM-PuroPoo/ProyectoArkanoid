package componentes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class Pelota extends Componente {

    public Pelota(Color color, Rectangle r, int vX, int vY) {
        super(color, r, vX, vY);
    }

    public Pelota(Rectangle r, int vX, int vY, Container contenedor) {
        super(r, vX, vY, contenedor);
        try {
            this.setImage(ImageIO.read(new File("recursos/pelota.png")));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage buffer = new BufferedImage(r.width, r.height, BufferedImage.TYPE_INT_ARGB);
        Graphics bufferGraphics = buffer.getGraphics();
        bufferGraphics.drawImage(image, 0, 0, null);
        g.drawImage(buffer, r.x, r.y, null);
    }

    @Override
    public void mover() {
        r.x += vX;
        r.y += vY;

        if (r.x < 0 || r.x > contenedor.getWidth() - r.width) {
            vX = -vX;
        }
        if (r.y < 0 || r.y > contenedor.getHeight() - r.height) {
            vY = -vY;
        }
    }
}
