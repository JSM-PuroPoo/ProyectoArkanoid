/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import componente.Bloque;
import componente.PanelComponente;
import componente.Pelota;
import componente.Raqueta;
import interfaz.paneles.PanelIMG;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Comparator;

public class PanelJuego extends PanelIMG {

    private Bloque bloques[];
    private Pelota pelotas[];
    private Raqueta raqueta;
    private PanelIMG game;
    private PanelIMG marco;
    public int contPelotas;
    public int contBloques;
    public String rutaFondo;
    public String rutaFJuego;
    public String rutaMarco;

    public PanelJuego(Bloque bloques[], String rutaFondo, String rutaFJuego, String rutaMarco) {
        this.bloques = bloques;
        pelotas = new Pelota[50];
        contPelotas = 0;
        contBloques = bloques.length;
        this.rutaFondo = rutaFondo;
        this.rutaFJuego = rutaFJuego;
        this.rutaMarco = rutaMarco;
        this.setImage(rutaFondo);
        game = new PanelIMG(rutaFJuego);
        this.setLayout(null);
        marco = new PanelIMG(rutaMarco);
        this.setOpaque(false);
        marco.setBounds(0, 0, 1200, 675);
        marco.setOpaque(false);
        marco.setLayout(null);
        this.setBounds(0, 0, 1200, 675);
        this.add(marco);
        this.add(game);
        game.setOpaque(false);
        game.setBounds(30, 30, 856, 615);
        game.setLayout(null);
        game.setOpaque(false);
        raqueta = new Raqueta(game);
        game.add(raqueta);

    }

    public void agregarPelota(Pelota pelota) {
        if (contPelotas < 50) {
            new Thread(pelota).start();
            pelota.setR(raqueta);
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

    /*public void eliminarBloque(Bloque bloque) {
        for (int i = 0; i < contBloques; i++) {
            if (bloques[i].equals(bloque)) {
                bloques[i] = null;
                ordenarArray(bloques);
                contBloques--;
                break;
            }
        }
    }*/
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

    public PanelIMG getGame() {
        return game;
    }

    public void setGame(PanelIMG game) {
        this.game = game;
    }

    public PanelIMG getMarco() {
        return marco;
    }

    public void setMarco(PanelIMG marco) {
        this.marco = marco;
    }

    @Override
    public void paintComponents(Graphics graphics) {
        super.paintComponent(graphics);
        for (Bloque obj : bloques) {
            game.add(obj);
            obj.paint(graphics);
        }
        game.paint(graphics);
    }
}
