package app;

import interfaz.Juego;
import Sonido.Sonido;
import configuraciones.Configuraciones;
import configuraciones.Observer;
import interfaz.Inicio;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class App {

    public static void main(String[] args) {
        Inicio inicio = new Inicio();
        Observer observers[] = new Observer[]{inicio};
        Configuraciones configuraciones = new Configuraciones(true, true, 1, 2, observers);
        inicio.setVisible(true);
    }
}
