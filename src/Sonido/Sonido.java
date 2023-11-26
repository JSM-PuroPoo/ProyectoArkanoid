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

    public void cargarSonido(String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream audioIS = AudioSystem.getAudioInputStream(archivo);
            clip = AudioSystem.getClip();
            clip.open(audioIS);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void reproducir(int segundos) {
        if (clip != null) {
            clip.setFramePosition(segundos);
            clip.start();
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
        if (clip != null) {
            FloatControl controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            controlVolumen.setValue(20.0f * (float) Math.log10(valor));
        }
    }
}
