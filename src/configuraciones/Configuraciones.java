package configuraciones;

public class Configuraciones {

    private boolean sonido;
    private boolean musica;
    private int cantidadPelotas;
    private int dificultad;
    public int cantidadVentanas;
    private Observer[] observers;

    public Configuraciones(boolean sonido, boolean musica, int cantidadPelotas, int dificultad, Observer[] observers) {
        this.sonido = sonido;
        this.musica = musica;
        this.cantidadPelotas = cantidadPelotas;
        this.dificultad = dificultad;
        this.observers = observers;
        cantidadVentanas = observers.length;
    }

    public void cambiarConfiguraciones() {
        for (Observer observer : observers) {
            observer.actualizar(this);
        }
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
