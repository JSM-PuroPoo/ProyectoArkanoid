/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import componente.Bloque;
import componente.PanelComponente;
import componente.Pelota;
import interfaz.paneles.PanelIMG;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JPanel;

public class PanelJuego extends PanelIMG {

    private Bloque bloques[];
    private Pelota pelotas[];
    public int contPelotas;
    public int contBloques;

    public PanelJuego(Bloque bloques[]) {
        this.bloques = bloques;
        pelotas = new Pelota[50];
        contPelotas = 0;
        contBloques = bloques.length;
    }

    public void agregarPelota(Pelota pelota) {
        if (contPelotas < 50) {
            pelotas[contPelotas++] = pelota;
        }
    }

    public void eliminarPelota(Pelota pelota) {
        for (int i = 0; i < contPelotas; i++) {
            if (pelotas[i].equals(pelota)) {
                pelotas[i] = null;
                ordenarArray(pelotas);
                contPelotas--;
                break;
            }
        }
    }

    public void eliminarBloque(Bloque bloque) {
        for (int i = 0; i < contBloques; i++) {
            if (bloques[i].equals(bloque)) {
                bloques[i] = null;
                ordenarArray(bloques);
                contBloques--;
                break;
            }
        }
    }

    public Bloque[] getBloques() {
        return bloques;
    }

    public Pelota[] getPelotas() {
        return pelotas;
    }

    public int getContPelotas() {
        return contPelotas;
    }

    public void ordenarArray(PanelComponente array[]) {
        Comparator<PanelComponente> customComparator = (a, b) -> {
            if (a == null && b == null) {
                return 0;
            }
            if (a == null) {
                return 1;
            }
            if (b == null) {
                return -1;
            }
            return 0;
        };
        Arrays.sort(array, customComparator);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Bloque obj : bloques) {
            obj.paint(graphics);
        }
    }
}
