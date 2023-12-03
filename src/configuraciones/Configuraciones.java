package configuraciones;
/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class Configuraciones {

    private boolean sonido;
    private boolean musica;
    private int cantidadPelotas;
    private int dificultad;

    public Configuraciones() {
    }

    public Configuraciones(boolean sonido, boolean musica, int cantidadPelotas, int dificultad) {
        this.sonido = sonido;
        this.musica = musica;
        this.cantidadPelotas = cantidadPelotas;
        this.dificultad = dificultad;
    }

    public Configuraciones copiar() {
        return new Configuraciones(sonido, musica, cantidadPelotas, dificultad);
    }

    public boolean isSonido() {
        return sonido;
    }

    public void setSonido(boolean sonido) {
        this.sonido = sonido;
    }

    public boolean isMusica() {
        return musica;
    }

    public void setMusica(boolean musica) {
        this.musica = musica;
    }

    public int getCantidadPelotas() {
        return cantidadPelotas;
    }

    public void setCantidadPelotas(int cantidadPelotas) {
        this.cantidadPelotas = cantidadPelotas;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

}
