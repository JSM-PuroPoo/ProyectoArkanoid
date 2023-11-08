/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.paneles;

import componentes.Componente;
import interfaz.paneles.PanelIMG;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.swing.JPanel;

public class PanelJuego extends PanelIMG {

    private PanelHilo componentes[];
    public int n;
   

    public PanelJuego() {
        n = 1;
    }

    public void agregar(PanelHilo comp) {
        if (n == 1) {
            componentes = new PanelHilo[n];
            componentes[0] = comp;
            n++;
        } else if (n > 1) {
            componentes = Arrays.copyOf(componentes, n);
            componentes[n - 1] = comp;
            n++;
        }
    }

    @Override
    public void paintComponents(Graphics graphics) {
        super.paintComponents(graphics);
        for (PanelHilo componente : componentes) {
            new Thread(componente).start();
            componente.getComponente().paint(graphics);
        }
    }

}
