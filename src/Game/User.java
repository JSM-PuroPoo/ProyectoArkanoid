/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Cronometro.CronometroP;

/**
 *
 * @author nalis
 */
public class User {

    private String name;
    private int ranking;
    private long score;
    CronometroP gmTime;

    public User(long score, CronometroP gmTime) {
        this.score = score;
        this.gmTime = gmTime;
        if (gmTime.getHour() != 0) {
            this.score -= (gmTime.getHour() + 1) * 5;
        }
        if (gmTime.getMin() != 0) {
            this.score -= (gmTime.getMin() + 1) * 4;
        }
        if (gmTime.getSeg() != 0) {
            this.score -= (gmTime.getSeg() + 1) * 3;
        }
        if (gmTime.getMiliseg() != 0) {
            this.score -= (gmTime.getMiliseg() + 1) * 2;
        }
    }

    public User(String name, long score, CronometroP gmTime) {
        this(score, gmTime);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getScore() {
        return score;
    }

    public CronometroP getGmTime() {
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
}
