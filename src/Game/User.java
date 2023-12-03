package Game;

import Cronometro.CronometroP;
import archivos.ArchivoJuego;

/**
 * @author Juan Felipe Eraso Navarro 0222220038
 * @author Melissa Andrea Pizarro Duarte 0222220004
 * @author Sofhia Alejandra Prasca Teheran 0222220014
 */
public class User {

    private String name;
    private int ranking;
    private long score;
    String gmTime;

    public User(long score, String gmTime) {
        this.score = score;
        this.gmTime = gmTime;
    }

    public User(int ranking, String name, long score, String gmTime) {
        this.name = name;
        this.ranking = ranking;
        this.score = score;
        this.gmTime = gmTime;
    }

    public String getName() {
        return name;
    }

    public long getScore() {
        return score;
    }

    public String getGmTime() {
        return gmTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void calcularRanking() {

    }

    public boolean isNewRecord() {

        return false;
    }
}
