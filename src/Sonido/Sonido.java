package Sonido;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author Juan Felipe
 */
public class Sonido {

    private Clip clip;
    private boolean condicion;

    public void cargarSonido(String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream audioIS = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioIS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reproducir(int segundos) {
        if (isCondicion()) {
            if (clip != null) {
                clip.setFramePosition(segundos);
                clip.start();
            }
        }
    }

    public void cambiarEstadoReproduccion() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
            } else {
                int segundos = 0;
                if (clip.getFramePosition() > 0) {
                    segundos = clip.getFramePosition();
                }
                reproducir(segundos);
            }
        }
    }

    public void cambiarVolumen(float valor) {
        if (clip != null && condicion) {
            try {
                FloatControl controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                controlVolumen.setValue(20.0f * (float) Math.log10(valor));
            } catch (Exception e) {
                //System.out.println("Error al cambiar el volumen: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public Clip getClip() {
        return clip;
    }

    public void detener() {
        if (clip != null) {
            clip.stop();
        }
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }

   

}
